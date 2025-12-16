public class StringSplit{

    public static void main(String args[]){
        String test="In the middle of the night, the old clock kept ticking and ticking while 		     the wind outside kept blowing and blowing across the quiet quiet streets";    		String word="night";
	String tokens[]=test.split("[ ,]+");
	int count=0;
	for(int i=0;i<tokens.length;i++)
	    if(tokens[i].equals(word)) count++;
	
	System.out.println("The word "+word+" repeated "+count+" times");

}

}