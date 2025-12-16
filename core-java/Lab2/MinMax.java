import java.util.Random;
public class MinMax{
    public static void main(String args[]){
	int[] arr = new int[1000];
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(10000);
        }
	
	long before=System.nanoTime();
	int min=Integer.MAX_VALUE;
	int max=Integer.MIN_VALUE;
	for(int i = 0; i<arr.length;i++){
	    if(arr[i]<min)min=arr[i];
	    if(arr[i]>max)max=arr[i];
	}
	long after=System.nanoTime();
	System.out.println("Max element is "+max);
	System.out.println("Min element is "+min);
	System.out.println("Time taken : " + (after-before));
}
}