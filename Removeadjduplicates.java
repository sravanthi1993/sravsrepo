package chinni;

public class Removeadjduplicates {
	
	static String removeadjduplstring(String s) {
		char[] c=s.toCharArray();
		
		if(s.length()==0 || s.length()==1)
			return s;
		
		int length=0;
		for(int i=0;i<s.length();i++) {
			int count=0;
			while(i<s.length()-1 && c[i]==c[i+1]) {
				count++;
				i++;
			}
			if(length>0 && c[i]==c[length-1]) {
				length--;
				count++;}
				
			if(count==0) {
				c[length]=c[i];
				length++;}
				
			/*else {
				if(length>0 && i<s.length()-1 && c[i]==c[length-1] && c[i]!=c[i+1]) {
					length--;
					i++;
					c[length]=c[i];
					length++;
					
				}*/
				/*else if(c[i]==c[length-1]) {
					length--;
					System.out.println(length +"@@");
					while(i<s.length()-1 && c[i]==c[i+1]) {
						count++;
						i++;
						System.out.println(i + "**");
					}
				}*/
			}
			
		//}
		
		if(length==0) {
			return null;
		}
		else
			
		return new String(c,0,length);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(removeadjduplstring("caaabbbaacdddd"));
		System.out.println(removeadjduplstring("axyyxxz"));
		System.out.println(removeadjduplstring("acaaabbbacdddd"));
		System.out.println(removeadjduplstring("axxaaabacxxac"));
		System.out.println(removeadjduplstring("ssssss"));

	}

}
