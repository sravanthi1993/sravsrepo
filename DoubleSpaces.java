package chinni;

public class DoubleSpaces {

	static void DoubleSpace(char c[])
	{
		int count=0;
		int n=0;
		for(int i=0;i<c.length;i++)
		{
			if(c[i] != '#')
			{
				n=n+1;
				System.out.println(n);
			}
		}
		for(int i=0;i<n;i++)
		{
			if(c[i] == ' ')
			{
				count=count+1;
			}
		}
		for(int i=n-1;i>=0;i--)
		{
			if(c[i]!=' ')
			{
				c[i+count]=c[i];
			}
			else if (c[i]==' ')
			{
				c[i+count]=c[i];
				c[i+count-1]=' ';
				count--;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       char input1[] = {'a','b',' ','c','d','e',' ','f',' ','g','#','#','#'};
       /* char input2[] = {};
        char input3[] = {'a','b','c','d'};
        char input4[] = {' ','#'};*/
        
        DoubleSpace(input1);
        for(char c: input1)
        {
        	System.out.print(c + ",");
        }
	}

}

