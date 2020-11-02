package chinni;

public class MaxPath {


static int maxPath = Integer.MIN_VALUE;

private static int getmaxpath(int[][] matrix){

int row = matrix.length;
if(row == 0)
	return 0;
  
  boolean [][]visited = new boolean[row][matrix[0].length];
  Integer [][]maxPaths = new Integer[row][matrix[0].length];
  
  for(int i = 0; i < row; i++)
  {
    for( int j = 0; j < matrix[0].length; j++)
    {
       maxPaths[i][j] = null;
    }
  }
  
  getMaxPathRecursive(matrix, 0, 0, visited, 0);
  
  return maxPath;
}


private static void getMaxPathRecursive(int [][]matrix, int row, int col, boolean [][]visited, int pathSum) //, Integer [][]maxPaths)
{ 
     if(row == matrix.length - 1 && col == matrix.length - 1)
     {
     	 pathSum += matrix[row][col];
         if(pathSum > maxPath)
         {
            maxPath = pathSum;
         }
         
         return;
     }
     
     if(row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length || visited[row][col])
     {
     		return;
     }
     
     visited[row][col] = true;
     pathSum += matrix[row][col];
     
     getMaxPathRecursive(matrix, row+1, col, visited, pathSum);
     getMaxPathRecursive(matrix, row-1, col, visited, pathSum);
     getMaxPathRecursive(matrix, row, col+1, visited, pathSum);
     getMaxPathRecursive(matrix, row, col-1, visited, pathSum);
     
    // pathsum -= matrix[row][col];
     visited[row][col] = false; 
     
}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[][] = { {5,8,-2},
				{2, 4, -1}, 
		                {-1, -3, -2}};
		
		System.out.println(getmaxpath(a));
	}

}
