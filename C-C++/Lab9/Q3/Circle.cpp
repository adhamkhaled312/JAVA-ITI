#include "Circle.h"

Circle::Circle(float r) : GeoShape(r)
{
}

void Circle::setRadius(float rad)
{
    dim1 = dim2 = rad;
}

float Circle::calcArea()
{
    return 22.0/7 * dim1 * dim2;
}