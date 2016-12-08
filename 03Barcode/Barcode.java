public class Barcode implements Comparable<Barcode>{
 
      
    private String _zip;
    private int _checkDigit;

   

    // public Barcode() {
    // 	_zip = "00000";
    // 	_checkDigit = 0;
	
    // }

    public Barcode(String zip) {	
	if (zip.length() > 10) {
	    throw new UnsupportedOperationException("Limit Ten Digits");
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
    
    private String bars (int num) {
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

   
    public String toString(){
	String fin = "|";
	for (int dig = 0; dig < _zip.length(); dig++)
	    {
		fin += bars(extract(_zip, dig));
	    }
	fin += "|";
	return fin;
    }
	
    
    //Add toZip


    public int compareTo(Barcode other){
	return (_zip + _checkDigit).compareTo(other._zip + other._checkDigit);
    }
    
}

//Class note: Use array for bar
