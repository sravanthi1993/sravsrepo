package chinni;

public class lemonade_change {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a[]= {5,10,20};
		int fivecount=0;
		int tencount=0;
		for(int i=0;i<a.length;i++)
		{
			if(a[i]==5)
			{
				fivecount=fivecount+1;
			}
			else if(a[i]==10)
			{
				if(fivecount==0)
				{
					System.out.println("no change");
				}
				fivecount=fivecount-1;
				tencount=tencount+1;
			}
			else if(a[i]==20)
			{
				if(fivecount==0 ||(fivecount<3 && tencount==0))
				{
					System.out.println("no change");
				}
				else if(fivecount>=3 && tencount==0)
				{
					fivecount=fivecount-3;
				}
				else if(fivecount>=1 && tencount>=1)
				{
					fivecount=fivecount-1;
					tencount=tencount-1;
				}
				
			}
			System.out.println("five count && tencount is" + fivecount + "---" + tencount);
		}

	}

}
