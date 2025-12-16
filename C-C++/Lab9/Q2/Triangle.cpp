#include "Triangle.h"

Triangle::Triangle(float b, float h) : GeoShape(b, h)
{
}

float Triangle::calcArea()
{
    return 0.5f * dim1 * dim2;
}