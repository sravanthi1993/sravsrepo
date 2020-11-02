package chinni;

import chinni.CloneLinkedlist.Node;

public class Partitionlist {
	static class Node { 
        int data; 
        Node next; 
        Node RP;
        
        Node(int d) { 
            data = d; 
            next = null; 
        } 
        Node(){
        	data=0;
        	next=null;
        }
	}
	
	
	static Node Partionlinkedlistx(Node node,int x) {
		Node current=node;
		Node newnode=null;
		Node prev=null;
		Node head=null;
		int count=0;
		
		if(node==null) {
			return null;
		}
		while(current!=null) {
			
		if(current.data>=x) {
			prev=current;
			current=current.next;	
			}
		else {
			prev.next=current.next;
			
			if(count==0) {
			newnode=current;
			head=current;
			//newnode.next=null;
			current=prev.next;
			//current=current.next;
			count++;
				}
			else {
				newnode.next=current;
				newnode=current;
				current=prev.next;
				//current=current.next;
				}
			}
		
		}
			newnode.next=node;
	
			return head;
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node current=new Node(1);
		current.next = new Node(4); 
		current.next.next = new Node(3); 
		current.next.next.next = new Node(2); 
		current.next.next.next.next = new Node(5); 
		current.next.next.next.next.next = new Node(2); 
		Node r=Partionlinkedlistx(current,3);
		while(r != null)
	       {
	    	   System.out.print(r.data);
	    	   r=r.next;

		}

	}

}
