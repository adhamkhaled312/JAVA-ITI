#ifndef CIRCLE_H
#define CIRCLE_H

#include <iostream>
#include "Point.h"
using namespace std;

class Circle
{
private:
    Point center;
    int rad;

public:
    Circle();                             
    Circle(int x1, int y1, int r);        
    ~Circle();                            

    void print();                         
};

#endif 