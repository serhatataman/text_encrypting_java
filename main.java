import java.util.Scanner;

public class Crypto 
{
	public static void main(String[] args)
	{
		String text;
		int shiftNumber,groupifyNumber;
		Scanner input = new Scanner(System.in);
		
		System.out.print("Please enter a text: ");
		text=input.nextLine();
		System.out.print("Please enter the shifting amount between 1 and 25: ");
		shiftNumber=input.nextInt();
		System.out.print("Please enter the groupify number: ");
		groupifyNumber=input.nextInt();
		
		encryptString(text,shiftNumber,groupifyNumber);
		
	}
	
	public static void encryptString(String text,int shiftNumber, int groupifyNumber)
	{	
		System.out.println("Original text is: "+text);
	
		text=normalize(text); // Normalizing the text
		System.out.println("Normalized text is: "+text);
		
		text=obify(text);
		System.out.println("Obified text is: "+text);
		
		text=ceasarify(text,shiftNumber); //encrypting the text
		System.out.println("Encrypted text is: "+text);
		
		text=groupify(text,groupifyNumber); //encrypting the text
		System.out.println("Groupified text is: "+text);
		
	}
	
	public static String normalize(String text)
	{
		text=text.replaceAll("\\s+",""); //removes all whitespaces and non-visible characters (e.g., tab, \n).
		text=text.replaceAll("[^a-zA-Z ]", "").toUpperCase();//2. Remove any punctuation (. , : ; ’ ” ! ? ( ) ) and Turn all lower-case letters into upper-case letters
		return text;
	}
	
	public static String obify(String text) //insert O and B in front of every vowel(ünlü)
	{
		String temp="";
		char c;
		for (int i = 0; i < text.length(); i++) 
		{
			if (text.charAt(i)=='A' || text.charAt(i)=='E' || text.charAt(i)=='I' || text.charAt(i)=='O' || text.charAt(i)=='U' || text.charAt(i)=='Y') 
				temp += "O" + "B" + text.charAt(i);
			else 
				temp += text.charAt(i);
			
		}
		return temp;
	}
	
	/* The first argument is a string you want to encrypt, and the second is an integer that contains the shift value or "key". 
	 * The function should return a string, which is the input string encrypted with the Caesar cypher using the shift value passed in its second argument. 
	 * You may assume that the input string is normalized. “CDEFGHIJKLMNOPQRSTUVWXYZAB” */
	public static String ceasarify(String text, int shiftNumber)
	{
		String alphabet,temp="";
		char c;
		
		alphabet=shiftAlphabet(shiftNumber);
		
		for (int i = 0; i < text.length(); i++) 
		{
			c=text.charAt(i);
			c=(char)(c + shiftNumber);
			
			if (c>'Z') 
			{
				while(c>='Z')
					c -= 'Z';
			} 
			temp += c;
		}
		return temp;
	}
	
	/* Traditionally, encrypted messages are broken into equal-length chunks, separated by spaces and called “code groups.”
	 * The first parameter is the string that you want to break into groups. 
	 * The second argument is the number of letters per group. The function will return a string, 
	 * which consists of the input string broken into groups with the number of letters specified by the second argument.
	 * */
	public static String groupify(String text, int groupifyNumber)
	{
		int x;
		String temp = "";
		
		if (text.length() % groupifyNumber != text.length()) 
		{
			x = groupifyNumber - (text.length() % groupifyNumber);
			
			for (int i = 0; i < x; i++) 
			{
				text += "x";
			}
		} 
		
		for (int i = 0; i < text.length(); i++) 
		{
			if(i % groupifyNumber == 0 && i != 0) 
				temp += " ";
			
			temp += text.charAt(i);
		}
		
		return temp;
	}
	
	/* This function takes one argument, an integer to specify the shift value, and returns a string, 
	 * which is the uppercase alphabet shifted by the shift value
	 * for example if shift value is 2, the return will be: “CDEFGHIJKLMNOPQRSTUVWXYZAB” */
	public static String shiftAlphabet(int shift) 
	{
	    int start = 0;
	    if (shift < 0) {
	        start = (int) 'Z' + shift + 1;
	    } else {
	        start = 'A' + shift;
	    }
	    String result = "";
	    char currChar = (char) start;
	    for(; currChar <= 'Z'; ++currChar) {
	        result = result + currChar;
	    }
	    if(result.length() < 26) {
	        for(currChar = 'A'; result.length() < 26; ++currChar) {
	            result = result + currChar;
	        }
	    }
	    return result;
	}
}
