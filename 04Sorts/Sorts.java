public class Sorts{
 
  public static String Janice(){
    return "01.Tjan.Janice"; 
  }

  
  public static void selectionSort(int[] data){ 
      for (int i = 0; i < data.size(); i++){
	  int[] newdata;
	  int smallest = data[i];
	  for (int j = 0; j < data.size(); j++){
	      if (data[i+1]<data[i]){
		  smallest = data [i+1];
	      }
	  }
	  newdata[i]= smallest;
      }
      return newdata;
  }





 }

}

