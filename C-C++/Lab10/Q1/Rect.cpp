#include "Rect.h"

Rect::Rect(float x, float y) : GeoShape(x, y)
{
}

float Rect::calcArea()
{
    return dim1 * dim2;
}