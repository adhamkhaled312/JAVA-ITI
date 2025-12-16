#include "Circle.h"

Circle::Circle(float r) : GeoShape(r)
{
}

float Circle::calcArea()
{
    return 22.0/7 * dim1 * dim1;
}