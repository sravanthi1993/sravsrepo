package chinni;

public class continuoussubarraysum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int arr[]= {1,4,20,3,10,5};
		//int arr[]= {1,4,0,0,3,10,5};
		int arr[]= {1,4};
		int sum=0;
		int count=0;
		//int result;
		int i=0;
		int n=arr.length;
		int result=0;
		
		while(i<n )
		{
			//sum=sum+arr[i];
		if(sum==result)
		{
			break;
		}
		
		else if(sum<result)
		{
			sum=sum+arr[i];
			System.out.println("sum value is" + sum);
			i++;
			//System.out.println("sum value is" + sum);
		}
		
		else if(sum>result && i<n)
		{
			sum=sum-arr[count];
			count=count+1;
			System.out.println("count is" + count);
			System.out.println("sum value is" + sum);
			continue;
		}
		if(sum!=result && count<i-1) {
			System.out.println("no sum found");
		}
		
		}
		
		System.out.println("sum found in between indexes" + count + (i-1) );
	
	}

}
