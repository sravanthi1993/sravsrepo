package chinni;

public class nonduplicate {

	public static void main(String args[]) {
		//int array[] = {1,1,3,3,4,5,5,7,7,8,8};
		//int array[] = {1,2,2,4,4,3,3,5,5,6,6,7,7,8,8};
		int array[]= {1,1,2,2,4,4,6,6,7,7,8,8,9,9,3};
		//int array[]= {2,3,3};
		// int array[]= {2,2,4,4,6,6,8,8,9,1,1};
		//int array[]= {2,2,3,4,4,5,5};
		int start=0;
		//int end=10;
		 int end=14;
		//int end=0;
		//int end=2;
		//int end=6;
		int mid = (start+end)/2;
		int value=0;
		
		
		while(start <= end)
		{
			if(start==end)
			{
				value=array[start];
				break;
			}
			System.out.println(start + "--" + end);
			mid = (start+end)/2;
			System.out.println("mid value"+mid);
			
			System.out.println("the start value is" + start);
			System.out.println("the end value is" + end);
		if(array[mid]!=array[mid-1] && array[mid]!=array[mid+1])
		{
			System.out.println("the non-duplicate value is" + mid);
			value=array[mid];
			System.out.println("the non-duplicate value is midvalue" + value);
			break;
		}
		 if(array[mid]==array[mid-1])
		{
			if((start+(mid+1))%2==0)
			{
				start=mid+1;
				//value=array[start];
			}
			else 
				{
				end=mid;
				//value=array[end];
				System.out.println("the nondulpicate end value is" + end);
			//value=end;
		}
		}
	    if(array[mid]==array[mid+1])
		{
			if((end+(mid+1))%2==0)
			{
				end=mid-1;
				//value=array[end];
			}
			else 
			{	start=mid;
			value=array[start];
			System.out.println("the non-duplicate start value is" + start);
			}
		
		}
		}
		
		//}
		System.out.println("the non-duplicate value is" + value);
		}
}
