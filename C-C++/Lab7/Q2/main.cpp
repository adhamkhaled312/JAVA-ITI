#include <iostream>
#include "Stack.h"
using namespace std;

int main() {
	Stack s1(5);
	Stack s2(10);

	s1.push(1);
	s1.push(2);
	s1.push(3);
	s1.push(4);

	s2.push(1);
	s2.push(21);
	s2.push(15);
	s2.push(13);
	s2.push(11);
	s2.push(13);
	s2.push(15);
	s2.push(32);
	s2.push(24);
	viewContent(s1);
	viewContent(s2);
	cout << endl;
	s1 = s2;	
	viewContent(s1);
	viewContent(s2);


}