package ITI;
import java.util.*;

class SimpleDictionary{
	private Map<Character,TreeSet<String>> dictionary = new TreeMap<>();
	
	public SimpleDictionary(String[] words){
		for(String word:words){
			char key = Character.toUpperCase(word.charAt(0));
			dictionary.putIfAbsent(key,new TreeSet<>());
			dictionary.get(key).add(word);
		}
	}
	public void printAll(){
		dictionary.forEach((key,value) -> {
			System.out.print(key + ": " + value);
			System.out.println();
		});
	}
	
	public void printLetterWords(char letter){
		letter = Character.toUpperCase(letter);
		SortedSet<String> words = dictionary.get(letter);
		if (words == null || words.isEmpty())
            System.out.println("No words found for letter: " + letter);
		else
            System.out.println(letter + ": " + words);
				
	}
	
}
public class DictionaryTest{	
	
	public static void main(String[] args){
        String[] words = {
			"Apple", "Ant", "Adham" , "Apex",
			"Banana", "Boat",
			"Cat", "Car", "Cloud",
			"Dog",
			"Elephant",
			"Fish", "Forest",
			"Goat",
			"House",
			"Ice",
			"Java", "Jungle"
        };
		SimpleDictionary dictionary = new SimpleDictionary(words);
		dictionary.printAll();
		dictionary.printLetterWords('f');
		
	}
	
}