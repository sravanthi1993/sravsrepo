package chinni;

public class Mergingtwosortedlists {
	
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

	
	static Node mergeTwoLists(Node l1, Node l2) {
		Node newnode=null;
		Node current1=l1;
		Node current2=l2;
		Node newtail=null;
		if(current1==null && current2==null)
        {
        	return null;
        }
		if(current1==null && current2!=null)
        {
        	return current2;
        }
		if(current2==null && current1!=null)
        {
        	return current1;
        }
		
		if(current1!=null && current2!=null) {
			
		if(current1.data<=current2.data) 
		{newnode=current1;
		newtail=current1;
		current1=current1.next;}
		else 
		{newnode=current2;
		newtail=current2;
		current2=current2.next;}}
	
		//System.out.print(current1.data);
		//System.out.print(current2.data);
		
		while(current1!=null && current2!=null) {
			
			if(current1.data<=current2.data) 
			{
				newtail.next=current1;
				newtail=current1;
				current1=current1.next;
				//System.out.print(newtail.data);
			}
			else 
			{
			
			newtail.next=current2;
			newtail=current2;
			current2=current2.next;
			}
			
		}
		if(current1==null && current2!=null) {
			while(current2!=null) {
			newtail.next=current2;
			newtail=current2;
			current2=current2.next;
			}
		}
		if(current2==null && current1!=null) {
			while(current1!=null) {
			newtail.next=current1;
			newtail=current1;
			current1=current1.next;
			}
		}
		
		return newnode;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node current1=new Node(1);
		current1.next = new Node(2); 
		current1.next.next = new Node(4); 
		//current1.next.next.next = new Node(910); 
		//current1.next.next.next.next = new Node(920);
		Node current2=new Node(1);
		current2.next = new Node(3); 
		current2.next.next = new Node(4); 
		current2.next.next.next = new Node(5); 
		current2.next.next.next.next = new Node(6); 
       
       Node r=mergeTwoLists(current1,current2);
       if(r==null)
       {
    	   System.out.print("no element to return");
       }
       while(r != null)
       {
    	   System.out.print(r.data);
    	   r=r.next;
       }
	}

	}
