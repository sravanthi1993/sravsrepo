package chinni;

import java.util.ArrayList;
import java.util.List;

public class Subsetsolution {
	
	  static List<List<Integer>> a= new ArrayList<List<Integer>>();
	   
	    
	        public static void subset(int[]nums, int i, List<Integer> r) {
	        if (i > nums.length) {
	            return;
	        }
	        a.add(r);
	        //System.out.println(r);
	        System.out.println(a);
	        for (int j = i; j < nums.length; j++) {
	            List<Integer> l = new ArrayList<Integer>(r);
	            System.out.println(l);
	            l.add(nums[j]);
	            System.out.println(l);
	            subset(nums, j + 1, l);
	        }
	        
	    }
	    
	    
	    public static List<List<Integer>> subsets(int[] nums) {
	        
	        subset(nums, 0, new ArrayList<Integer>());
	        return a;
	        
	    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums= {1,2,3};
		System.out.println(subsets(nums));

	}

}
