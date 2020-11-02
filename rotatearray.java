package chinni;

public class rotatearray {
	
	int nums[]= {1,2,3,4,5};
	
	public void rotate(int[] nums, int k) {
		int i=0;
		
		if(k==nums.length)
		{
			System.out.println("array is same");
		}
		else {
			k=k % nums.length;
			int start=0;
			int end=nums.length-1;
			
			
			
			while(start<=end)
			{
				if(start==end)
				{
					break;
				}
			int x=nums[start];
				nums[start]=nums[end];
				nums[end]=x;
				start++;
				end--;
				System.out.println("start and end values are" +start +"--" + end);
				
			}

			for( i=0;i<k/2;i++)
			{
			int	x=nums[i];
			nums[i]=nums[k-i-1];
			nums[k-i-1]=x;
			
			}

			int y=nums.length;
				for(i=k ;i<((nums.length+k)/2);i++)
				
				{
					
					int	x=nums[i];
					nums[i]=nums[y-1];
					nums[y-1]=x;	
					y--;
				}
		
			
		}

	}
		
				public static void main(String[] args) {
					// TODO Auto-generated method stub
				
					rotatearray r= new rotatearray();
					int nums[]= {1,2,3,4,5};
					r.rotate(nums,1);
					for(int i=0;i<nums.length;i++)
					{
						System.out.println("array elements" + nums[i]);	
					}
		
	
		}
}

