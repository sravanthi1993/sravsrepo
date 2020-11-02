package chinni;

public class monotonicusingfun {
	public boolean isMonotonic(int[] a) {
		if(a.length==1)
		{
			System.out.println("there is only one element in the array");
		}
		return increasing(a) || decreasing(a);
	}
	
		
		 public boolean increasing (int[] a) {
			 for(int i=0;i<a.length-1;i++)
				{
					if (a[i]>a[i+1])
						return false;
					System.out.println("given array is a monotonic array" +i);
				}
						return true;
				
		 }
			 public boolean decreasing (int[] a) {
				 for(int i=0;i<a.length-1;i++)
					{
						if (a[i]<a[i+1])
							return false;
						System.out.println("given array is a monotonic array" +i);
					}
							return true;
					
					
		 }
			 
				public static void main(String[] args) {
					// TODO Auto-generated method stub
					monotonicusingfun m=new monotonicusingfun();
					int a[]= {1,2,3,4,5};
				boolean b=m.isMonotonic(a);
				System.out.println("result is" +b);
				
			 
	}
}
	


