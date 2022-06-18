package chinni;

import java.util.HashMap;
import java.util.List;


// Anagram
public class anagram {
	
	public boolean isAnagram(String s, String t) {
        
		HashMap<Character,Integer> h= new HashMap<Character,Integer>();
		
		for(int i=0;i<s.length();i++)
		{
			char c=s.charAt(i);
			Integer count = h.get(c);
			if(count != null) {
				h.put(c, count+1);
			}
			else
			{
				h.put(c, 1);
			}
		}
		for(int i=0;i<t.length();i++)
		{
			char c=t.charAt(i);
			Integer count = h.get(c);
			if(count != null) {
				h.put(c, count-1);
			}
			else
			{
				return false;
			}
		}
		
	for(Integer i:h.values())
	{
		if(i!=0)
		{ 
			return false;
		}
	}
		return true;
		
	}
	
	/*class Solution {
    public boolean isAnagram(String s, String t) {
        
     		HashMap<Character,Integer> h= new HashMap<Character,Integer>();
		
		for(int i=0;i<s.length();i++)
		{
			char c=s.charAt(i);
			if(h.containsKey(c)) {
				h.put(c, h.get(c)+1);
			}
			else
			{
				h.put(c, 1);
			}
		}
		for(int i=0;i<t.length();i++)
		{
			char c=t.charAt(i);
			if(h.containsKey(c)) {
				h.put(c, h.get(c)-1);
			}
			else
			{
				return false;
			}
		}
		
	for(Integer i:h.values())
	{
		if(i!=0)
		{
			return false;
		}
	}
		return true;
		
	}
}
*/

	/*   if (s.length() != t.length()) {
        return false;
    }
    char[] str1 = s.toCharArray();
    char[] str2 = t.toCharArray();
    Arrays.sort(str1);
    Arrays.sort(str2);
    return Arrays.equals(str1, str2);
    
}*/
}
