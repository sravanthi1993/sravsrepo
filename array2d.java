package chinni;

public class array2d {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a[][] = { {1, 2, 3},
		{4, 5, 6}, 
                {7, 8, 9},
                {10, 11, 12}, 
                {13, 14, 15},
                {16, 17, 18},
                {19,20,21}};
		//int a[][] = { {1,2,3},{4,5,6} };
		int i=0;
		int k=0;
		int l=0;
		int m=a.length - 1;
		int n=-1;
		
		if(m >= 0)
		{
			n = a[0].length -1;
			System.out.print(m + "--" + n);}
		
		while (k <= m && l <= n) 
        { 
             
            for (i = l; i <= n; i++) 
            	
            { 
                System.out.print(a[k][i]+" "); 
            } 
            k++;
            
for (i = k; i <=m ; i++) 
            	
            { 
                System.out.print(a[i][n]+" "); 
            } 
            n--;
            
            if(k<=m)
            {
            	
for (i = n; i >= l; i--) 
            	
            { 
                System.out.print(a[m][i]+" "); 
            }
            
            m--;
            }
            
            if(l<=n)
            {
for (i = m; i >= k; i--) 
            	
            { 
                System.out.print(a[i][l]+" "); 
            } 
            l++;
            }
        
        }
		//System.out.println();
		
		
		//IList<int> L= new IList<int>();
	}

}
