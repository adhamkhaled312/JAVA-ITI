#include <iostream>
// Node class
class Node {
public:
	int data;
	Node* next;
	Node(int data) : data(data), next(nullptr) {}
};
class SingleLinkedList {
private:
	Node* head;
	Node* tail;
public:
	SingleLinkedList() : head(nullptr), tail(nullptr) {}
	// Function to get the length of the list
	int getLength() const {
		int length = 0;
		Node* current = head;
		while (current != nullptr) {
			++length;
			current = current->next;
		}
		return length;
	}
	// Function to insert at the front
	void insertFront(int data) {
		Node* newNode = new Node(data);
		if (head == nullptr) {
			head = tail = newNode;
		}
		else {
			newNode->next = head;
			head = newNode;
		}
	}
	// Function to insert at the back
	void insertBack(int data) {
		Node* newNode = new Node(data);
		if (tail == nullptr) {
			head = tail = newNode;
		}
		else {
			tail->next = newNode;
			tail = newNode;
		}
	}
	// Function to insert at a specific position
	void insertAtPosition(int data, int position) {
		if (position <= 0) {
			insertFront(data);
			return;
		}
		int length = getLength();
		if (position >= length) {
			insertBack(data);
			return;
		}
		Node* newNode = new Node(data);
		Node* current = head;
		for (int i = 0; i < position - 1; ++i) {
			current = current->next;
		}
		newNode->next = current->next;
		current->next = newNode;
	}
	// Function to delete a node with a specific value
	void deleteNode(int data) {
		Node* current = head;
		Node* prev = nullptr;;
		while (current != nullptr && current->data != data) {
			prev = current;
			current = current->next;
		}
		if (current == nullptr) {
			std::cout << "Node with value " << data << " not found." << std::endl;
				return;
		}
		if (current == head) {
			head = current->next;
			if (head == nullptr) tail = nullptr;
		}
		else if (current==tail) {
			tail = prev;
			tail->next = nullptr;
		}
		else {
			prev->next = current->next;
		}
		delete current;
	}
	// Function to print the list from front to back
	void printForward() const {
		Node* current = head;
		while (current != nullptr) {
			std::cout << current->data << " ";
			current = current->next;
		}
		std::cout << std::endl;
	}

	// Destructor to free memory
	~SingleLinkedList() {
		Node* current = head;
		while (current != nullptr) {
			Node* next = current->next;
			delete current;
			current = next;
		}
	}
};

int main() {
	SingleLinkedList list;

	std::cout << "=== Testing Insert Front ===\n";
	list.insertFront(30);
	list.insertFront(20);
	list.insertFront(10);
	list.printForward();  // Expected: 10 20 30

	std::cout << "\n=== Testing Insert Back ===\n";
	list.insertBack(40);
	list.insertBack(50);
	list.printForward();  // Expected: 10 20 30 40 50

	std::cout << "\n=== Testing Insert At Position ===\n";
	list.insertAtPosition(99, 2); // Insert after index 1
	list.printForward();  // Expected: 10 20 99 30 40 50

	std::cout << "\n=== Testing Delete Node (delete middle: 99) ===\n";
	list.deleteNode(99);
	list.printForward();  // Expected: 10 20 30 40 50

	std::cout << "\n=== Testing Delete Node (delete head: 10) ===\n";
	list.deleteNode(10);
	list.printForward();  // Expected: 20 30 40 50

	std::cout << "\n=== Testing Delete Node (delete tail: 50) ===\n";
	list.deleteNode(50);
	list.printForward();  // Expected: 20 30 40

	std::cout << "\n=== Testing Delete Node (not found: 999) ===\n";
	list.deleteNode(999); // Expected: not found message

	std::cout << "\n=== Testing Length ===\n";
	std::cout << "Length = " << list.getLength() << std::endl; // Expected: 3

	std::cout << "\n=== Final List ===\n";
	list.printForward();

	return 0;
}
