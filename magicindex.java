package chinni;

public class magicindex {
	public static void main(String args[]) {
		int array[]= {0,1,2,3,4,5,6,7};
		//int array[]= {1,2,3,6,7,8,9,10};
		//int array[]= {1,2,3,4,5,5,6,8};
		//int array[]= {-3,-2,-1,0,4,6,7,8,12,14};
		//int array[]= {0};
		int result=-1;
		int start=0;
		//int end=0;
		int end=8;
		//int end=10;
		int mid;
		
		/*for (int i=0;i<n-1;i++)
			
		{
			if(array[i]==i)
			{
				result=i;
				System.out.print("the 4th index value is" + array[4]);
		//	System.out.print("the index value is" + result);
			break;//if we need only one index value where a[i]=i
			}
			
			System.out.print("no magic index value found");
			
		}*/
		
		/*if(start==end)
		{
		result=start;
			break;
		}*/
	
		while(start<=end)
		{
			 mid = (start+end)/2;
			if(array[mid]==mid)
			{
				result=mid;
				break;
			}
		if(array[mid] > mid)
		{
		end=mid-1;
		//break;
		//result=end;
		}
		else
		{
			start=mid+1;
			//break;
			//result=start;
			//System.out.println("the magicindex value is" + start);
		}
	}
		System.out.println("the magicindex value is" + result);
	}
}
