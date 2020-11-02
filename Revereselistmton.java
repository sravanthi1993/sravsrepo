package chinni;

import chinni.reverselinkedlist.Node;

public class Revereselistmton {
	static class Node { 
        int data; 
        Node next; 
        
        Node(int d) { 
            data = d; 
            next = null; 
        } 
	}
	static  Node reverselistfrommton(Node node,int m,int n) {
		Node prev = null; 
        Node current = node; 
        Node next = null; 
        int count=1;
        Node head = null; 
        Node tail = null; 
        
		while(current!=null && count<m) {
			tail=current;
			current=current.next;
			count++;
		}
		head=current;
		for(int i=0;i<=n-m;i++) {
			next = current.next; 
            current.next = prev; 
            prev = current; 
            current = next; 
        }
		if(tail!=null) {
		tail.next=prev;}
		node=prev;
		head.next=current;
		
		while (current != null) {
        current=current.next;
        }
		
		return node;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node current= new Node(1); 
		current.next = new Node(2); 
		current.next.next = new Node(3); 
		current.next.next.next = new Node(4);
		current.next.next.next.next = new Node(5);
       Node r=reverselistfrommton(current,1,3);
       //System.out.print(r.data);
       
       while(r != null)
       {
    	   System.out.print(r.data);
    	   r=r.next;
       }

	}

}
