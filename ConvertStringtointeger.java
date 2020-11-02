package chinni;


public class ConvertStringtointeger {
	
	static int stringtoconvert(String s) {
		if(s.length()==0) {return 0;}
		s=s.trim();
		int n=0;int m=1;
		
		
		for(int i=0;i<s.length();i++) {
			if(i==0 && s.charAt(0)=='-' ) {
				 m=-1;
				// System.out.println(m);
			}
			else if(s.charAt(i)-'0'>=0 && s.charAt(i)-'0'<=9)
			{
			if (m == 1 && n > (Integer.MAX_VALUE-((s.charAt(i)-'0')))/10) {
	           return n = Integer.MAX_VALUE;
	            
	        } if (m == -1 && n*m < (Integer.MIN_VALUE+((s.charAt(i)-'0')))/10) {
	          return  n = Integer.MIN_VALUE;
	            
	        }
	        else n=(10*n+(s.charAt(i)-'0'));}
			//System.out.println(n);}
			else if ((s.charAt(0)!='-' && s.charAt(0)!='+')){
				{if(n==0) 
					return 0;
				}
				
			}
		}
		
		
		n=m*n;
		
		
		return n;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s="-91283472332";
		int n=stringtoconvert("  -9846831   fzdhfhz");
		int m=stringtoconvert(s);
		System.out.println(m);
		System.out.println(stringtoconvert("+1"));
		//System.out.println(Integer.MIN_VALUE +" ----- ");

	}

}
