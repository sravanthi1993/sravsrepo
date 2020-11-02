package chinni;

public class FlippinganImage {

	static int[][] flipAndInvertImage(int[][] a) {
		int m=a.length;
		int n=a[0].length;
		int[][] b=new int[m][n];
		for(int i=0;i<m;i++) {
			int x=0;
			for(int j=n-1;j>=0;j--) {
				b[i][x]=a[i][j];
				x++;
				System.out.print(a[i][j]);
			}
		}
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(b[i][j]==0) {
					b[i][j]=1;
				}
				else b[i][j]=0;
			}
		}
		
		
		return b;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[][]= {{1,1,0},{1,0,1},{0,0,0}};
		
		int[][] b=flipAndInvertImage(a);
		System.out.print(b);
		

	}

}
