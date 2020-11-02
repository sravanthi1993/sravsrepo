package chinni;

import java.util.HashMap;

public class RomantoIntegerString {
	
	static int romantointeger(String s) {
	if (s == null || s.length() == 0)
        return -1;
		
    HashMap<Character,Integer> h = new HashMap<Character, Integer>();
    h.put('I', 1);
    h.put('V', 5);
    h.put('X', 10);
    h.put('L', 50);
    h.put('C', 100);
    h.put('D', 500);
    h.put('M', 1000);
    
    int prev = 0;
    int r = 0;
    for (int i = s.length() -1; i >= 0; i--) {   
        int cur = h.get(s.charAt(i));
        if (prev > cur) {
            r =r- cur;
        } else {
            r =r+ cur;
        }
        prev = cur;
    }
    
    return r;}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int result=romantointeger("MCMXCIV");
		System.out.println(result);
	}

}
