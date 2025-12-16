import java.util.Random;
public class WordSearch{
    public static void main(String args[]){
	int[] arr = new int[1000];
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(10000);
        }
	int value=arr[890];
	long before=System.nanoTime();
	int index=-1;
	for(int i = 0; i<arr.length;i++){
	    if(arr[i]==value) index=i;
	}
	long after=System.nanoTime();
	if(index==-1) System.out.println("The value " + value + " not found");
	else System.out.println("The value " + value + " found at index: "+index );
	System.out.println("Time taken : " + (after-before));
}
}