public class Sorts{
 
  public static String Janice(){
    return "01.Tjan.Janice"; 
  }

  
  public static void selectionSort(int[] data){ 
      for (int i = 0; i < data.length; i++){
	  int[] newdata = new int[data.length];
	  int smallest = data[i];
	  for (int j = 0; j < data.length; j++){
	      if (data[i+1]<data[i]){
		  smallest = data [i+1];
	      }
	  }
	  newdata[i]= smallest;
      }
  }

    // public static void main(String[] args) {
    //       int [] A = new int[5];
    //       A[0]=9;
    // A[0]=9;
    // A[0]=9;
    // A[0]=9;
    // A[0]=9;
    // A[0]=9;



}




