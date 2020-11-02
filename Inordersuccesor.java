package chinni;

import chinni.BSTtogreatestsumtree.TreeNode;

public class Inordersuccesor {
	
	public static class TreeNode {
	     int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode parent;
	      TreeNode(int x) { val = x; }
	  }

	
    static int succesor(TreeNode root,TreeNode r) {
        TreeNode x;
        TreeNode y;
        int result=-1;
        if(root==null){return -1;}
         int left = succesor(root.left, r);
         
         if(left > -1)
        	 return left;
         
         x=root;

         if(x==r) {
        	 y=x.right;
        	 if(y!=null) {
        		 while(y.left!=null) {
        			 y=y.left;
        		 }
        		 return result = y.val;
        	 }
        	 while(r.parent != null && r!=r.parent.left) {
        		 r=r.parent;
        	 }
        	 if(r.parent == null) return -1;
        	 return result=r.parent.val;
        	 
         }
         
         return succesor(root.right, r);
         
         
    }
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        TreeNode root = new TreeNode(1);
        TreeNode r2 = new TreeNode(2);
        root.left = r2;
        r2.parent = root;
        TreeNode r3 = new TreeNode(3);
        root.right= r3;
        r3.parent = root;
        TreeNode r4 = new TreeNode(4);
        TreeNode r5 = new TreeNode(5);
        r2.left = r4;
        r4.parent = r2;
        r2.right = r5;
        r5.parent = r2;
        TreeNode r6 = new TreeNode(6);
        TreeNode r7 = new TreeNode(7);
        
        r4.left = r6;
        r6.parent = r4;
        r4.right = r7;
        r7.parent = r4;
        
        TreeNode r8 = new TreeNode(8);
        TreeNode r9 = new TreeNode(9);
        
        r5.left = r8;
        r8.parent = r5;
        r5.right = r9;
        r9.parent = r5;
        
        TreeNode r10 = new TreeNode(10);
        TreeNode r11 = new TreeNode(11);
        
        r7.left = r10;
        r10.parent = r7;
        r7.right = r11;
        r11.parent = r7;
        
        TreeNode r12 = new TreeNode(12);

        r8.right = r12;
        r12.parent = r8;
        
        
        TreeNode r13 = new TreeNode(13);
        TreeNode r14 = new TreeNode(14);
        
        r3.left = r13;
        r13.parent = r3;
        r3.right = r14;
        r14.parent = r3;
        
        TreeNode r15 = new TreeNode(15);
        TreeNode r16 = new TreeNode(16);
       
        r14.left = r15;
        r15.parent = r14;
        r14.right = r16;
        r16.parent = r14;
        
        TreeNode r17 = new TreeNode(17);
        r13.right = r17;
        r17.parent = r13;
        
        TreeNode r19 = new TreeNode(19);
        r17.left = r19;
        r19.parent = r17;
		
        TreeNode r18 = new TreeNode(18);
        r6.left = r18;
        r18.parent = r6;
        
        System.out.println("Successor of 19 is" +  succesor(root, r19));
        System.out.println("Successor of 11 is" +  succesor(root, r11));
        System.out.println("Successor of 6 is" +  succesor(root, r6));
        System.out.println("Successor of 12 is" +  succesor(root, r12));
        System.out.println("Successor of 16 is" +  succesor(root, r16));
	}

}
