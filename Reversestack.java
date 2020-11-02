package chinni;

import java.util.Stack;

public class Reversestack {
	
	static Stack<Integer> reverse2string(Stack<Integer> s1) {
		
		if(s1==null || s1.size()==1)
		{
			return s1;
		}
		
		Stack<Integer> s2=new Stack<Integer>();
		while(!s1.isEmpty())
		{
			int count=0;
			int temp=s1.pop();
			while(!s2.isEmpty()) {
				s1.push(s2.pop());
				count=count+1;
			}
			s2.push(temp);
			while(count!=0) {
				s2.push(s1.pop());
				count--;
			}
		}
			while(!s2.isEmpty()) {
				s1.push(s2.pop());
			}
			return s1;
		
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Stack<Integer> s1=new Stack<Integer>();
		s1.push(1);
		s1.push(2);
		s1.push(3);
		s1.push(4);
		s1.push(5);
		s1.push(6);
		s1.push(7);
		
		Stack<Integer> s=reverse2string(null);
		System.out.println(s);
		

	}

}
