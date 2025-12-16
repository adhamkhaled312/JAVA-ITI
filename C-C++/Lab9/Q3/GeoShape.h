#ifndef GEOSHAPE_H
#define GEOSHAPE_H

class GeoShape
{
protected:
    float dim1, dim2;

public:
    GeoShape();
    GeoShape(float x);
    GeoShape(float x, float y);

    void setDim1(float x);
    void setDim2(float x);

    float getDim1();
    float getDim2();

    virtual float calcArea() = 0;   
};

#endif
