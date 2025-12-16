#ifndef COMPLEX_H
#define COMPLEX_H

#include <iostream>
using namespace std;
class Complex
{
private:
	float real;
	float imag;

public:
	Complex();
	Complex(float r);
	Complex(float r, float i);
	~Complex();
	void setAll();
	void setAll(float f);
	void setAll(float r, float i);
	float getReal();
	float getImag();
	Complex add(Complex c);
	Complex sub(Complex c);
	void print();
	Complex operator + (Complex& c);
	Complex operator + (float f);
	Complex operator ++ ();
	Complex operator ++ (int dummy);
	Complex& operator = (const Complex& c);
	Complex& operator += (Complex& c);
	int operator == (Complex& c);
	explicit operator float();
	friend Complex operator +(float f, Complex& c);
	friend istream& operator>>(istream& in, Complex& c);
	friend ostream& operator<<(ostream& out, Complex& c);

};

Complex operator +(float f, Complex& c);
istream& operator >>(istream& in, Complex& c);
ostream& operator<<(ostream& out, Complex& c);

#endif