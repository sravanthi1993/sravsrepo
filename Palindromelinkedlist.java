package chinni;

import java.awt.List;



public class Palindromelinkedlist {

	static class Node { 
        int data; 
        Node next; 
        
        Node(int d) { 
            data = d; 
            next = null; 
            
        } 
        
        Node(){
        	data=0;
        	next=null;
        }
	}
	
	
	static boolean palindrome(Node node) {
		Node current=node;
		Node l2=null;
		
		
		if(node==null) {
			return true;
		}
		while(current!=null)
		{
			Node newnode=new Node();
			newnode.data=current.data;
			newnode.next=l2;
			l2=newnode;
			current=current.next;
			
		}
		//return l2;
		current=node;
	
		while(current!=null)
		{
			if(current.data==l2.data)
			{
				current=current.next;
				l2=l2.next;
			}
			else return false;
		}
		 return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node current=new Node(20);
		current.next = new Node(10); 
		current.next.next = new Node(10); 
		//current.next.next.next = new Node(10); 
       boolean r=palindrome(current);
       
       System.out.print(r);
       
     /*  while(r != null)
       {
    	   System.out.print(r.data);
    	   r=r.next;
       }*/
        

	}

}
