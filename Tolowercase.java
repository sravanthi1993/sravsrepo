package chinni;

public class Tolowercase {
	
	static String tolowercase(String s) {
		//char[] c=new char[s.length()];
		StringBuilder sb=new StringBuilder();
		//int length=0;
		for(int i=0;i<s.length();i++) {
			if((s.charAt(i)-'a')>=0 && (s.charAt(i)-'a')<=26) {
				 sb.append(s.charAt(i));
				//c[length]=s.charAt(i);
				//length++;
			}
			else {
				//int x=s.charAt(i)+32;
				//char m=char(x);
				//c[length]= (char) (s.charAt(i)+32);
				sb.append((char) (s.charAt(i)+32));
				//System.out.println(sb);
				//length++;
				
			}
			
		}
		
		String m=sb.toString();
		
		return m;
/*StringBuilder sb=new StringBuilder();
		
		for(int i=0;i<s.length();i++) {
			if((s.charAt(i))>=97 && (s.charAt(i))<=122) {
				sb.append(s.charAt(i));
			}
			else if(s.charAt(i)>=65 && s.charAt(i)<=90) {
				sb.append((char) (s.charAt(i)+32));
				//System.out.println(sb);	
			}
            else sb.append(s.charAt(i));
            }
		
		String m=sb.toString();
		
		return m;*/
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String l=tolowercase("Hello");
		System.out.println(l);

	}

}
