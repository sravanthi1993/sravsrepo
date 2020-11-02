package chinni;
import java.util.HashMap;
public class Removeduplicates {
		
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
		
		
		static Node removedupl(Node node) {
			Node current=node;
			Node next=null;
			Node prev=null;
	
	HashMap<Integer,Node> h=new HashMap<Integer,Node>();
	
	while(current!=null) {
		if(h.containsKey(current.data))
		{
			prev.next=current.next;
			current=current.next;
		}
		else {
			h.put(current.data, current);
			prev=current;
			current=current.next;
		}
	}
	
	return node;
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node current=new Node(10);
		current.next = new Node(20); 
		current.next.next = new Node(320); 
		current.next.next.next = new Node(910); 
       Node r=removedupl(current);
       
       //System.out.print(r);
       while(r != null)
       {
    	   System.out.print(r.data);
    	   r=r.next;
       }

	}

}
