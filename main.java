import java.util.Scanner;

public class Crypto 
{
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		
	  System.out.print("Type in the text you want to encrypt: ");
	  String Encrypt = input.nextLine();
	  System.out.println();

	  System.out.print("Enter an encryption key from 1 to 26: ");
	  int Shift = input.nextInt();
	  System.out.println();

	  System.out.print("How many broken part do you want your encrypted text to have: ");
	  int GroupSize = input.nextInt();
	  System.out.println();

	  String Results = encryptString (Encrypt,Shift,GroupSize ); 
	  System.out.println ("Here is the encrypted text: " + Results);
	}

	public static String normalizeText(String Normalize){

	    String FunctionInput = Normalize.replaceAll("\\p{Punct}","");
	    FunctionInput = FunctionInput.replaceAll(" ","");
	    FunctionInput = FunctionInput.toUpperCase();
	    //System.out.println (FunctionInput);   debug test
	    return FunctionInput;
	}

	public static String obify(String OvowelB){
	    String AddOandB = "";
	    for (int i= 0; i< OvowelB.length(); i++){
	        char extract = OvowelB.charAt(i);
	        char ex = extract;
	        if ( ex == 'A' || ex == 'U'|| ex == 'E'|| ex == 'I'||ex == 'O'||ex == 'Y'){
	            AddOandB = AddOandB + 'O' + 'B' + extract ;
	        }
	        else{
	            AddOandB = AddOandB + extract;
	        }

	    }
	    System.out.println (AddOandB);
	    return AddOandB;
	}

	public static String  caesarify( String encrypt, int key) {

	    String reconstruct = "";
	      for (int i = 0 ;i < encrypt.length(); i++){
	        char extract = encrypt.charAt(i);
	        extract = (char)(extract + key);

	        if (extract > 'Z'){
	          for (; extract >= 'Z';){
	         extract -= 'Z'; 
	       }

	    }

	        reconstruct = reconstruct + extract;

	    }
	    //System.out.println (reconstruct);    debug test
	    return reconstruct;


	}
	public static String groupify (String group, int groupLength){
	        int Div = group.length()/groupLength;
	        String separation = "";
	        int j = 0;

	        for (int i = 1; i <= groupLength; i++){


	            //System.out.println (j + " ");    debug test
	            int DivChange = Div + j;

	            for (; j< DivChange; j++ ){
	                char parte = group.charAt(j);
	                if (parte == -1){
	                    parte = 'x';

	                }
	                separation = separation + parte;
	                //System.out.print (separation);    debug test
	            }
	            separation = separation + "  ";
	        }
	    return separation;
	}
	public static String encryptString (String Encrypt, int Shift, int GroupSize ){

	    String FirstMethod  = normalizeText (Encrypt);
	    String SecondMethod = obify(FirstMethod);

	    String ThirdMethod  = caesarify( SecondMethod,Shift );
	    String FourthMethod = groupify (ThirdMethod, GroupSize);

	    return FourthMethod;

	}
}
