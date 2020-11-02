package chinni;

public class binarysrch {
	public static void main(String args[]) {
		int array[] = { 2,8,15,20,25,40,55,60,70,90};
		
		int start=0;
		int end=9;
		int middle = (start+end)/2;
	    int num=24;
	    
	    int i = 0;
	    while(i>=0)
	    {
	    	System.out.print(i);
	    	if(i>50)
	    	{
	    		break;
	    	}
	    	if(i==55)
	    		
	    	{
	    		
	    		
	    	}
	    	i++;
	    }
	    
	    System.out.println("Broken");
		while (start < end-1)
			
		
			
		{
			/*if(start == end -1)
			{
				
				break;
			}
			if(start == end)
			{
				break;
			}*/
			
			System.out.println(start + "--" + end);
			middle=(start+end)/2;
			if (array[middle]<num)
			{
				start=middle;
			}
			else if (array[middle]>num)
			{
				end=middle;
			}
			else
			{
			
			break;
			}
		}
		if (num == array[middle] || num == array[start] || num == array[end])
			
		{

			System.out.println("I found the number!!");
			/*System.out.println("start value is" + start);
			System.out.println("end value is" + end);
			System.out.println("number not found");*/
		
		}
		else
			System.out.println("number not found");
	}
}
