package chinni;

public class monotonicarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a[]= {4,3,2,1};
		int n=a.length;
		
		if(n==1)
		{
			System.out.println("there is only one element in the array");
		}
		
		int i=0;
		int j=1;
		
		boolean isInMonotonic = true;
		boolean isDecMonotonic = true;
		while(i<n-1 && j!=n)
		{
			if(a[i]<=a[j])
			{
				i++;
				j=i+1;
				//System.out.println("given array is a monotonic array" +i +"--" +j);
				//continue;
			}
			else
			{
				//System.out.println("given array is not a monotonic array");
				isInMonotonic = false;
				break;
			}
			//System.out.println("given array is a monotonic inc array");
		}
		
		i = 0; j = 1;
		if(!isInMonotonic)
		{
		while(i<n-1 && j!=n)
		{
		 if(a[i]>=a[j])
		{
			i++;
			j=i+1;
			//System.out.println("given array is a monotonic array"+i +"--" +j);
			//continue;
		}
		 else
			{
				//System.out.println("given array is not a monotonic array");
			 isDecMonotonic = false;
				break;
			}
			//System.out.println("given array is a monotonic dec array");
		}		
		}
		
		if(isDecMonotonic || isInMonotonic)
			System.out.println("given array is a monotonic dec array");
	}

}
