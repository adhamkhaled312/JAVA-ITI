public class RecieveInput{
    public static void main(String args[]){
        if(args.length==0){
	    System.out.println("No input provided");
	}
	else{
	    for(int i=0;i<args.length;i++){
                System.out.println(args[i]);
	}
	}
	
}
}