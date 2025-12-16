public class StringIndexOf{

    public static void main(String args[]){
        String test="In the middle of the night, the old clock kept ticking and ticking while 		     the wind outside kept blowing and blowing across the quiet quiet streets";    		String word="night";
	int count=0;
	int index=0;
	index=test.indexOf(word,index);
	while(index!=-1){
	    count++;
	    index+=word.length();
	    index=test.indexOf(word,index);
	}
	System.out.println("The word "+word+" repeated "+count+" times");
}
}