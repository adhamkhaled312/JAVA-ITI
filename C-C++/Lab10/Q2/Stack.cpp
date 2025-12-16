#include "Stack.h"

template<class T>
int Stack<T>::counter = 0;

template<class T>
Stack<T>::Stack() {
    top = 0;
    size = 10;
    ptr = new T[size];
    cout << "Default Constructor\n";
    counter++;
}

template<class T>
Stack<T>::Stack(int n) {
    top = 0;
    size = n;
    ptr = new T[size];
    cout << "Constructor with one parameter\n";
    counter++;
}
template<class T>
Stack<T>::Stack(const Stack<T>& s) {
    size = s.size;
    top = s.top;
    ptr = new T[size];
    for (int i = 0; i < top; i++) {
        ptr[i] = s.ptr[i];
    }
    cout << "Copy Constructor\n";
    counter++;
}

template<class T>
Stack<T>::~Stack() {
    delete[] ptr;
    cout << "Destructor\n";
    counter--;
}

template<class T>
int Stack<T>::getCounter() {
    return counter;
}

template<class T>
bool Stack<T>::isFull() {
    return top == size;
}

template<class T>
bool Stack<T>::isEmpty() {
    return top == 0;
}

template<class T>
int Stack<T>::push(T n) {
    if (isFull())
        return 0;

    ptr[top] = n;
    top++;
    return 1;
}

template<class T>
int Stack<T>::pop(T& n) {
    if (isEmpty())
        return 0;

    top--;
    n = ptr[top];
    return 1;
}

template<class T>
void viewContent(Stack<T>& s) {
    for (int i = 0; i < s.top; i++) {
        cout << "Element number " << i + 1 << " = " << s.ptr[i] << endl;
    }
}

template<class T>
Stack<T>& Stack<T>::operator = (Stack<T>& s) {
    size = s.size;
    top = s.top;
    delete[] ptr;
    ptr = new T[size];
    for (int i = 0; i < top; i++) {
        ptr[i] = s.ptr[i];
    }
    return *this;
}
