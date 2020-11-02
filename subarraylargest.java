package chinni;

public class subarraylargest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int array[]= {-2,-1,3,1,-2,5,3,-5};
      //int array[]= {5,3,-1,4};
      //int array[]={-5,-6,-8,-1};
	 //int array[]={-1,-2,-3,0};
		//int array[]={1};
	//	int array[]={1,2,-4,5};
	//	int array[]={-3,-2,-1};
      int max_val=0;
      int final_val=Integer.MIN_VALUE;
      int i;
      for(i=0;i<array.length;i++)
    	 // max_val=max_val+array[i];
      {
    	  max_val=max_val+array[i];
    	  if(max_val>final_val)
    	  {
    		  final_val=max_val;
    	  }
    	  
         if(max_val<=0)
    		  {
    		  max_val=0;
    		  }
    	  
    	  if(max_val>0)
    	  {
    		  max_val=max_val;
    	  }
    	  /*if(max_val>final_val)
    	  {
    		  final_val=max_val;
    	  }*/
      }
    		  System.out.println("largest number in the subarray is" + final_val);
    		  
      }

	

}
