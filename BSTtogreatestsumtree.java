package chinni;

public class BSTtogreatestsumtree {
	
	public class TreeNode {
		     int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }

	 public int bstToGst(TreeNode root) {
	        
	        if(root==null) return 0;
	        
	        int right=bstToGst(root.right);
	        root.val+=right;
	        int left=bstToGst(root.left);
	        root.val+=left;
	        
	        return root.val;
	    }
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//TreeNode root= new TreeNode(4);
		//,1,6,0,2,5,7,null,null,null,3,null,null,null,8);
		//int x=bstToGst(4);

	}

}
