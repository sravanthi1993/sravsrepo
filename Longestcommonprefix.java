package chinni;

import java.util.List;

public class Longestcommonprefix {
	
	static String Longestprefix(String[] l)
	{
		if(l.length == 0)
            return "";

		int prelength=0;
		String s1=l[0];
		for(int i=0;i<s1.length();i++) {
		for (String s:l) {
			if(s.length()<=i || s.charAt(i)!=s1.charAt(i)) {
				return s1.substring(0,prelength);
				
			}	
		}
		prelength++;
		}
		System.out.println(prelength);
		
		return s1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] l= {"Apple","Ape","Appartment"};
		String s1=Longestprefix(l);
		System.out.println(s1);
	}

}
