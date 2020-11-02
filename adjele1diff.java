package chinni;

public class adjele1diff {
	public static void main(String args[]) {
		int a[]= {8,7,6,7,6,5,4,3,2,3,4,3};
		int count=0;
		int n=1;
		int i=0;
		int m=12;
		while(i<m && a[i]!=n)
		{
			if(a[i]>n)
			{
				count=a[i]-n;
				i=i+count;
				System.out.println("index value i is-- " + i);
				//System.out.println("value of i is " + a[i]);
				continue;
			}
			else if(a[i]<n)
			{
				count=n-a[i];
				i=i+count;
				//continue;
				System.out.println("value of i is " + i);
			}
			
		}
	if(i<m && a[i]==n )
	{
		System.out.println("found the given number at index i " + i);
	}
	else if(i>=m)
	{
	System.out.println("number not found ");
	}
	
	}	
}
