package chinni;

public class Stringcompression {
	
	static String stringcompress(String s1) {
		StringBuilder sb = new StringBuilder();
		char s[]=s1.toCharArray();
			if(s == null)
				return null;
			int count=1;
			char x=s[0];
			for(int i=1;i<s.length;i++){
				
				if(s[i]==x) {
					count++;
					
				}
				
				else {
					sb.append(x);
					sb.append(count);
					//System.out.print(sb);
					x=s[i];
					count=1;
					}}
			sb.append(x);
			sb.append(count);
			
			if(s.length<=sb.length()) 
			{
				return s1;
			}
			else
				return s1= new String(sb);
			
				
			//return s1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String x=stringcompress("aaaaccdddxxyyzaa");
		//String x=stringcompress("aaa");
		System.out.print(x);

	}

}
