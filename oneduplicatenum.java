package chinni;

public class oneduplicatenum {
	public static void main(String args[]) {
		//int a[]= {4,1,3,1,2};
		//int a[]= {4,3,3,1,2};
		int a[]={1,1};
		int carryover=0;
		//int n=5;
		int n=2;
		for (int i=0;i<n-1;i++)
		{
			carryover=(carryover+a[i])-(i+1);
			System.out.println("'carryover is" + carryover);
		}
		carryover = carryover+ a[n-1];
		System.out.println("duplicate number in an array is"+ carryover);
	}

}
