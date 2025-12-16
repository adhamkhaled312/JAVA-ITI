import java.util.StringTokenizer;
public class StringTokenizerExample{

    public static void main(String args[]){
        String test="In the middle of the night, the old clock kept ticking and ticking while 		     the wind outside kept blowing and blowing across the quiet quiet streets";    		String word="night";
	int count=0;
	StringTokenizer tokenizer=new StringTokenizer(test," ,");
	while(tokenizer.hasMoreTokens()){
	    if(word.equals(tokenizer.nextToken())) count++;
	    
	}
	System.out.println("The word "+word+" repeated "+count+" times");
}
}