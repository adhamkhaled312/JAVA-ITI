#ifndef STACK_H
#define STACK_H

#include <iostream>
using namespace std;

class Stack {
private:
    int size;
    int top;
    int* ptr;
    static int counter;

public:
    Stack();
    Stack(int n);
    Stack(const Stack& s);
    ~Stack();
    static int getCounter();
    bool isFull();
    bool isEmpty();
    int push(int n);
    int pop(int& n);
    friend void viewContent(Stack& s);
};

void viewContent(Stack& s);

#endif
