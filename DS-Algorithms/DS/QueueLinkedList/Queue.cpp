#include <iostream>
using namespace std;

// Node class (same as yours)
class Node {
public:
    int data;
    Node* next;
    Node(int data) : data(data), next(nullptr) {}
};

// Queue implemented using Linked List
class Queue {
private:
    Node* front;   // front of queue
    Node* rear;    // rear of queue
    int count;     // number of elements

public:
    Queue();               // constructor
    ~Queue();              // destructor

    void enqueue(int x);   // insert at rear
    int dequeue();         // remove from front
    int peek();            // front element
    int size();            // number of elements
    bool isEmpty();        // check empty
};

// Constructor
Queue::Queue() {
    front = nullptr;
    rear = nullptr;
    count = 0;
}

// Destructor
Queue::~Queue() {
    while (!isEmpty()) {
        dequeue();
    }
}

// Returns size
int Queue::size() {
    return count;
}

// Returns if empty
bool Queue::isEmpty() {
    return (size() == 0);
}

// Enqueue: insert at rear
void Queue::enqueue(int x) {
    Node* newNode = new Node(x);
    cout << "Inserting " << x << endl;

    if (isEmpty()) {
        front = rear = newNode;
    }
    else {
        rear->next = newNode;
        rear = newNode;
    }
    count++;
}

// Dequeue: remove from front
int Queue::dequeue() {
    if (isEmpty()) {
        cout << "Underflow\nProgram Terminated\n";
        exit(EXIT_FAILURE);
    }

    Node* temp = front;
    int value = temp->data;

    cout << "Removing " << value << endl;

    front = front->next;
    if (front == nullptr) {
        rear = nullptr;  // queue becomes empty
    }

    delete temp;
    count--;
    return value;
}

// Peek: front element
int Queue::peek() {
    if (isEmpty()) {
        cout << "Underflow\nProgram Terminated\n";
        exit(EXIT_FAILURE);
    }
    return front->data;
}
int main() {
    Queue q;

    q.enqueue(10);
    q.enqueue(20);
    q.enqueue(30);

    cout << "Front element: " << q.peek() << endl;
    cout << "Queue size: " << q.size() << endl;

    q.dequeue();
    q.dequeue();

    q.enqueue(40);
    q.enqueue(50);

    cout << "Front element now: " << q.peek() << endl;
    cout << "Queue size now: " << q.size() << endl;

    while (!q.isEmpty()) {
        q.dequeue();
    }

    return 0;
}
