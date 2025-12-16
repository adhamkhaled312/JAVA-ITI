package ITI;
import java.util.function.Predicate;
public class AlphabetString{	

	public static Boolean isAlphabet(String s, Predicate<Character> valid){
		for(int i=0;i<s.length();i++){
			if (!valid.test(s.charAt(i))) return false;
		}
		return true;
	}		
	
	public static void main(String[] args){
		String correct= "adhamKhaled";
		if(isAlphabet(correct, Character::isLetter))
			System.out.println("String "+correct+" contains only alphabets");
		else
			System.out.println("String "+correct+" contains non-alphabets");
		
		String wrong= "adham&khaled";
		if(isAlphabet(wrong, Character::isLetter)) 
			System.out.println("String "+wrong+" contains only alphabets");
		else
			System.out.println("String "+wrong+" contains non-alphabets");


		if(isAlphabet(correct, c->Character.isLetter(c)))
			System.out.println("String "+correct+" contains only alphabets");
		else
			System.out.println("String "+correct+" contains non-alphabets");
		
		if(isAlphabet(wrong, (c)->Character.isLetter(c)))
			System.out.println("String "+wrong+" contains only alphabets");
		else
			System.out.println("String "+wrong+" contains non-alphabets");



	}
	
	
}