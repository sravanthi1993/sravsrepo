package chinni;

public class Longestsubstring {
	
static String Longestcommonsubstring(String s1,String s2) {
		
		if(s1==null || s2==null)
		{
			return null;
		}
		int max=0;
		int maxi=0;
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
					if(max<c[i+1][j+1])
					{
						max=c[i+1][j+1];
						//System.out.println(max);
						maxi=j;
					}
				}
				else
				{c[i+1][j+1]=0;}
			}
		
		//int l=c[n][m];
		//
		}
		char c1[]=new char[max];
		char c2[]=s1.toCharArray();
		System.out.println(max);
		while(max!=0) {
			
			c1[max-1]=c2[maxi];
			maxi--;
			max--;
		}
		String s=new String(c1);
		
		return s ;}
		

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Longestcommonsubstring("abcdxyz", "xyzabcd"));
		System.out.println(Longestcommonsubstring("zxabcdezy", "yzabcdezx"));
		System.out.println(Longestcommonsubstring("abcdxyz", null));

	}

}
