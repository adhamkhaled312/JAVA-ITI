#ifndef DERIVED_H
#define DERIVED_H

#include "Base.h"

class Derived : public Base
{
private:
    int c;

public:
    Derived();                          
    Derived(int n);                     
    Derived(int x, int y, int z);

    void setC(int z);
    int getC();

    int calculateSum();
    int calculateSum(int x);

};

#endif 