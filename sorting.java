package chinni;

public class sorting {
	public static void main(String args[]) {
		int array[] = { 2, 5, -2, 6, -3, 8, 0, -7, -9, 4 };

		int b[] = new int[10];
		
		int ans=Integer.MIN_VALUE;
		int ans2=Integer.MAX_VALUE;
		int j=0;
		int i=0;
	int ans3;
	int x=0;
		for(;j<10;j++)
		{
		for (i=j;i<10;i++)
		{
			
			//
			if (array [i] < ans2) 
			{
				ans2=array[i];
				x=i;
		
			}
			
			
		}
		
		
			//ans=ans2;
		   //array[j]=ans;
		ans2=Integer.MAX_VALUE;
		//System.out.println("sort value is " + array[j]);
		System.out.println("index x is" + x);
		//ans3=array[x];
		//array[x]=array[i];
		
		//ans=ans2;
		
ans3=array[x];
array[x]=array[j];
array[j]=ans3;
		
		System.out.println("index value is" + ans3);
		//System.out.println("index i is" + i);
		System.out.println("index j is" + j);
		System.out.println("sort value is " + array[j]);
		
		}
		
}
		}
