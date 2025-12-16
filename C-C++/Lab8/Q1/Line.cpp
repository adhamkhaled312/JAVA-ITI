#include "Line.h"

Line::Line() : start(), end()
{
    cout << "Line default constructor is calling" << endl;
}

Line::Line(int x1, int y1, int x2, int y2) : start(x1, y1), end(x2, y2)
{
    cout << "Line constructor with 4 parameters is calling" << endl;
}

Line::~Line()
{
    cout << "Line destructor is calling" << endl;
}

void Line::print()
{
    cout << "\nStart: ";
    start.print();
    cout << "\nEnd: ";
    end.print();
}