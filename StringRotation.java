package chinni;

public class StringRotation {
	static String anticlockrotate(String s, int k) {
		StringBuilder sb=new StringBuilder();
		if(s.length()==0 || s.length()==1)
		{
			return s;
		}
		for(int i=k;i<s.length();i++) {
			sb.append(s.charAt(i));
		}
		for(int i=0;i<k;i++) {
			sb.append(s.charAt(i));
		}
		s=sb.toString(); 
		return s;
		
	}
	
	static String clockrotate(String s, int k) {
		int i=0;
		char[] c=s.toCharArray();
		if(k==c.length)
		{
			System.out.println("array is same");
		}
		else {
			k=k % c.length;
			int start=0;
			int end=c.length-1;
			
			
			
			while(start<=end)
			{
				if(start==end)
				{
					break;
				}
			char x=c[start];
				c[start]=c[end];
				c[end]=x;
				start++;
				end--;
				System.out.println("start and end values are" +start +"--" + end);
				
			}

			for( i=0;i<k/2;i++)
			{
			char x=c[i];
			c[i]=c[k-i-1];
			c[k-i-1]=x;
			
			}

			int y=c.length;
				for(i=k ;i<((c.length+k)/2);i++)
				
				{
					
					char x=c[i];
					c[i]=c[y-1];
					c[y-1]=x;	
					y--;
				}
		
		}
		s=c.toString();
		System.out.println(c);
		return s;}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="amazon";
		String r=clockrotate(s,2);
		String m=anticlockrotate(s,2);
		System.out.println(r.toString());	
		System.out.println(m);
		

	}

}
