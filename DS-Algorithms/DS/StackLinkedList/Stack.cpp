#include<iostream>
using namespace std;
class Node {
public:
	int data;
	Node* next;
	Node(int data) : data(data), next(nullptr) {}
};
class Stack {
private:
	Node* top;
public:
	Stack() { top = nullptr; } // Initialize top to -1 to indicate an empty stack
	bool isEmpty() { return (top == nullptr); }
	void push(int element) {
		Node* temp = new Node(element);
		temp->next = top;
		top = temp;
		std::cout << "Pushed element: " << element << " onto the stack.\n";
	}
	void pop() {
		if (!isEmpty()) {
			Node* temp = top;
			int poppedElement = top->data;
			top = top->next;
			delete temp;
			std::cout << "Popped element: " << poppedElement << " from the stack.\n";
		}
		else {
			std::cout << "Stack is empty. Cannot pop from an empty stack.\n";
		}
	}
	int topElement() {
		if (!isEmpty()) {
			return top->data;
		}
		else {
			std::cout << "Stack is empty.\n";
			return -1; // In this example, we consider -1 as an invalid value.
		}
	}
};

int main() {
	Stack s;

	cout << "=== Test pushing elements ===" << endl;
	s.push(10);
	s.push(20);
	s.push(30);
	s.push(40);
	s.push(50);
	s.push(60); 

	cout << "\n=== Test top element ===" << endl;
	cout << "Top element: " << s.topElement() << endl;

	cout << "\n=== Test popping elements ===" << endl;
	s.pop();
	s.pop();

	cout << "\n=== Test top element after popping ===" << endl;
	cout << "Top element: " << s.topElement() << endl;

	cout << "\n=== Test popping all elements ===" << endl;
	s.pop();
	s.pop();
	s.pop();
	s.pop();
	s.pop();

	cout << "\n=== Test top element on empty stack ===" << endl;
	cout << "Top element: " << s.topElement() << endl;

	return 0;
}