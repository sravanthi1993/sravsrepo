package chinni;

import java.util.*;

public class Matrixelement0 {
static int [][] matrixelerowcol0(int [][]s1,int m,int n) {
		Set<Integer> s= new HashSet<Integer>();
		Set<Integer> s2= new HashSet<Integer>();
		if(m==0 && n==0)
		{
			System.out.println(0);;
		}
		
	
	for(int i=0;i<m;i++)
	{
		for(int j=0;j<n;j++)
		{
			if(s1[i][j]==0) {
				s.add(i);
				s2.add(j);
			}
		}
	}
	
	for(int x : s) {
		//System.out.println(s);
		//for(int y : s2) {
		for(int p1=0;p1<n;p1++) {
			s1[x][p1]=0;
	}
		for(int y : s2) {
			//System.out.println(s);
			//for(int y : s2) {
			for(int p1=0;p1<m;p1++) {
				s1[p1][y]=0;
		}
		}}
	return s1;
		
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int s1[][] = { { 1, 2, 3, 4 }, 
                { 5, 0, 7, 8 }, 
                { 9, 10, 5, 0 },
                { 8, 10, 4, 3 }};
		
		int [][]s2=matrixelerowcol0(s1,4,4);
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<4;j++)
			{
				System.out.print(s2[i][j] + " ");
			}
			System.out.println();
		}
	}

}
