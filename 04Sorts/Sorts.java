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

	int [] B = new int[5];
	B[0]=9;
	B[1]=9;
	B[2]=5;
	B[3]=1;
	B[4]=1;
	selectionSort(B);
	System.out.println (toString(B));


	int [] C = new int[5];
	C[0]=9;
	C[1]=4;
	C[2]=5;
	C[3]=-2;
	C[4]=7;
	selectionSort(C);
	System.out.println (toString(C));

	int [] D = new int[5];
	D[0]=99;
	D[1]=999;
	D[2]=9;
	D[3]=0;
	D[4]=-999;
	selectionSort(D);
	System.out.println (toString(D));
    }

    
}




