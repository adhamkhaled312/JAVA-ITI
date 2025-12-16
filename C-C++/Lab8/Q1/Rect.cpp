#include "Rect.h"

Rect::Rect() : UL(), LR()
{
    cout << "Rect default constructor is calling" << endl;
}

Rect::Rect(int x1, int y1, int x2, int y2) : UL(x1, y1), LR(x2, y2)
{
    cout << "Rect constructor with 4 parameters is calling" << endl;
}

Rect::~Rect()
{
    cout << "Rect destructor is calling" << endl;
}

void Rect::print()
{
    cout << "\nUpper Left: ";
    UL.print();
    cout << "\nLower Right: ";
    LR.print();
}