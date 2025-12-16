import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class StringRegex{

    public static void main(String args[]){
        String test="In the middle of the night, the old clock kept ticking and ticking while 		     the wind outside kept blowing and blowing across the quiet quiet streets";    		String words[]={"night","ticking"};
	int count=0;
	for(int i=0;i<words.length;i++){
	    Pattern pattern = Pattern.compile("\\b" + words[i] + "\\b");
	    Matcher matcher = pattern.matcher(test);
	    while(matcher.find()){
	        count++;
	    }
	}

	System.out.println("The total occurenses of the group is "+count);
	
}
}