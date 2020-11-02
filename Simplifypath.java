package chinni;

import java.util.Stack;

public class Simplifypath {
	
	static String Simplifyunixpath(String s) {
        Stack<String> st = new Stack<String>(); 
        String[] ss=s.split("/");
        String finalpath;
        /*for(int i=0;i<ss.length;i++)
        {	
        System.out.print(ss[i]);
        }
        System.out.print(ss.length);*/
        for(int i=0;i<ss.length;i++)
        {
        	if(ss[i].equals("..")) {
        		if(!st.isEmpty()) 
        		{
        		st.pop();
        	}}
        	else if(!ss[i].equals(".") && !ss[i].equals("")) {
        		System.out.println(st.push(ss[i]));
        	}
        
        }
        
        if(!st.isEmpty()) {
             finalpath=st.pop();
        while(!st.isEmpty())
        {
        	finalpath= st.pop()+"/"+ finalpath;
        }}
        else 
        	{finalpath="";}
        
		return finalpath="/"+ finalpath;
         
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//String s="/home/a//b/c/d/.././//f";
		String s="//../";
		String path=Simplifyunixpath(s);
		System.out.println(path);
		

	}

}
