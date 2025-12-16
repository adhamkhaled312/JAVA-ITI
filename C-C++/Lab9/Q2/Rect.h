#ifndef RECT_H
#define RECT_H

#include "GeoShape.h"

class Rect : public GeoShape
{
public:
    Rect(float x, float y);
    float calcArea() ;
};

#endif 