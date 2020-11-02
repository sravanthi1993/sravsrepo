package chinni;

import java.util.HashMap;

public class CloneLinkedlist {
	
	static class Node { 
        int data; 
        Node next; 
        Node RP;
        
        Node(int d,Node rp) { 
            data = d; 
            next = null; 
            RP=rp;
        } 
        
        Node(int d) { 
            data = d; 
            next = null; 
        } 
        
        Node(){
        	data=0;
        	next=null;
        	RP=null;
        }
	}
	
	
	static Node clonelistrandompointer(Node node) {
		Node current=node;
		Node l2=null;
		Node prev=null;
		HashMap<Node,Node> h=new HashMap<Node,Node>();
		
		
		if(node==null) {
			return null;
		}
		while(current!=null)
		{
			Node newnode=new Node();
			h.put(current, newnode);
			newnode.data=current.data;
			newnode.next=null;
			if(prev != null)
			    prev.next=newnode;
			/*else
				l2 = newnode;*/
			prev=newnode;
			current=current.next;
			
		}
		prev.next=null;
		current=node;
		while(current!=null)
		{Node x;
		x=current.RP;
			h.get(current).RP= h.get(current.RP);
			current=current.next;
			
		}
		
		return h.get(node);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node current=new Node(10);
		current.next = new Node(20); 
		current.next.next = new Node(320); 
		current.next.next.next = new Node(910); 
		current.next.next.next.next = new Node(920); 
		current.RP=current.next;
		current.next.RP=current.next.next.next;
		current.next.next.RP=current.next.next.next.next;
		current.next.next.next.RP=current;
		current.next.next.next.next.RP=current.next.next;
		
       //Node r=clonelistrandompointer(current);
       Node r = current;
       while(r != null)
       {
    	   System.out.print(r.data);
    	   System.out.println(r.RP.data);
    	   r=r.next;

	}
       r=clonelistrandompointer(current);
       while(r != null)
       {
    	   System.out.print(r.data);
    	   System.out.println(r.RP.data);
    	   r=r.next;

	}
	}
	}
