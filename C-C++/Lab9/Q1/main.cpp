#include <iostream>
#include "Base.h"
#include "Derived.h"

using namespace std;

int main()
{
    //Base b(5, 4);
    //cout << "Base sum: " << b.calculateSum() << endl; 

    Derived obj1;
    //obj1.setA(3);
    //obj1.setB(7);
    obj1.setC(1);

    Derived obj2(20);
    Derived obj3(4, 5, 6);
    Base& b = obj2;
    //b.calculateSum(4);

    cout<<obj2.calculateSum(4)<<endl;


    cout << "obj1: " << obj1.calculateSum() << endl;  
    cout << "obj2: " << obj2.calculateSum() << endl;  
    cout << "obj3: " << obj3.calculateSum() << endl;  

    //cout << "obj1 (Base sum): " << obj1.Base::calculateSum() << endl;

    return 0;
}