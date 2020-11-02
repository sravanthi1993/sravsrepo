package chinni;

public class ReversefullString {
	
static String reversecompletestring(String s1) {
		
		if(s1 == null)
			return null;
		
		char s[]=s1.toCharArray();
		int start =0, end=s.length-1;
			
				while(start < end)
				{
				char temp;
				temp = s[end];
				s[end] = s[start];
				s[start]=temp;
				start++;
				end--;
				}
				
		
		return new String(s);
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.print(reversecompletestring("this is a string"));
	}

}
