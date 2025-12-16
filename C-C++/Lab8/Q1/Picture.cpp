#include "Picture.h"

Picture::Picture()
{
    cNum = 0;
    rNum = 0;
    lNum = 0;
    pCircles = NULL;
    pRects = NULL;
    pLines = NULL;
    cout << "Picture default constructor is calling" << endl;

}

Picture::Picture(int cn, int rn, int ln, Circle* pC, Rect* pR, Line* pL)
{
    cNum = cn;
    rNum = rn;
    lNum = ln;
    pCircles = pC;
    pRects = pR;
    pLines = pL;
    cout << "Circle with 6 parameters constructor is calling" << endl;

}

void Picture::setCircles(int cn, Circle* cptr)
{
    cNum = cn;
    pCircles = cptr;
}

void Picture::setRects(int rn, Rect* rptr)
{
    rNum = rn;
    pRects = rptr;
}

void Picture::setLines(int ln, Line* lptr)
{
    lNum = ln;
    pLines = lptr;
}

void Picture::print()
{
    int i;
    for (i = 0; i < cNum; i++)
    {
        pCircles[i].print();
    }

    for (i = 0; i < rNum; i++)
    {
        pRects[i].print();
    }

    for (i = 0; i < lNum; i++)
    {
        pLines[i].print();
    }
}
Picture::~Picture(){
    cout << "Circle destructor is calling" << endl;
}
