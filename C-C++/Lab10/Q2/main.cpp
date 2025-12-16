#include <iostream>
#include "Stack.h"
using namespace std;

int main()
{
    int n;

    Stack<int> s1(5);
    cout << "\nNo of Int Stacks is: " << Stack<int>::getCounter()<<endl;

    s1.push(10);
    s1.push(3);
    s1.push(2);

    s1.pop(n);
    cout << "\n1st integer: " << n<<endl;

    s1.pop(n);
    cout << "\n2nd integer: " << n<<endl;

    Stack<char> s2;
    char nc;

    cout << "\nNo of Char Stacks is: " << Stack<char>::getCounter()<<endl;


    s2.push('q');
    s2.push('r');
    s2.push('s');

    viewContent(s2);

    s2.pop(nc);
    cout << "\n1st character: " << nc<<endl;

    s2.pop(nc);
    cout << "\n2nd character: " << nc<<endl;

    return 0;
}
