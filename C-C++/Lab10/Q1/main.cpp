#include <iostream>
#include "GeoShape.h"
#include "Rect.h"
#include "Square.h"
#include "Circle.h"

using namespace std;
float sumOfAreas(GeoShape* shape1, GeoShape* shape2, GeoShape* shape3);
int main()
{
    Circle myC(7);
    cout << "Circle area = " << myC.calcArea() << endl;

    Rect myR(2, 5);
    cout << "Rectangle area = " << myR.calcArea() << endl;

    Square myS(5);
    cout << "Square area = " << myS.calcArea() << endl;

    cout << "The sum of all areas = "<<sumOfAreas(&myC, &myR, &myS);

    return 0;
}

float sumOfAreas(GeoShape* shape1, GeoShape* shape2, GeoShape* shape3) {
    return shape1->calcArea() + shape2->calcArea() + shape3->calcArea();
}