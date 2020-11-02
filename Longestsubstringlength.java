package chinni;

import java.util.HashMap;

public class Longestsubstringlength {
	
	static int lengthoflongestsubstring(String s) {
		if(s.length()==0 || s.length()==1) {
			return s.length();
		}
		int maxlength=0;
		HashMap<Character,Integer> h = new HashMap<Character, Integer>();
		
		for(int i=0;i<s.length();i++) {
			if(!h.containsKey(s.charAt(i))) {
				h.put(s.charAt(i), i+1);
			}
            else 
            {
                
			if(maxlength<=h.size()) {
				maxlength=h.size();
			}
				int x=h.get(s.charAt(i));
				while(x!=0) {
                    Integer val = h.get(s.charAt(x-1));
				if(val != null && val <=x) {
                   // if(h.get(s.charAt(x-1))<=x) {
				h.remove(s.charAt(x-1));}
                    else
                        break;
				x--;}
				h.put(s.charAt(i), i+1);
            }
			
				
		}
		if(maxlength<h.size()) {
			maxlength=h.size();
		}
		return maxlength;
		
		/*else if(maxlength==h.size()) {
		int x=h.get(s.charAt(i));
		
		while(x!=0) {
			if(h.containsKey(s.charAt(x-1))) {
			h.remove(s.charAt(x-1));}
			x--;}
			h.put(s.charAt(i), i+1);
	}*/
	//else if(h.containsKey(s.charAt(i)) && maxlength>h.size())
	/*else if(maxlength<h.size()) {
		int x=i;
		maxlength=h.size();
		while(!h.isEmpty()) {
			if(h.containsKey(s.charAt(x))) {
		h.remove(s.charAt(x));}
		x--;}
		h.put(s.charAt(i), i);*/
		
		/*char[] c=s.toCharArray();
		
		int length=0;
		for(int i=0;i<s.length();i++) {
			int count=0;
			while(i<s.length()-1 && c[i]==c[i+1]) {
				if(count==0) {
					c[length]=c[i];
					//System.out.println(c[length]+"--");
					length++;
				}
				count++;
				i++;
			}
			
			if(i<s.length()-1 && c[i]!=c[i+1]) {
				c[length]=c[i];
				//System.out.println(c[length]+"  " +i);
				length++;
			}
			
			int temp=length;
			while(temp>1 && c[i]!=c[temp-2]) {
				temp--;
				}
			if(i==s.length()-1 && temp==1 && c[i]!=c[i-1]) {
				c[length]=c[i];
				length++;
			}
			
			if(temp>1 && c[i]==c[temp-2]) {
				//System.out.println(c[i]);
				//System.out.println(c[temp-2]);
				length--;
			}*/
			/*if(s.length()-1==length) {
				if(i>0 && c[i]!=c[i-1]) {
					c[length]=c[i];
					length++;
				}
			}*/
				
			/*if(count==0) {
				c[length]=c[i];
				length++;}*/
		
		//}
		
		
		//System.out.println(new String(c,0,length));
		//return length;
}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="abcabcbb";
		String s1="bbbbbb";
		String s2="pwekweh";
		String s3="pwwkew";
		String s4="auapqrst";
		String s5="dvdf";
		String s6="jbpnbwwd";
		String s7="bpfbhmipx";
		System.out.println(lengthoflongestsubstring(s));
		System.out.println(lengthoflongestsubstring(s1));
		System.out.println(lengthoflongestsubstring(s2));
		System.out.println(lengthoflongestsubstring(s3));
		System.out.println(lengthoflongestsubstring(s4));
		System.out.println(lengthoflongestsubstring(s5));
		System.out.println(lengthoflongestsubstring(s7));
	}

}
