#include <iostream>
#include "GeoShape.h"
#include "Rect.h"
#include "Square.h"
#include "Triangle.h"
#include "Circle.h"

using namespace std;

int main()
{
    Triangle myT(20, 10);
    cout << "Triangle area = " << myT.calcArea() << endl;

    Circle myC(7);
    cout << "Circle area = " << myC.calcArea() << endl;

    Rect myR(2, 5);
    cout << "Rectangle area = " << myR.calcArea() << endl;

    Square myS(5);
    cout << "Square area = " << myS.calcArea() << endl;

     myS.setDim2(4); // Violating the square constraint
     myC.setDim2(3); // Violating the circle constraint

    return 0;
}