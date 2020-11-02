package chinni;

import java.util.HashMap;

public class Stringpermutation {
	//HashMap<Character,Integer> h=new HashMap<Character,Integer>();
	
	static boolean permutation(String s1,String s2) {
		HashMap<Character,Integer> h=new HashMap<Character,Integer>();
		
		if(s1==null && s2==null)
			return true;
		if(s1==null && s2!=null )
			return false;
		if(s2==null && s1!=null)
			return false;
		
		char c1[]=s1.toCharArray();
		char c2[]=s2.toCharArray();
		for(int i=0;i<s1.length();i++) {
			int x;
			if(h.containsKey(c1[i])) {
				
				x=h.get(c1[i]);h.put(c1[i], x+1);
				
			}
			else h.put(c1[i],1);
		}
		for(int i=0;i<s2.length();i++) {
			if(h.containsKey(c2[i])) {
				int x=h.get(c2[i])-1;
			if(x==0) {
				h.remove(c2[i]);
			}
			else h.put(c2[i], x);
			}
			else return false;
			
		}
		if(h.isEmpty()) {
			return true;
		}
		return false;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean s=permutation("alert","alerts");
		//boolean s=permutation("asd;",null);
		System.out.println(s);
		
	}

}
