#include "Circle.h"

Circle::Circle() : center(), rad(0)
{
    cout << "Circle default constructor is calling" << endl;
}

Circle::Circle(int x1, int y1, int r) : center(x1, y1), rad(r)
{
    cout << "Circle constructor with 3 parameters is calling" << endl;
}

Circle::~Circle()
{
    cout << "Circle destructor is calling" << endl;
}

void Circle::print()
{
    cout << "\nCenter: ";
    center.print();
    cout << "\nRadius = " << rad << endl;
}