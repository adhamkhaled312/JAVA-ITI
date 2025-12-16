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

void Complex::setAll() {
	real = imag = 0;
}
void Complex::setAll(float f) {
	real = f;
	imag = f;
}
void Complex::setAll(float r, float i) {
	real = r;
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
Complex Complex::operator+(Complex& c) {
	return Complex(real + c.real, imag + c.imag);

}
Complex Complex::operator+(float f) {
	return Complex(real + f, imag);;
}
Complex operator +(float f, Complex& c) {
	return c + f;
}
Complex Complex::operator ++ () {
	real++;
	imag++;
	return *this;
}
Complex Complex::operator ++ (int dummy) {
	Complex temp(*this);
	real++;
	imag++;
	return temp;
}
Complex& Complex::operator = (const Complex& c) {
	real = c.real;
	imag = c.imag;
	return *this;
}
Complex& Complex::operator += (Complex& c) {
	real += c.real;
	imag += c.imag;
	return *this;
}
int Complex::operator == (Complex& c) {
	return(real == c.real && imag == c.imag);
}
Complex::operator float() {
	return real;
}
istream& operator >>(istream& in, Complex& c) {
	cout << "Enter the real part\n";
	in >> c.real;
	cout << "Enter the imag part\n";
	in >> c.imag;
	return in;
}
ostream& operator<<(ostream& out, Complex& c) {
	if (c.imag < 0)
		out << c.real << "-" << fabs(c.imag) << 'i' << endl;
	else
		out << c.real << "+" << fabs(c.imag) << 'i' << endl;
	return out;
}

