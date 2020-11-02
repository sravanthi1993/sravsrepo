package chinni;

public class Reversestring {

	static String reversewordstring(String s1) {
		
		if(s1 == null)
			return null;
		
		char s[]=s1.toCharArray();
		int start =0, end=0;
			
		for(int i=0; i<s.length; i++)
		{
			if(s[i] == ' ')
			{
				end = i-1;
				while(start < end)
				{
				char temp;
				temp = s[end];
				s[end] = s[start];
				s[start]=temp;
				start++;
				end--;
				}
				start = end = i+1;
			}
			else if( end == s.length-1)
			{
				end = i;
				while(start < end)
				{
				char temp;
				temp = s[end];
				s[end] = s[start];
				s[start]=temp;
				start++;
				end--;
				}
			}
			else
				end++;
		}
		
		return new String(s);
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.print(reversewordstring("t"));
	}

}
