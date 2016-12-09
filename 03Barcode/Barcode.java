public class Barcode implements Comparable<Barcode>{     
    private String _zip;
    private int _checkDigit;

    //Constructors
    public Barcode(String zip) {
	for (int i = 0; i < zip.length(); i++)
	    try {
		int notimp = 0;
		notimp = extract(zip,i);
	    }catch( IllegalArgumentException e)
		{System.out.println ("String " + zip + " contains chars other than integers");
		    return;
		    }
	_zip = zip;
	int sum = checkSum();
	_checkDigit = sum % 10;
	_zip += _checkDigit;
    }
 
    //Helper methods
    private static  int extract (String str, int index) {
	String s = "" + str.charAt(index);
	return Integer.parseInt(s);
    }
    
    private int checkSum(){
	int sum = 0;
	for (int i = 0; _zip.length() > i; i++){
	    sum += extract (_zip, i) ;
	}
	return sum;
    }//make static

    private String code (int num) {
	
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
        else {throw new IllegalArgumentException("Unidentified Code--" + code);}
	return num;
    }

    ////public methods
    public String toString(){
	String fin = "|";
	for (int dig = 0; dig < _zip.length(); dig++)
	    {
		fin += code(extract(_zip, dig));
	    }
	fin += "|";
	return fin;
    }
    ////make toCode (Static)
	
    public String toZip(String code){
	String zip = "";
	if (0 != ((code.length()-2)%5)) {
	    throw new IllegalArgumentException ("Illegal length");}//try catch in order to keep running...
	for (int bars = 1; bars < (code.length()-5);){
	    String seg = code.substring(bars, bars+5);
	    zip += decode(seg);
	    bars= bars + 5;
	}
	
	int last = extract (zip , (zip.length()-1));
	if (last != _checkDigit) {
	    throw new IllegalArgumentException("Invalid checkdigit:"+last);
	}
	return zip;		
		
    }//Add missing guard rail exception...


    public  int compareTo(Barcode other){
	return (_zip + _checkDigit).compareTo(other._zip + other._checkDigit);
    }
    
}

//e.printStackTrace()
