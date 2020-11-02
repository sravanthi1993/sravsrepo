package chinni;

import java.util.HashMap;

public class contsubarraynegativeintegers {
	
	static boolean negsubarray(int a[],int givensum)
	{
		HashMap<Integer,Integer> h= new HashMap<Integer,Integer>();
		int currentsum=0;
		//int givensum;
		for (int i=0;i<a.length;i++)
		{
			currentsum=currentsum+a[i];
			if(currentsum==givensum)
			{
			//	System.out.println("givensum lies in btw" + (h.get(currentsum-givensum)-1) + i);
				return true;
			}
			else
				if (h.containsKey(currentsum-(givensum)))
				{ int x=h.get(currentsum-givensum);
					System.out.println("givensum lies in btw " +  x + i);
					return true;
				}
				else
					h.put(currentsum, i+1);
		}
		System.out.println("no subarray with given sum exists");
		return false;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a[]= {20,2,4,10,-5,3,6,12};
		int givensum=12;
		int b[]= {1,4,5,-7,10,14};
		int c[]= {3,6,8,11,15};
		int d[]= {};
		int e[]= {10,0,2,-2,-20,10};
		//negsubarray(b,12);
		//negsubarray(c,25);
		boolean r=negsubarray(b,12);
		System.out.println(r);
	}

}
