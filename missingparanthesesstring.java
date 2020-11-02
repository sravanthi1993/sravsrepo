package chinni;

import java.util.Stack;

public class missingparanthesesstring {
	
	static int missingparanthesis(String s)
	{
		if(s==null)
		{
			return 0;
		}
	Stack<Integer> st=new Stack<Integer>();
	
	char[] c=s.toCharArray();
	
	for(int i=0;i<c.length;i++)
	{
		if(c[i]=='*')
		{
			int p=st.pop();
			int r=p*(c[i+1]-'0');
			st.push(r);
			i++;
		}
		else if(c[i]!='+')
		{
			st.push(c[i]-'0');
		}
	}
	int r=0;
	while(!st.empty())
	{
		r=r+st.pop();
	}
		return r;
}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//String s="2+4+6*3*6*5+1+2";
		String s="2+4*6*3*6+5+1*2*6+8";
		//char[] c=s.toCharArray();
		int r=missingparanthesis(null);
		//int r=missingparanthesis(s);
		System.out.print(r);
		

	}

}
