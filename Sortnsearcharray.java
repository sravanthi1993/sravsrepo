package chinni;

	import java.util.Arrays;
import java.util.Collections;

	public class Sortnsearcharray {
	   public static void main(String args[]) throws Exception {
	      Integer array[] = { 2, 5, -2, 6, -3, 8, 0, -7, -9, 4 };
	      Arrays.sort(array, Collections.reverseOrder());
	      //arrays.v
	      try
	      {
	      printArray("Sorted array", array);
	      }
	      catch(Exception e)
	      {
	    	  System.out.print("Hurrayyyyy");
	      }
	      int index = Arrays.binarySearch(array, 2);
	      System.out.println("Found 2 @ " + index);
	   }
	   private static void printArray(String message , Integer array[]) {
	     System.out.println(message + ": [length: " + array.length + "]");
	     
	     System.out.println("linear sort" + ": [length: " + array.length + "]");
	      for (int i = 0; i < array.length+1; i++) {
	         if(i != 0) {
	            System.out.print(", ");
	         }
	         System.out.print(array[i]);                     
	      }
	      System.out.println();
	   }
	}


