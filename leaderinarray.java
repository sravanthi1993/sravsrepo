package chinni;

public class leaderinarray {
	
	public static void main(String[] args) {
		
		int a[]= {16,17,4,3,5,2};
		//int a[]= {};
		int n=a.length;
		int leader=0;
		int i;
		if (n==0)
		{
			System.out.println("no leader found");
		}
		else {
		leader=a[n-1];
		System.out.println("leader is" + leader);
		
		for(i=n-2;i>=0;i--)
		{
			if(leader<a[i])
			{
				leader=a[i];
				System.out.println("leader is" + leader);
			}
		}
		}
		
	}

}
