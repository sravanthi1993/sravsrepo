package chinni;

public class kthsmallestelement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a[]= {7,10,4,3,20,15};
		int i=0;
		int j;
		int k=10;
		int n=a.length;
		int x;
		
		for(i=0;i<=k;i++)
		{
			for(j=i+1;j<n;j++)
			{
				if (a[i]>a[j])
				
					{
					x=a[i];
					a[i]=a[j];
					a[j]=x;
					}
					}}
		
		if(n==0 || n<k)
		{
			System.out.println("no kth element found");
		}
		else
		{
			System.out.println("kth smallest element is" + a[k-1]);
		}
		
			
		
		
		
	}

}
