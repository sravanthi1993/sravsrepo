package chinni;

public class ReplacespacesString {

static String replacespaces(String s1) {
	StringBuilder sb = new StringBuilder();
	char s[]=s1.toCharArray();
		if(s == null)
			return null;
		
		for(int i=0;i<s.length;i++){
			if(s[i]==' ') {
				sb.append("%20");
				
			}
			else sb.append(s[i]);
		}
		
		return s1=new String(sb);
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String x=replacespaces("ab cd xy z");
		System.out.print(x);
	}

}
