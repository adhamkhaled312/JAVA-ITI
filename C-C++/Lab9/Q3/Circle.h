#ifndef CIRCLE_H
#define CIRCLE_H

#include "GeoShape.h"

class Circle : protected GeoShape
{
public:
    Circle(float r);
    void setRadius(float rad);
    float calcArea();
};

#endif 