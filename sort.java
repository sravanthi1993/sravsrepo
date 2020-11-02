package chinni;

public class sort {
	public static void main(String args[]) {
		int array[] = { 2, 5, -2, 6, -3, 8, 0, -7, -9, 4 };

		int b[] = new int[10];
		int x =0;
		int ans=Integer.MIN_VALUE;
		int ans2=Integer.MAX_VALUE;
		
		for(int j=0;j<10;j++)
		{
		for (int i=0;i<10;i++)
		{
			//if(ans>array[i])
			//{
				//ans=array[i];
			//}
			
			if (ans < array [i] &&  array [i] < ans2) 
			{
				
				ans2=array[i];
				x=ans;
				
			}
			
			//b[j]=ans;
			//ans=ans2;	
			//ans=ans2;
			System.out.println("answer is " + ans +"*" + ans2);
			
		}
		
		System.out.println("answer is " + ans +"/" + ans2);
		ans=ans2;
		b[j]=ans;
		ans2=Integer.MAX_VALUE;
		System.out.println("sort value is " + b[j]);
		}
		//ans=ans2;
		
	}
		}