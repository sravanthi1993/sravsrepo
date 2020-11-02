package chinni;

public class Sortarraybyparity {
	
	static int[] sortbyparity(int[] a) {
		int l=a.length;
		int m=0;
		int[] b=new int[a.length];
		for(int i=0;i<a.length;i++) {
			if(a[i]%2==0) {
				b[m]=a[i];
				m++;
			}
			else {
				b[l-1]=a[i];
				l--;
			}
			
		}
		return b;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= {3,2,1,4};
		int b[]=sortbyparity(a);
		System.out.println(b);

	}

}
