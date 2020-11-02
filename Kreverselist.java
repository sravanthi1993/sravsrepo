package chinni;

import chinni.reverselinkedlist.Node;

//import chinni.reverselinkedlist.Node;

public class Kreverselist {
	
	static class Node { 
        int data; 
        Node next; 
        
        Node(int d) { 
            data = d; 
            next = null; 
        } 
	}
	static  Node reverseklist(int k,Node node) { 
		
	        Node prev = null; 
	        Node current = node; 
	        Node next = null;
	        int count=1;
	        Node last=null;
	        if(node==null)
	        {
	        	return null;
	        }
	        while (current != null && count<=k) 
	        { 
	        	if(count==1)
	        	{
	        		last=current;
	        		System.out.println(last.data);
	        	}
	            next = current.next; 
	            current.next = prev; 
	            prev = current; 
	            current = next;
	            count++;
	        }  
	        //System.out.print(prev.data);
	        last.next=reverseklist(k,current);
	        return prev; 
	    } 

	
	public static void main(String[] args) {
		
		Node l= new Node(10); 
        l.next = new Node(20); 
        l.next.next = new Node(30); 
        l.next.next.next = new Node(40); 
        l.next.next.next.next = new Node(50);
       // l.next.next.next.next.next = new Node(35);
       Node r=reverseklist(2,l);
       //System.out.print(r.data);
       
       while(r != null)
       {
    	   System.out.println(r.data);
    	   r=r.next;
       }
        
		
	}
	
}


