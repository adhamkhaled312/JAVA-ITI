public class RecieveInputAndString{
    public static void main(String args[]){
        if(args.length==0) System.out.println("No input provided");
	else{
	    try {
    		int num = Integer.parseInt(args[0]);
    		for(int i=0;i<num;i++){
		    System.out.println(args[1]);
		}
	    } catch (Exception e) {
    	    System.out.println("Invalid number format");
	    }
	}


}



}