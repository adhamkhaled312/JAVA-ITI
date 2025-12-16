#ifndef TRIANGLE_H
#define TRIANGLE_H

#include "GeoShape.h"

class Triangle : public GeoShape
{
public:
    Triangle(float b, float h);
    float calcArea();
};

#endif 