#include "Base.h"

Base::Base()
{
    a = b = 0;
}

Base::Base(int n)
{
    a = b = n;
}

Base::Base(int x, int y)
{
    a = x;
    b = y;
}

void Base::setA(int x)
{
    a = x;
}

void Base::setB(int y)
{
    b = y;
}

int Base::getA()
{
    return a;
}

int Base::getB()
{
    return b;
}

int Base::calculateSum()
{
    return a + b;
}