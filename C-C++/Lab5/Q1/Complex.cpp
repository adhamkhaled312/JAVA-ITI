#include"Complex.h"
#include <iostream>
#include<cmath>
using namespace std;

Complex::Complex() {
	real = imag = 0;
	cout << "Default constructor\n";
}

Complex::Complex(float r) {
	cout << "Single-argument constructor\n";
	real = r;
	imag = 0;
}

Complex::Complex(float r, float i) {
	cout << "Two-argument constructor\n";
	real = r;
	imag = i;
}

Complex:: ~Complex() {
	cout << "Destructor \n";
}

void Complex::setReal(float r) {
	real = r;

}

void Complex::setImag(float i) {
	imag = i;
}

float Complex::getReal() {
	return real;
}

float Complex::getImag() {
	return imag;
}

Complex Complex::add(Complex c) {
	Complex t;
	t.real = real + c.real;
	t.imag = imag + c.imag;
	return t;
}

Complex Complex::sub(Complex c) {
	Complex t;
	t.real = real - c.real;
	t.imag = imag - c.imag;
	return t;
}

void Complex::print() {
	if (imag < 0) {
		cout << real << " - " << abs(imag) << "i\n";
	}
	else
	{
		cout << real << " + " << abs(imag) << "i\n";
	}
}