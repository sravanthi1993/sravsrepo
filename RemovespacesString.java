package chinni;

public class RemovespacesString {
	
	static String removespaces(String s1) {
		
		if(s1==null)
			return null;
		
		int currentindex=-1;
		char s[]=s1.toCharArray();
		
		for(int i=0;i<s1.length();i++) {
			if(s[i]!=' ')
			{
				currentindex=currentindex+1;
				s[currentindex]=s[i];
			}
			
		}
		System.out.println(currentindex);
		System.out.println(s);
		//s[currentindex+1]='\0';String(value(array the source of characters,offset,count);
		return new String(s,0,currentindex+1);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(removespaces("I   love  ice  cream"));

	}

}
