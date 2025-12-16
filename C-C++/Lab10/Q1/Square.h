#ifndef SQUARE_H
#define SQUARE_H

#include "Rect.h"

class Square : public Rect
{
public:
    Square(float x);
    void setSide(float length);
    float calcArea();
};

#endif 