#ifndef CIRCLE_H
#define CIRCLE_H

#include "GeoShape.h"

class Circle : public GeoShape
{
public:
    Circle(float r);
    float calcArea();
};

#endif 