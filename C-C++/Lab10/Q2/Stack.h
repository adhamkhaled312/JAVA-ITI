#ifndef STACK_H
#define STACK_H

#include <iostream>
using namespace std;

template<class T>
class Stack {
private:
    int size;
    int top;
    T* ptr;
    static int counter;

public:
    Stack() {
        top = 0;
        size = 10;
        ptr = new T[size];
        cout << "Default Constructor\n";
        counter++;
    }

    Stack(int n) {
        top = 0;
        size = n;
        ptr = new T[size];
        cout << "Constructor with one parameter\n";
        counter++;
    }

    Stack(const Stack<T>& s) {
        size = s.size;
        top = s.top;
        ptr = new T[size];
        for (int i = 0; i < top; i++) {
            ptr[i] = s.ptr[i];
        }
        cout << "Copy Constructor\n";
        counter++;
    }

    ~Stack() {
        delete[] ptr;
        cout << "Destructor\n";
        counter--;
    }

    static int getCounter() {
        return counter;
    }

    bool isFull() {
        return top == size;
    }

    bool isEmpty() {
        return top == 0;
    }

    int push(T n) {
        if (isFull())
            return 0;

        ptr[top] = n;
        top++;
        return 1;
    }

    int pop(T& n) {
        if (isEmpty())
            return 0;

        top--;
        n = ptr[top];
        return 1;
    }

    Stack<T>& operator = (const Stack<T>& s) {
        if (this != &s) {
            delete[] ptr;
            size = s.size;
            top = s.top;
            ptr = new T[size];
            for (int i = 0; i < top; i++) {
                ptr[i] = s.ptr[i];
            }
        }
        return *this;
    }

    template<class U>
    friend void viewContent(Stack<U>& s);
};

template<class T>
int Stack<T>::counter = 0;

template<class T>
void viewContent(Stack<T>& s) {
    for (int i = 0; i < s.top; i++) {
        cout << "Element number " << i + 1 << " = " << s.ptr[i] << endl;
    }
}

#endif
