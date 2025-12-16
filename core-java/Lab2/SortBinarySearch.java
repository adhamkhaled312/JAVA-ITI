import java.util.Random;
public class SortBinarySearch{
    public static void main(String args[]){
	int[] arr = new int[1000];
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(10000);
        }
	int value=arr[890];	

	long beforeSort=System.nanoTime();
        mergeSort(arr,0,arr.length-1);
	long afterSort=System.nanoTime();

	long beforeSearch=System.nanoTime();
	int index = binarySearch(arr,value);
	long afterSearch=System.nanoTime();

	long after=System.nanoTime();
	if(index==-1) System.out.println("The value " + value + " not found");
	else System.out.println("The value " + value + " found at index: "+index );

        System.out.println("Sorting Time   : " + (afterSort-beforeSort));
        System.out.println("Searching Time : " + (afterSearch-beforeSearch));
}

    public static void mergeSort(int arr[], int l, int r) {
	if (l < r) {
	    int mid = l + (r - l) / 2;

	    mergeSort(arr, l, mid);
	    mergeSort(arr, mid + 1, r);

	    merge(arr,l,mid,r);
	}
    }
    public static void merge(int arr[], int l, int m, int r) {
	int size1 = m - l + 1;
	int size2 = r - m;
	int leftArr[] = new int[size1];
	int rightArr[] = new int[size2];

	for (int i = 0; i < size1; i++) {
		leftArr[i] = arr[l + i];
	}
	for (int i = 0; i < size2; i++) {
		rightArr[i] = arr[m + 1 + i];
	}

	int i = 0;
	int j = 0;
	int k = l;
	while (i < size1 && j < size2) {
		if (leftArr[i] < rightArr[j]) arr[k++] = leftArr[i++];
		else arr[k++] = rightArr[j++];
	}

	while (i < size1) arr[k++] = leftArr[i++];
	while (j < size2) arr[k++] = rightArr[j++];
}
    public static int binarySearch(int arr[], int value){
	int low=0;
	int high=arr.length-1;
	while(low<=high){
	    int mid=low+(high-low)/2;
	    if(arr[mid]==value) return mid;
	    else if(arr[mid]>value) high=mid-1;
	    else low=mid+1;   
	}
	return -1;
    }
}