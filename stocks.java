package chinni;

public class stocks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//int a[]= {7,1,5,3,6,4};
		//int a[]= {3,5,8,9,13,6};
		//int a[]= {7,1,5,3,6,0,8};
		int a[]= {7,1,6,5,3,4};
		int max=0;
		int diff=0;
		int n=a.length;
		int j=1;
		int i=0;
		for( i=0;i<n-1;i++)
		{  j=i+1;
			//while(a[i]<a[j] && j<n-1)
		while(j<=n-1 && i<n-1)
			{
			if(a[i]<a[j])
			{
				diff=a[j]-a[i];
				j=j+1;
				//System.out.println("max value is at index i" +i +"-j-" +j+"-diff-"+diff);
			}
			else if(a[i]>a[j])
			{
				i=j-1;
				break;
			}
			
				if(diff>max)
					{
					max=diff;
					System.out.println("max value is at index i" +i +"--j--" +j +"--max--"+max);
					}
				else {max=max;}
					//i++;
					//j=i+1;
					//System.out.println("index i after incrementing by 1 is" +i + j);
					
				}
	//	System.out.println("max value is at index i" +i +"--j--" +j +"--max--"+max);
			}
			
			
			//System.out.println("max value is at index i" +i);
	}	
}
	
	

	
	










		/*while(a[i]>a[j] && j<n-1)
			{
				i=j;
			}*/
		
		
	


