#include "Stack.h"

int Stack::counter = 0;

Stack::Stack() {
    top = 0;
    size = 10;
    ptr = new int[size];
    cout << "Default Constructor\n";
    counter++;
}

Stack::Stack(int n) {
    top = 0;
    size = n;
    ptr = new int[size];
    cout << "Constructor with one parameter\n";
    counter++;
}
Stack::Stack(const Stack& s) {
    size = s.size;
    top = s.top;
    ptr = new int[size];
    for (int i = 0; i < top; i++) {
        ptr[i] = s.ptr[i];
    }
    cout << "Copy Constructor\n";
    counter++;
}


Stack::~Stack() {
    delete[] ptr;
    cout << "Destructor\n";
    counter--;
}

int Stack::getCounter() {
    return counter;
}

bool Stack::isFull() {
    return top == size;
}

bool Stack::isEmpty() {
    return top == 0;
}

int Stack::push(int n) {
    if (isFull())
        return 0;

    ptr[top] = n;
    top++;
    return 1;
}

int Stack::pop(int& n) {
    if (isEmpty())
        return 0;

    top--;
    n = ptr[top];
    return 1;
}

void viewContent(Stack& s) {
    for (int i = 0; i < s.top; i++) {
        cout << "Element number " << i + 1 << " = " << s.ptr[i] << endl;
    }
}

Stack& Stack::operator = (Stack& s) {
    size = s.size;
    top = s.top;
    delete[] ptr;
    ptr = new int[size];
    for (int i = 0; i < top; i++) {
        ptr[i] = s.ptr[i];
    }
    return *this;
}
