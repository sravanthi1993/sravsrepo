package chinni;

import java.util.HashMap;

public class SlidingWindow {

	static void SlidingKWindow(int arr[], int k, int result[])
	{
		if(arr.length == 0)
		{
			System.out.println("there are no elements in an array");
		}
		
		HashMap<Integer ,Integer > h=new HashMap<Integer , Integer>();
		
		for(int i=0;i<k;i++)
		{ 
			if(i>arr.length-1)
			{
				break;
			}
			int value =1;
			if(h.containsKey(arr[i]))
					{
				value = h.get(arr[i])+1;
					}
			h.put(arr[i], value);
		}
		result[0]=h.size();
		
		
		for(int i=k;i<=arr.length-1;i++)
		{
			int value;
			int m=i-k;
			value=h.get(arr[m])-1;
			h.put(arr[m], value);
			if(value==0)
			{
				h.remove(arr[m]);
			}
			
			value=1;
			if(h.containsKey(arr[i]))
				{
					value = h.get(arr[i])+1;
				}
				h.put(arr[i], value);
				
				result[m+1]=h.size();
			}		
		}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {2,4,2,4,1,10,-2,2,3};
		int k = 10;
		int result[] = new int[arr.length - k +1];
		//int result[] = new int[arr.length - k +2];only if i>arraylenth
		SlidingKWindow(arr,k,result);
		
		for(int i=0; i< result.length; i++)
		System.out.print(result[i] + ",");
	}

}
