public class Barcode implements Comparable<Barcode>{
 
      
    private String _zip;
    private int _checkDigit;

   

    // public Barcode() {
    // 	_zip = "00000";
    // 	_checkDigit = 0;
	
    // }

    public Barcode(String zip) {	
	if (zip.length() > 10) {
	    throw new IllegalArgumentException("Limit Ten Digits");
	}
	_zip = zip;

	int sum = checkSum();
	_checkDigit = sum % 10;
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
	if (code == ":::||") {
	    num += 1 ;}
	if (code == "::|:|") {
	    num += 2 ;}
	if (code == "::||:") {
	    num += 3 ;}
	if (code == ":|::|") {
	    num += 4 ;}
	if (code == ":|:|:") {
	    num += 5 ;}
	if (code == ":||::") {
	    num += 6 ;}
	if (code == "|:::|") {
	    num += 7 ;}
	if (code == "|::|:" ) {
	    num += 8 ;}
	if (code == "|:|::") {
	    num += 9 ;}
	if (code == "||:::") {
	    num += 0 ;}
	else {throw new IllegalArgumentException("Unidentified Code:" + code);}
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
	for (int bars = 1; bars < code.length(); bars++){
	    String seg = code.substring(bars+3);
	    zip += decode(seg);
	}
	
	int last = extract (zip , (zip.length()-1));
	if (last != _checkDigit) {
	    throw new IllegalArgumentException("Invalid checkdigit");
	}
	return zip;		
		
    }


    public int compareTo(Barcode other){
	return (_zip + _checkDigit).compareTo(other._zip + other._checkDigit);
    }
    
}

//Class note: Use array for bar
