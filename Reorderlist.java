package chinni;
import java.util.*;

import chinni.Rotatekelementsinlist.Node;
public class Reorderlist {
	
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

	
	static Node Reorderlinkedlist(Node node) {
		
		Node current=node;
		int count=1;
		
		if(node==null)return null;
		while(current.next!=null) {
			current=current.next;
			count++;
		}
		Node a[]=new Node[count];
		
		current=node;
		int n=count;
		
		
		for(int i=0;i<=count-1;i++) {
			a[i]=current;
			current=current.next;
			
		}
		count=0;
		int i=0;
		int x=n;
		while(i<x/2) {
			a[i].next=a[n-1];
			a[n-1].next=a[i+1];
			i++;
			n--;
		}
		
		a[i].next=null;
		
		return a[0];
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
  
		Node current=new Node(10);
		current.next = new Node(20); 
		current.next.next = new Node(30); 
		current.next.next.next = new Node(40); 
		current.next.next.next.next = new Node(50);
		current.next.next.next.next.next = new Node(60);
		Node r=Reorderlinkedlist(current);
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
