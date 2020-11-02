package chinni;

public class Scs {
	
	static	int max(int a,int b)
	{
		if(a>b) return a;
		return b;
	}

	
	static String shorteststring(String s1,String s2) {
		
		if(s1==null || s2==null)
		{
			return null;
		}
		
		int m=s1.length();
		int n=s2.length();
		int c[][]=new int[n+1][m+1];
		c[0][0]=0;
		c[0][m]=0;
		c[n][0]=0;
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				if(s2.charAt(i)==s1.charAt(j))
				{
					c[i+1][j+1]=c[i][j]+1;
				}
				else
				{c[i+1][j+1]=max(c[i+1][j],c[i][j+1]);}
			}
		}
		int l=n+m-c[n][m];
		char c1[]=new char[l];
		
		while(m!=0 && n!=0)
		{
			
			if(s2.charAt(n-1)!=s1.charAt(m-1))
			{
				if(c[n][m-1]<c[n-1][m] || c[n][m-1]==c[n-1][m])
				{
					c1[l-1]=s2.charAt(n-1);
					l--;
					n--;
					//System.out.print(c1);
				}
				else if(c[n][m-1]>c[n-1][m])
				{
					c1[l-1]=s1.charAt(m-1);
					l--;
					m--;
				}
			}
			else 
			{
				
					c1[l-1]=s2.charAt(n-1);
					l--;
					n--;
					m--;
					//System.out.println(c1);
					
			}
		}
		//System.out.println(m);
		//int r=m;
		if (n==0) {
			while(m!=0)
			{
			c1[l-1]=s1.charAt(m-1);
			l--;
			m--;
			}
		}
		else	if (n==0) {
			while(m>0)
			{
			c1[l-1]=s1.charAt(m-1);
			l--;
			m--;
			}
		}
		String s= new String(c1);
		return s;
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(shorteststring("AGGTAB", "GXT"));
		System.out.println(shorteststring("ABCDGH", null));
		System.out.println(shorteststring("geek", "eke"));

	}

}
