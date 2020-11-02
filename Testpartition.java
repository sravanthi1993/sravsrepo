package chinni;

import chinni.Partitionlist.Node;

public class Testpartition {
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
	
    static Node partition(Node node, int x) {
        Node current=node;
        Node newnode=null;
        Node prev=null;
		Node head=null;
		int count=0;
		int count1=0;
		Node highhead=null;
		
		if(node==null) {
			return null;
		}
		
		while(current!=null) {
			
		if(current.data>=x)
		{
			if(count1==0){
				highhead=current;
				count1++;}
		prev=current;
		current=current.next;
		}
		
	
		else {
            if(prev!=null){
			prev.next=current.next;}
			
			if(count==0) {
			newnode=current;
			head=current;
			//newnode.next=null;
                if(prev!=null){
			current=prev.next;}
			else{
            current=current.next;}
			count++;
				}
			else {
				newnode.next=current;
				newnode=current;
				if(prev!=null){
			current=prev.next;}
			else{
            current=current.next;}
				//current=current.next;
				}
			}
		
		}
		if(prev!=null) {
			newnode.next=highhead;}
		else newnode.next=null;
	
			return head;
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node current=new Node(1);
		current.next = new Node(7); 
		current.next.next = new Node(2); 
		current.next.next.next = new Node(1); 
		current.next.next.next.next = new Node(6); 
		current.next.next.next.next.next = new Node(0); 
		Node r=partition(current,3);
		while(r != null)
	       {
	    	   System.out.print(r.data);
	    	   r=r.next;

		}


	}

}
