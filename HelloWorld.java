package chinni;

public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("chinni is sooo cute :)");
		int a[] = new int[10];
		for(int i = 0; i < 10; i++)
		{
			a[i] = i*i;
		}
		a[4] = 200;
		a[1] = 201;
		a[8] = 1;
		
		int ans=0;
		int j=0;
		int x=0;
		int secans=0;
		int i=0;
		for(i=1;i<10;i=i+2)
		{
			System.out.println("i is" + i);
			System.out.println("value of i is" + a [i]);
			x=x+a[i];
			
		
		if(ans < a[i])
		{
			//secans=ans;
		ans=a[i];
		//secans=a[i--];
		j=i;
		}	
		if(secans <a[i] && a[i] <ans)
		{
			secans = a[i];
		}
		}
		System.out.println("answer is " + ans);
		System.out.println("secanswer is " + secans);
		System.out.println("index is " + j);
	     System.out.println("i is" + i);
	     System.out.println("value of x is" +x);
	     
	     
	     	
	}

}
