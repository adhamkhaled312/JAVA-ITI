#include "Derived.h"

Derived::Derived() : Base()
{
    c = 0;
}

Derived::Derived(int n) : Base(n)
{
    c = n;
}

Derived::Derived(int x, int y, int z) : Base(x, y)
{
    c = z;
}

void Derived::setC(int z)
{
    c = z;
}

int Derived::getC()
{
    return c;
}

int Derived::calculateSum(int x)
{
    //return a + b + c;
    return 1;
}
int Derived::calculateSum()
{
    //return a + b + c;
    return 2;
}