package chinni;

public class Add2numberslnkedlist {
	
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

	
	static Node Addnumbersinlinkedlist(Node l1,Node l2) {
		Node prev1 = null;
		Node prev2 = null;
        Node current1 = l1;
        Node current2 = l2;
        Node next = null; 
        Node prev = null;
        Node newnode=null;
        Node newhead=null;
        int x,y;
        int carry=0;int sum=0;
        /*while(current1 != null && current2==null)
        {
     	   System.out.print(current1.data);
     	   current1=current1.next;
        }
       
        while(current2 != null && current1==null)
        {
     	   System.out.print(current2.data);
     	   current2=current2.next;
        }*/
        if(current1 != null && current2==null)
        {
     	   //System.out.print(current1.data);
     	   while(current1!=null)
     	   {current1=current1.next;}return l1;
        }
        
       
        if(current2 != null && current1==null)
        {
     	   //System.out.print(current2.data);
     	   while(current2!=null)
     	   {current2=current2.next;}return l2;
        }
        current1=l1;
        current2=l2; 
       
        /*while (current1 != null) { 
            next = current1.next; 
            current1.next = prev1; 
            prev1 = current1; 
            current1 = next; 
        } 
        
        current1=prev1;
        prev1=current1;
        //System.out.print(prev1.data);
        while (current2 != null) { 
            next = current2.next; 
            current2.next = prev2; 
            prev2 = current2; 
            current2 = next; 
        }  
        
        current2=prev2;
        prev2=current2;
        //System.out.print(prev2.data);*/
        
        
        
        while(current1 != null || current2 != null) {
        	
        	if(current1!=null) {
        		x=current1.data;
        	}
        	else {x=0;}
        	if(current2!=null) {
        		y=current2.data;
        	}
        	else {y=0;}
        	sum=x+y+carry;
        	
        	if(sum>=10) {
        		carry=1;
        	}
        	else carry=0;
        	sum=sum%10;
        	newnode=new Node(sum);
        	if(newhead==null) {
        		newhead=newnode;
        	}
        	else {
        		prev.next=newnode;
        	}
        	prev=newnode;
        
        if(current1 != null) {
        	current1 =current1.next;		
        }
        if(current2 != null) {
        	current2 =current2.next;
        }
        }
        if(carry>0) {
        newnode.next=new Node(carry);
        }
        return newhead;
        //prev=null;
        /*System.out.print(newhead.data);
        while (newhead != null) { 
            next = newhead.next; 
            newhead.next = prev; 
            prev = newhead; 
            newhead = next; 
        }
        //System.out.print(prev.data);
		return prev;*/	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node current1=new Node(2);
		current1.next = new Node(4); 
		current1.next.next = new Node(3); 
		//current1.next.next.next = new Node(9); 
		//current1.next.next.next.next = new Node(9);
		Node current2=new Node(5);
		current2.next = new Node(6); 
		current2.next.next = new Node(4); 
		//current2.next.next.next = new Node(5); 
		//current2.next.next.next.next = new Node(6); 
       
       Node r=Addnumbersinlinkedlist(current1,current2);
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
