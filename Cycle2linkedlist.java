package chinni;

import java.util.HashMap;

public class Cycle2linkedlist {
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
        
         static Node cyclic2list(Node node) {
        	HashMap<Node,Integer> h=new HashMap<Node,Integer>();
        	Node current=node;
        	//Node next=null;
        	//int count=1;
        	//Node cyclic=null;
        	while(current!=null) {
        		if(h.containsKey(current)) {
        			return current;
        		}
        		else {
        			h.put(current, 1);
        			current=current.next;
        		}
        	}
        	
			return null;
        	
        }
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node current=new Node(10);
		current.next = new Node(20); 
		current.next.next = new Node(320); 
		current.next.next.next = new Node(910); 
		current.next.next.next.next = new Node(920);
		/*Node r=cyclic2list(current);
	       if(r==null)
	       {
	    	   System.out.print("no element to return");
	       }
	       else System.out.print(r.data);
	}*/

	

	}	

}
