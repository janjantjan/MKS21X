public class Barcode implements Comparable<Barcode>{
    // instance variables
    private String _zip;
    private int _checkDigit;

   

    public Barcode() {
	_zip = "00000";
	_checkDigit = 5;	   
    }

    public Barcode(String zip) {	
	if (zip > 10) {
	    throw new UnsupportedOperationException("Limit Ten Digits");
	}
	_zip = zip;

	int sum = new checksum();
	_checkDigit = sum % 10;
    }

  
    public Barcode clone(){
	String zipper = _zip;
	Barcode clone = new Barcode(zipper);
	return clone;
    }

    private int extract (String s, int index) {
	String s = "" + zip.charAt(index);
	Integer.parseInt(s);
    }
    
    private int checkSum(){
	int sum = 0;
	for (int i = 0; length._zip > i; i++){
	    sum += extract (_zip, i) ;
	}
	return sum
	    }
    
    private String bars (int num) {
	if (num == 1) {
	    return ":::||" ;}
	if (num == 2) {
	    return "::|:|" ;}
	if (num == 3) {
	    return "::||:" ;}
	if (num == 4) {
	    return ":|::|" ;}
	if (num == 5) {
	    return ":|:|:" ;}
	if (num == 6) {
	    return ":||::" ;}
	if (num == 7) {
	    return "|:::|" ;}
	if (num == 8) {
	    return "|::|:" ;}
	if (num == 9) {
	    return "|:|::" ;}
	if (num == 0) {
	    return "||:::" ;}
    }   

   
    public String toString(){
	String fin = "|";
	for (int dig = 0; dig < length._zip; dig++){
	    fin += bars(extract(_zip, dig);
			}
		fin += "|";	
	}
	return fin;
    }


    
    public int compareTo(Barcode other){
	(_zip + _checkDigit).compareTo (other._zip + other._checkDigit);
    }
    
}
