package chinni;

public class Queue {

	int head=0;
	int tail=0;
	int count=0;
	int arr[];
	
	Queue()
	{
		arr = new int[5];
	}
	
	Queue(int l)
	{
		arr = new int[l];
	}
	
	void Enqueue(int data)
	{
		if(count==arr.length)
		
		{
			Increasesize();
		}

			arr[tail]=data;
		
			tail=(tail+1)%arr.length;
			
			count++;
		
	}
	
	int dequeue()
	{
		int data;
		
		data=arr[head];
		
		//arr[head]=null;
		
		head=(head+1)%arr.length;
		
		count--;
       
		return data;
	}
	
	void Increasesize()
	{
		int newarr[]=new int[arr.length*2];
		int x=0;
		for(int i=head;i<=arr.length-1;i++)
		{
			newarr[x]=arr[i];
			x++;
		}
		for(int i=0;i<tail;i++)
		{
			newarr[x]=arr[i];
			x++;
		}
		
		arr=newarr;
		head=0;
		tail=x;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		Queue q= new Queue();
		q.Enqueue(1);
		System.out.println("dequeue element is" +q.dequeue());
		q.Enqueue(2);
		q.Enqueue(3);
		q.Enqueue(4);
		q.Enqueue(5);
		q.Enqueue(6);
		//q.Enqueue();
		System.out.println("dequeue element is" +q.dequeue());
		q.Enqueue(7);
		q.Enqueue(8);
		System.out.println("dequeue element is" +q.dequeue());
		System.out.println("array length" + q.arr.length);
		
		for(int i=0;i<q.arr.length;i++)
		{
			System.out.println("array elements" + q.arr[i]);	
		}
		
		
		
	}

}
