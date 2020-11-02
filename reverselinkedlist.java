package chinni;

public class reverselinkedlist {
	
	static class Node { 
        int data; 
        Node next; 
        
        Node(int d) { 
            data = d; 
            next = null; 
        } 
	}
	static  Node reverse(Node node) { 
	        Node prev = null; 
	        Node current = node; 
	        Node next = null; 
	        while (current != null) { 
	            next = current.next; 
	            current.next = prev; 
	            prev = current; 
	            current = next; 
	        }  
	        System.out.print(prev.data);
	        return prev; 
	    } 
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//reverselinkedlist l = new reverselinkedlist(); 
        Node l= new Node(10); 
        l.next = new Node(15); 
        //l.next.next = new Node(20); 
        //l.next.next.next = new Node(25); 
       Node r=reverse(l);
       //System.out.print(r.data);
       
       while(r != null)
       {
    	   System.out.print(r.data);
    	   r=r.next;
       }
        
	}

}
