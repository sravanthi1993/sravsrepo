package chinni;

public class recursion {

	static int factorial(int n)
	{
		if(n <= 0)
			return 0;
		
		if(n == 1)
			return 1;
		
		return n * factorial(n-1);
	}
	
	static int factorialusingLoop(int n)
	{
		int i=1;
		int f=1;
		if (n<=0)
			return 0;
		
		while (i<=n)
		{


			f=f*i;
				
		i++;
		//System.out.println(factorialusingLoop(5));
		}
		return f;
		
	}
	
	static int power(int a, int n)
	{
		if (n==1)
			
			return a;
		
		return a * power(a,n-1);
	}
	
	static int powerUsingLoop(int a, int n)
	{
		int i=1;
		int p=1;
		if (n==0)
			return 1;
		
		while (i<=n)
		{


			p=p*a;
				
		i++;
		//System.out.println(powerusingLoop(5,4));
		}
		return p;

	}
	
	static int fibonacii(int n)
	{
		if(n==0)
			return 0;
					
		if (n==1)
			return 1;
			
		return fibonacii(n-1) + fibonacii(n-2); 
	}
	
	static void decorder(int n)
	{
		System.out.println(n);
		if(n <= 0)
			return;
			
		decorder(n-1);
		//return n;
		
		//break;
		//return  decorder(n-1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(factorial(6));

		System.out.println(factorialusingLoop(5));
		System.out.println(power(10,4));
		System.out.println(powerUsingLoop(5,4));
		
		System.out.println(fibonacii(10));
		
		decorder(10);
	}

}
