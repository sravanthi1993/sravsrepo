package chinni;

public class magicindexdup {
	public static void main(String args[]) {
		//int a[]= {-1,2,3,3,3,10};
		//int a[]= {-1,0,1,2,5,5,8,8,8,10};
		//int a[]= {-1,-1,1,2,5,8,8,10,12,15};
		int a[]= {0};
		int i=0;
		//int n=6;
		//int n=10;
		int n=1;
		//int n=a.length();
		
		while(i<n && a[i]!=i)
		{
			if(a[i]<i)
			{
				i++;
				continue;
			}
			else if(a[i]>i && i < n)
			{
				i=a[i];
				//continue;
				System.out.println("value of i is " + i);
			}
			
			
		}
		if(i<n)
		System.out.println("magicindex is " + i);
		else if (i>=n)
		{
			System.out.println("no magic index found");		
	}	
	}

}
