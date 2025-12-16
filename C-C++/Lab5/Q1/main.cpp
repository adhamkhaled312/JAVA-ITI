#include <iostream>
#include "Complex.h"

using namespace std;

int main()
{
    Complex myComp1, myComp2(3, 4), resultComp(5);
    myComp1.setReal(7);
    myComp1.setImag(2);
    resultComp = myComp1.add(myComp2);
    resultComp.print();
    resultComp = myComp1.sub(myComp2);
    resultComp.print();
    return 0;
}

