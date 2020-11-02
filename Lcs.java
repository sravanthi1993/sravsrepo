package chinni;

public class Lcs {
	
 static	int max(int a,int b)
	{
		if(a>b) return a;
		return b;
	}

	
	static String Lcsstring(String s1,String s2) {
		
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
		int l=c[n][m];
		char c1[]=new char[l];
		
		while(c[n][m]!=0)
		{
			if(s2.charAt(n-1)!=s1.charAt(m-1))
			{
				if(c[n][m-1]<c[n-1][m])
				{
					n--;
				}
				else 
				{
					m--;
				}
			}
			else 
			{
					c1[l-1]=s2.charAt(n-1);
					l--;
					n--;
					m--;
					
			}
		}
		String s= new String(c1);
		return s;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			System.out.println(Lcsstring("ABCDGH", "AEDFHR"));
			System.out.println(Lcsstring("ABCDGH", null));
	}

}
