package chinni;

import chinni.Removeduplicates.Node;

public class Kthlastelementlinkedlist {
	
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
	
	
	static Node kthlastelement(Node node,int k) {
		Node current=node;
		Node next=null;
		Node prev=null;
		int m=0;
		int count=1;
		
		while(current!=null)
		{
			 next=current.next;
			current.next=prev;
			prev=current;
			current=next;
			m++;
		}
		if(k==0 || k>m)
		{
			return null;
		}
		while(count!=k) {
			//prev=current;
			//current=prev;
			prev=prev.next;
			//System.out.print(prev.data);
			count++;
		}
	
		
		
		return prev;
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node current=new Node(10);
		current.next = new Node(20); 
		current.next.next = new Node(320); 
		current.next.next.next = new Node(910); 
		current.next.next.next.next = new Node(920); 
       Node r=kthlastelement(current,3);
       if(r==null)
       {
    	   System.out.print("no element to return");
       }
       else System.out.print(r.data);
       //System.out.print(prev);
       /*while(r != null)
       {
    	   System.out.print(r.data);
    	   r=r.next;
       }*/

	}

}
