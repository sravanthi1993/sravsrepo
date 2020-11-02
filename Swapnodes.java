package chinni;

public class Swapnodes {
	static class Node { 
        int data; 
        Node next; 
        
        Node(int d) { 
            data = d; 
            next = null; 
        } 
	}
	static  Node swap2nodes(Node node) {
		Node prev = null; 
        Node current = node; 
        Node next = null;
        Node tail = node;
        Node head = null;
        if(node==null || node.next==null) {return node;}
			head=node.next;
		
    for(int i=0;i<2;i++) { 
        next = current.next; 
        current.next = prev; 
        prev = current; 
        current = next; 
    } 
    //Node newnode=current;
    tail.next=swap2nodes(current);
    return head; 
    
} 
	/*static  Node swapingnodes(Node node) { 
	        Node prev = null; 
	        Node current = node; 
	        Node next = null;
	        Node tail = null;
	        Node head = null;
	        if(node==null || node.next==null) {return node;}
	        
	        Node newnode=node.next.next;
	        head=swap2nodes(node);
	        return head;
	}*/
	      

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node current= new Node(10); 
		current.next = new Node(15); 
		current.next.next = new Node(20); 
		//current.next.next.next = new Node(25); 
       Node r=swap2nodes(current);
       //System.out.print(r.data);
       
       while(r != null)
       {
    	   System.out.print(r.data);
    	   r=r.next;
       }
	}

}
