package chinni;

public class Removeoutermostparanthesis {

	static String removeouterpara(String s) {
		int count=0;
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='(') {
				if(count>0) {
				sb.append(s.charAt(i));
				count++;
			}
				else	count++;}
			
				else if(s.charAt(i)==')') {
					if(count>1) {
					sb.append(s.charAt(i));
					count--;
				}
					else	count--;
				
			}
		}
		String s1=sb.toString();
		return s1;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String s1=removeouterpara("(()())(())(()(()))");
		//String s1=removeouterpara("(()())(())");
		String s1=removeouterpara("()()");
		
		System.out.println(s1);

	}

}
