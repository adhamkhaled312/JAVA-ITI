package ITI;
class Complex<T extends Number, R extends Number> {
    T real;
    R imag;

    Complex(T r, R i) {
        real = r;
        imag = i;
    }

    public Complex<Double, Double> add(Complex<? extends Number, ? extends Number> other) {
        double realSum = this.real.doubleValue() + other.real.doubleValue();
        double imagSum = this.imag.doubleValue() + other.imag.doubleValue();
        return new Complex<>(realSum, imagSum);
    }

    public Complex<Double, Double> subtract(Complex<? extends Number, ? extends Number> other) {
        double realDiff = this.real.doubleValue() - other.real.doubleValue();
        double imagDiff = this.imag.doubleValue() - other.imag.doubleValue();
        return new Complex<>(realDiff, imagDiff);
    }

    public Complex<Double, Double> multiply(Complex<? extends Number, ? extends Number> other) {
        double a = this.real.doubleValue();
        double b = this.imag.doubleValue();
        double c = other.real.doubleValue();
        double d = other.imag.doubleValue();

        double realPart = a * c - b * d;
        double imagPart = a * d + b * c;

        return new Complex<>(realPart, imagPart);
    }

    @Override
    public String toString() {
        return "(" + real + " + " + imag + "i)";
    }
}

public class GenericComplex {
    public static void main(String[] args) {
        Complex<Integer, Float> c1 = new Complex<>(2, 3.5f);
        Complex<Double, Double> c2 = new Complex<>(1.5, 2.5);

        System.out.println("c1 + c2 = " + c1.add(c2));
        System.out.println("c1 - c2 = " + c1.subtract(c2));
        System.out.println("c1 * c2 = " + c1.multiply(c2));
    }
}
