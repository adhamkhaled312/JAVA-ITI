#include <iostream>
#include "Complex.h"

using namespace std;

int main()
{
    Complex c1(12, 7), c2(10, -5);
    Complex c3;
    c3 = c1 + c2;
    c3.print();

    c3 = c1 + 13.65;
    c3.print();
    float f = float(c3);
    cout << f << endl;

    c3 = 6.2 + c2;
    c3.print();

    c3 = ++c1;
    c1.print();
    c3.print();

    c3 = c2++;
    c2.print();
    c3.print();

    c3 += c2;
    c3.print();

    c3 = c1 = c2;
    c1.print();
    c2.print();
    c3.print();
    if (c3 == c1) cout << "== operator works!\n";
    else "== operator not working\n";

    Complex c4;
    cin >> c4;
    cout << c4;

    return 0;
}