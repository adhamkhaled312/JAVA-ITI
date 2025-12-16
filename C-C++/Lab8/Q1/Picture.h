#ifndef PICTURE_H
#define PICTURE_H

#include <iostream>
#include "Circle.h"
#include "Rect.h"
#include "Line.h"
using namespace std;

class Picture
{
private:
    int cNum;
    int rNum;
    int lNum;
    Circle* pCircles;
    Rect* pRects;
    Line* pLines;

public:
    Picture();
    Picture(int cn, int rn, int ln, Circle* pC, Rect* pR, Line* pL);
    ~Picture();
    void setCircles(int cn, Circle* cptr);
    void setRects(int rn, Rect* rptr);
    void setLines(int ln, Line* lptr);

    void print();
};

#endif 