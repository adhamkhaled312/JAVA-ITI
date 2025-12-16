#include <iostream>
#include <conio.h>     
#include "Circle.h"
#include "Rect.h"
#include "Line.h"
#include "Picture.h"

using namespace std;

//int main()
//{
//    Circle c1(250, 150, 100);
//    Rect r1(10, 100, 90, 350);
//    Line l1(30, 100, 350, 400);
//
//    c1.print();
//    r1.print();
//    l1.print();
//
//    return 0;
//}
int main()
{
    Picture myPic;

    Circle cArr[3] = {
        Circle(50, 50, 50),
        Circle(200, 100, 100),
        Circle(420, 50, 30)
    };

    Rect rArr[2] = {
        Rect(30, 40, 170, 100),
        Rect(420, 50, 500, 300)
    };

    Line lArr[2] = {
        Line(420, 50, 300, 300),
        Line(40, 500, 500, 400)
    };

    myPic.setCircles(3, cArr);
    myPic.setRects(2, rArr);
    myPic.setLines(2, lArr);

    myPic.print();

    return 0;
}