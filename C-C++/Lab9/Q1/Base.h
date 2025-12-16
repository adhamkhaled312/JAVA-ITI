#ifndef BASE_H
#define BASE_H

class Base
{
protected:
    int a;
    int b;

public:
    Base();                    
    Base(int n);               
    Base(int x, int y);        

    void setA(int x);
    void setB(int y);

    int getA();
    int getB();

    int calculateSum();
};

#endif 