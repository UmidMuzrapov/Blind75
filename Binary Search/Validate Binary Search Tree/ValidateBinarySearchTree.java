/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
           ArrayList<Integer> elements = new ArrayList<Integer>();
           traverse(root, elements);
           return isSorted(elements);

    }

    public void traverse(TreeNode root, ArrayList<Integer> elements){
        if (root==null){
            return;
        }

        traverse(root.left, elements);
        elements.add(root.val);
        traverse(root.right, elements);
    }

    public boolean isSorted(ArrayList<Integer> elements){

        long previous = Long.MIN_VALUE;
        for (int element: elements){
            if (previous>=element){
                return false;
            }

            previous= element;
        }

        return true;
    }

}
