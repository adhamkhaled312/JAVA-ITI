#include "Square.h"

Square::Square(float x) : Rect(x, x)
{
}

void Square::setSide(float length)
{
    dim1 = dim2 = length;
}

float Square::calcArea()
{
    return dim1 * dim2;
}