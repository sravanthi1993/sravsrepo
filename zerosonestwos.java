package chinni;

public class zerosonestwos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int a[]= {1,1,0,2,0,1,2,2,0,0,1,0};
		int a[]= {0,1,1,2,0,1,2,0,0,1,2,1};
		int n=12;
		int i=0;
		int x=0;
		int zerocount=0;
		int twocount=0;
		while(i<(n-twocount))
		{
			if(a[i]==0)
			{
				x=a[zerocount];
				a[zerocount]=a[i];
				a[i]=x;
				zerocount=zerocount+1;
				i++;
					}
			else if (a[i]==2)
			{
				x=a[(n-1)-twocount];
				a[(n-1)-twocount]=a[i];
				a[i]=x;
				twocount=twocount+1;
			}
			else if(a[i]==1)
			{
				i++;
			}
			//System.out.println("sorted array values are" + a[i]);  
		}
		for(i=0;i<n;i++)
		{
			System.out.println("sorted array values are" + a[i]);	
		}
	
	}

}
