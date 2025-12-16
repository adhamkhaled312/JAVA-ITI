#include <iostream>
#include "Stack.h"

using namespace std;

int main() {
	int num;
	Stack s1(5);
	s1.push(5);
	s1.push(14);
	s1.push(20);

	viewContent(s1);
	if (s1.pop(num)) {
		cout << num << endl;
	}
	Stack s2(s1);
	viewContent(s2);

	return 0;
}
