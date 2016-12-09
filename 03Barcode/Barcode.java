public class Barcode implements Comparable<Barcode>{
 
      
    private String _zip;
    private int _checkDigit;

   

    // public Barcode() {
    // 	_zip = "00000";
    // 	_checkDigit = 0;
	
    // }

    public Barcode(String zip) {	
	_zip = zip;
	int sum = checkSum();
	_checkDigit = sum % 10;
	_zip += _checkDigit;
    }

  
    // public Barcode clone(){
    // 	String zipper = _zip;
    // 	Barcode clone = new Barcode(zipper);
    // 	return clone;
    // }

    private int extract (String str, int index) {
	String s = "" + str.charAt(index);
	return Integer.parseInt(s);
    }
    
    private int checkSum(){
	int sum = 0;
	for (int i = 0; _zip.length() > i; i++){
	    sum += extract (_zip, i) ;
	}
	return sum;
	    }
    
    private String code (int num) {
	String code = "";
	if (num == 1) {
	    code = ":::||" ;}
	if (num == 2) {
	    code = "::|:|" ;}
	if (num == 3) {
	    code =  "::||:" ;}
	if (num == 4) {
	    code =  ":|::|" ;}
	if (num == 5) {
	    code =  ":|:|:" ;}
	if (num == 6) {
	    code =  ":||::" ;}
	if (num == 7) {
	    code =  "|:::|" ;}
	if (num == 8) {
	    code =  "|::|:" ;}
	if (num == 9) {
	    code =  "|:|::" ;}
	if (num == 0) {
	    code = "||:::" ;}
	return code;
    }

    private String decode (String code) {
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

   
    public String toString(){
	String fin = "|";
	for (int dig = 0; dig < _zip.length(); dig++)
	    {
		fin += code(extract(_zip, dig));
	    }
	fin += "|";
	return fin;
    }
	
    public String toZip(String code){
	String zip = "";
	if (0 != ((code.length()-2)%5)) {
	    throw new IllegalArgumentException ("Illegal length");}
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
		
    }


    public int compareTo(Barcode other){
	return (_zip + _checkDigit).compareTo(other._zip + other._checkDigit);
    }
    
}

//Class note: Use array for bar
