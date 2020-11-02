package chinni;

public class rotationalarr {
	public static void main(String args[]) {
		int a[]= {60,90,120,150,160,1,5,10,20,50,55};
		//int n=50;
		int n=20;
		int start=0;
		int end=10;
		int mid=(start+end)/2;
		
		int ans = -1;
		boolean numberFound = false;
		while(start<=end)
		{
			mid=(start+end)/2;
		
			System.out.println(start + "--" + end);
		if(a[mid]==n)
		{
			System.out.println("found the number at index" + mid + a[mid]);
			ans = mid;
			numberFound = true;
			break;
		}
		if(a[start]==n)
		{
			System.out.println("found the number at index" + start + a[start]);
			ans = start;
			numberFound = true;
			break;
		}
		if (a[end]==n)
		{
			System.out.println("found the number at index" + end + a[end]);
			ans = end;
			numberFound = true;
			break;
		}
		if(start + 1 == end)
		{
			break;
		}
		
		if(a[start]<=a[mid])
		{
			if(a[start]<=n && n<=a[mid])
			{
				//System.out.println("found the number at index" + a[end]);
				end=mid;
				//System.out.println("found the number at index" + a[end]);
				continue;
			}
			// System.out.println("not found");
		}
		if(a[mid]<=a[end])
		{
			if(a[mid]<=n && n<=a[end])
			{
				//System.out.println("found the number at index" + start);
				start=mid;
				//System.out.println("found the number at index" + start);
				//break;
				continue;
			}
			//System.out.println("not found");
			//break;
		}
		if(a[start]> a[mid])
		{
			if(n<=a[mid] || n>=a[start])
			{
				end=mid;
				continue;
			}
		}
		if(a[end]< a[mid])
		{
			if(n<=a[end] || n>=a[mid])
			{
				start=mid;
				continue;
			}
		}
		/*if(a[end]>n && n< a[start])
		{
			System.out.println("found the number");
			//break;
		}*/
		System.out.println("not found the number");
		break;
		//break;
		//System.out.println("found the number at index");
		}
	
		if(numberFound)
		{
			System.out.println( ans + " kaada dorkindi ra bhai");
		}
		else
		{
			System.out.println("Dorkale");
		}
	}

}
