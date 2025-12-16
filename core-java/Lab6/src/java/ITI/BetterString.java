package ITI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;

public class BetterString {
	private static String getBetter(String s1, String s2, BiPredicate<String,String> validate) 
	{
		if(validate.test(s1,s2)) return s1;
		else return s2;
	}
public static void main(String[] args) {
	String s1="adham";
	String s2="khaled Abdelmaqsoud";
	
	System.out.println(getBetter(s1,s2,(s,t)->s.length()>t.length()));
}
}