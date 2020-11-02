package chinni;

import java.util.Stack;

public class Redundantbraces {
	
	static int braces(String s) {
        Stack<Character> st = new Stack<Character>(); 
        int i = 0; 
        while(i < s.length()){ 
            char c = s.charAt(i); 
            if(c == '(' || c == '+' || c == '-' || c == '*' || c == '/'){ 
            	st.push(c); 
            } 
            else if(c == ')'){ 
                if(st.peek() == '(')
                    {
                	return 1;
                	} 
                else{ 
                    while(!st.isEmpty() && st.peek() != '(')
                    { 
                    	st.pop(); 
                    } 
                    st.pop(); 
                } 
            } 
            i++; 
        } 
        return 0; 
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "(a)";
		String b = "((a+b))";
		String c = "(a+(a+b))";
		String d = "(a+(a)+b)";
				
        System.out.println(braces(a));
		System.out.println(braces(b));
		System.out.println(braces(c));
		System.out.println(braces(d));

	}

}
