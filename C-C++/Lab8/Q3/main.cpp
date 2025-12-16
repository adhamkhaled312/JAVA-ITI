#include <iostream>
#include "Complex.h"
using namespace std;

int main()
{

    Complex c1;             
    Complex c2(5);          
    Complex c3(3, 4);       

    Complex arr[3] = {Complex(),Complex(4,5),Complex(3)};

    Complex* cPtr = new Complex(10, 20);

    Complex* cArray = new Complex[4];

    return 0;
}