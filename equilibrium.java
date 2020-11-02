package chinni;

public class equilibrium {
	
	public static void main(String[] args) {
	
		int i;
		int n=5;
		int rightsum=0;
		int count=0;
		//int a[]= {-7,1,5,2,-4,3,0};
		int a[]= {2,3,4,8,9};
		//int a[]= {1,2,3,4,5};
		int leftsum=a[0];
		for(i=0;i<n-2;i++)
		{
			rightsum=rightsum+a[i+2];
			
			System.out.println("right sum is" + rightsum);
			continue;
		}
		i=0;
		System.out.println("i value is" + i);
		while(rightsum!=leftsum && i<n-2)
		{
			System.out.println("right sum is" + rightsum);
			System.out.println("left sum is" + leftsum);
			if(count<n-1 && rightsum!=leftsum)
			{
				leftsum=leftsum+a[i+1];
				rightsum=rightsum-a[i+2];
				count=count+1;
				i++;
				System.out.println("sum values" + leftsum + rightsum );
				
			}
			
		}
		
		if(leftsum!=rightsum)
		{
		System.out.println("equilibruim not found" );
		}
		else{
			System.out.println("equilibrium found at index" + (count+1) );
		}
	}
}
