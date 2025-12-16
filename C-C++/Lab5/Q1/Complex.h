#ifndef COMPLEX_H
#define COMPLEX_H
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
	void setReal(float r);
	void setImag(float i);
	float getReal();
	float getImag();
	Complex add(Complex c);
	Complex sub(Complex c);
	void print();
};

#endif