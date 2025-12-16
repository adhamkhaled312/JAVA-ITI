#include "Point.h"

Point::Point()
{
    x = y = 0;
    cout << "Point default constructor is calling" << endl;
}

Point::Point(int m)
{
    x = y = m;
    cout << "Point one parameter constructor is calling" << endl;
}

Point::Point(int m, int n)
{
    x = m;
    y = n;
    cout << "Point two parameter constructor is calling" << endl;
}

Point::~Point()
{
    cout << "Point destructor is calling" << endl;
}

void Point::setX(int m)
{
    x = m;
}

void Point::setY(int n)
{
    y = n;
}

void Point::setXY(int m, int n)
{
    x = m;
    y = n;
}

int Point::getX()
{
    return x;
}

int Point::getY()
{
    return y;
}

void Point::print()
{
    cout << "\nPoint Data: x = " << x << "  y = " << y << endl;
}