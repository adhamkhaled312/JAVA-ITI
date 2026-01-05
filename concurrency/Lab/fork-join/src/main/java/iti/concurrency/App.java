package iti.concurrency;
import java.util.concurrent.*;

class SqrtTransform extends RecursiveAction{
    final int seqThreshold = 1000;
    double data[];
    int start, end;
    SqrtTransform(double[] vals, int s, int e){
        data = vals; start = s; end = e;
    }
    protected void compute(){
        if((end- start) < seqThreshold){
            for(int i = start; i < end; i++){
                data[i] = Math.sqrt(data[i]);
            }
        }else{
            int middle = (end + start) / 2;
            invokeAll(new SqrtTransform(data, start, middle),
                    new SqrtTransform(data , middle, end));
        }
    }
}
class Sum extends RecursiveTask {
    final int seqThreshold = 500;
    double data[];
    int start, end;
    Sum(double[] vals, int s, int e){
        data = vals; start = s; end = e;
    }
    protected Double compute(){
        double sum = 0;
        if((end - start) < seqThreshold){
            for(int i = start; i < end; i++){   sum+= data[i];  }
        }else{
            int middle = (end + start) / 2;
            Sum subTaskA = new Sum(data, start, middle);
            Sum subTaskB = new Sum(data, middle, end);
            subTaskA.fork();
            subTaskB.fork();
            sum = (Double)subTaskA.join() + (Double)subTaskB.join();
        }
        return sum;
    }}
public class App{
public static void main(String [] args){
    ForkJoinPool fjp = new ForkJoinPool();
    double[] nums = new double[100000];
    for(int i=0; i<nums.length; i++) nums[i] = (double)i;
    System.out.println("A portion of the original sequence");
    for(int i=0; i<10; i++)
        System.out.print(nums[i]+" ");
    System.out.println("\n");
    SqrtTransform task = new SqrtTransform(nums, 0, nums.length);
    fjp.invoke(task);
    System.out.println("A portion of the transformed sequence" +
            " (to four decimal places): ");
    for(int i=0; i<10; i++)
        System.out.format("%.4f ", nums[i]);
    System.out.println();
    fjp.shutdown();
//    ForkJoinPool fjp = new ForkJoinPool();
//    double[] nums = new double[5000];
//    for(int i=0; i<nums.length; i++)
//        nums[i]=(double) (((i%2) == 0 ? i : -i));
//    Sum task = new Sum(nums, 0, nums.length);
//    double summation = (Double)(fjp.invoke(task));
//    System.out.println("The Summation = " + summation );
//    fjp.shutdown();
}
}
