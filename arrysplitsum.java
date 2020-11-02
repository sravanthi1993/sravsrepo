package chinni;

public class arrysplitsum {
	public static void main(String args[]) {
		int a[]= {1,2,3,5,8,1,20};
		int sum=0;
		
		int m=7;
		for(int i=0;i<m;i++)
		{
			sum=sum+a[i];
		}
		int i=0;
		while(i<m && a[i]!=(sum/2))
		{
			System.out.println("first array values are " + a[i]);	
			i++;
			continue;
		}
		//System.out.println("no element found which has sum equal to other elements in an array");
		if(i<m && a[i]==(sum/2))
		{
			System.out.println("sum of first array value is " + a[i]);
		}
		else System.out.println("no element found which has sum equal to other elements in an array");
		
	}
}
