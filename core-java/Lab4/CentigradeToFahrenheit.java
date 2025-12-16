import java.util.function.Function;

public class CentigradeToFahrenheit{
	public static void main(String []args){
		Function<Double,Double> centigradeToFahrenheit = c->(c*9.0/5.0)+32.0;        		double c1 = 0.0;
        double c2 = 25.0;
        double c3 = 100.0;

        System.out.println(c1 + "C = " + centigradeToFahrenheit.apply(c1) + "F");
        System.out.println(c2 + "C = " + centigradeToFahrenheit.apply(c2) + "F");
        System.out.println(c3 + "C = " + centigradeToFahrenheit.apply(c3) + "F");


	}

}
