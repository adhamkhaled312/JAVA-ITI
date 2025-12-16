import java.util.function.Function;

public class CalculateRoots{
	public static void main(String args[]){
		Function<double[],double[]> calcRoots= x->{
			double underRoot=x[1]*x[1]-4*x[0]*x[2];
			if(underRoot < 0) return null;
			
			double sqrt=Math.sqrt(underRoot);
			double []roots=new double[2];
			roots[0]=(-x[1]+sqrt)/(2/x[0]);
			roots[1]=(-x[1]-sqrt)/(2/x[0]);
			return roots;
		};
		
		double[]test= new double[3];
		test[0]=1;test[1]=-5;test[2]=6;
		double[]roots=calcRoots.apply(test);
       	 	if (roots== null)
            		System.out.println("No real roots");
        	else
            		System.out.println("Root1 = " + roots[0] + ", Root2 = " + roots[1]);
    }

}