public class Barcode implements Comparable<Barcode>{     
    private String _zip;
    private int _checkDigit;

    //Constructors
    //add exception for !5
    public Barcode(String zip) {
	for (int i = 0; i < zip.length(); i++)
	    try {
		int notimp = 0;
		notimp = extract(zip,i);
	    }catch(IllegalArgumentException e)
		{System.out.println ("String " + zip + " contains chars other than integers");
		    return;
		    }
	try {if (zip.length()!= 5) {
		throw new IllegalArgumentException ();}
	}catch (IllegalArgumentException e) {
	    System.out.println ("Illegal zip length>> " + zip.substring(0,zip.length()) + " ZL: " + zip.length());
	    
	}
	
	_zip = zip;
	int sum = checkSum(_zip);
	_checkDigit = sum % 10;
	_zip += _checkDigit;
    }
 
    //Helper methods

    // private static zipChecker (String zip) {

    
    // }
    
    private static  int extract (String str, int index) {
	String s = "" + str.charAt(index);
	return Integer.parseInt(s);
    }
    
    private static int checkSum(String zip){
	int sum = 0;
	for (int i = 0; zip.length() > i; i++){
	    sum += extract (zip, i) ;
	}
	return sum;
    }//make static

    private static String code (int num) {
	
        String[] bars = new String[10];
	bars[0] = "||:::";
	bars[1] = ":::||";
	bars[2] = "::|:|";
	bars[3] = "::||:";
	bars[4] = ":|::|";
	bars[5] = ":|:|:";
	bars[6] = ":||::";
	bars[7] = "|:::|";
	bars[8] = "|::|:";
	bars[9] = "|:|::";

	return bars[num];
    }
	    

    private static String decode (String code) {
	String num = "";
	for (int i = 0; i < code.length(); i++){
	    if (!((code.charAt(i)!= ':') || (code.charAt(i)!= '|'))){
		throw new IllegalArgumentException("Invalid characters");
	    }
	}
	try {
	    if (code.equals( ":::||")) {
		num += 1 ;}
	    else if (code.equals( "::|:|")) {
		num += 2 ;}
	    else if (code.equals("::||:")) {
		num += 3 ;}
	    else if (code.equals(":|::|")) {
		num += 4 ;}
	    else if (code.equals(":|:|:")) {
		num += 5 ;}
	    else if (code.equals(":||::")) {
		num += 6 ;}
	    else if (code.equals("|:::|")) {
		num += 7 ;}
	    else if (code.equals("|::|:")) {
		num += 8 ;}
	    else if (code.equals("|:|::")) {
		num += 9 ;}
	    else if (code.equals("||:::")) {
		num += 0 ;}
	}catch (IllegalArgumentException e)
	    {System.out.println ("Unidentified Code--" + code);}

	return num;
    }

    ////public methods
    public static String toCode(String zip){
	try {if (zip.length()!= 5) {
		throw new IllegalArgumentException ();}
	}catch (IllegalArgumentException e) {
	   return ("Illegal zip length>> " + zip.substring(0,(zip.length()-1)) + " ZL: " + (zip.length()-1));
	   
	}
    
	for (int i = 0; i < zip.length(); i++)
	    try {
		int notimp = 0;
		notimp = extract(zip,i);
	    }catch(IllegalArgumentException e)
		{System.out.println ("String " + zip + " contains chars other than integers");}

	int sum = checkSum(zip);
	int checkDigit = sum % 10;
	zip += checkDigit ;
	
	String fin = "|";
	for (int dig = 0; dig < zip.length(); dig++)
	    {fin += code(extract(zip, dig));}	
	fin += "|";
	
	return fin;
    }
    
	
    public static String toZip(String code){
	String zip = "";

	try {if (code.length()!= 32) {
		throw new IllegalArgumentException ();}
	}catch (IllegalArgumentException e) {
	    System.out.println ("Illegal code length"+ code + "(" + code.length() + ")");
	}

	for (int bars = 1; bars < (code.length()-5);){
	    String seg = code.substring(bars, bars+5);
	    zip += decode(seg);
	    bars= bars + 5;
	}
	
	int last = extract (zip , (zip.length()-1));

	int sum = checkSum(zip);
	int checkDigit = sum % 10;
	

	try {
	    if (last != checkDigit) {
	    throw new IllegalArgumentException();
	    }}catch (IllegalArgumentException e)
	    {System.out.println ("Invalid check digit: " + last);}

	return zip;		
		
    }

    /**Add missing guard rail exception...checksum is invalid
       ...encoded ints are invalid      
       .the left and rigthmost charcters are not '|'*/


    public  int compareTo(Barcode other){
	return (_zip + _checkDigit).compareTo(other._zip + other._checkDigit);
    }
    
    public String toString(){
	if ((_zip.charAt(0) == '|' )|| (_zip.charAt(0) == ':')){
	    return _zip;}
	else{ return _zip + " " + toCode(_zip);}
    }


}

//e.printStackTrace()
