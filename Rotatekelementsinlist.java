package chinni;

public class Rotatekelementsinlist {

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

	
	static Node Rotatelinkedlistbyk(Node node,int k) {
		Node prev=null;
		Node current=node;
		int count=1;
		
		if(node==null)return null;
		while(current.next!=null) {
			current=current.next;
			count++;
		}
		//System.out.println(count);
		current.next=node;
		int kcount=((count-k)%count)-1;
		System.out.println(kcount);
		prev=node;
		while(kcount>0) {
			prev=prev.next;
			kcount--;
		}
		//System.out.println(kcount);
		node=prev.next;
		prev.next=null;
		return node;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node current=new Node(10);
		current.next = new Node(20); 
		current.next.next = new Node(30); 
		current.next.next.next = new Node(40); 
		current.next.next.next.next = new Node(50); 
       Node r=Rotatelinkedlistbyk(current,2);
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
