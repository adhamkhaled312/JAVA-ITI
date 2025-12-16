#ifndef RECT_H
#define RECT_H

#include <iostream>
#include "Point.h"
using namespace std;

class Rect
{
private:
    Point UL;  
    Point LR;  

public:
    Rect();                                   
    Rect(int x1, int y1, int x2, int y2);     
    ~Rect();                                  

    void print();                            
};

#endif