package chinni;

public class missinginteger {
	public static void main(String[] args) {
		//int array[]= {1,3,5,4};
		int array[]= {1,4,5,2};
		
		int carry=0;
		int i=0;
		int n=5;
		while(i<n-1)
		{
			carry=(carry+i+1)-array[i];
			i++;
					
		}
			carry=carry+i+1;
		
			
			System.out.println("missing integer in an array is" + carry);
		
	}
	
}
