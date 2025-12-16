#ifndef POINT_H
#define POINT_H

#include <iostream>
using namespace std;

class Point
{
private:
    int x;
    int y;

public:
    Point();                     
    Point(int m);                
    Point(int m, int n);         
    ~Point();                    

    void setX(int m);
    void setY(int n);
    void setXY(int m, int n);

    int getX();
    int getY();

    void print();
};

#endif