public class Sorts{
 
    public static String name(){
	return "01.Tjan.Janice"; 
    }

  
    public static void selectionSort(int[] data){ 
	for (int i = 0; i < data.length; i++){          
	    int smallest = data[i];
	    for (int j = i+1; j < data.length; j++){
		if (data[j]<data[i]){
		    smallest = data [j];
		    data[j] = data[i];
		    data[i] = smallest;
		}
	    }
	}
    }

   
    public static String toString(int[] data){
	String x = "[ ";
	for(int i = 0; i < data.length; i++){
	    if (i < data.length-1){
		x = x + data[i] + ", ";
	    }
	    else { x = x + data[data.length-1] + "]";}
	}
	return x;
    }


    public static void main(String[] args) {
	int [] A = new int[5];
	A[0]=9;
	A[1]=4;
	A[2]=5;
	A[3]=3;
	A[4]=7;
	selectionSort(A);
	System.out.println (toString(A));
    }
}




