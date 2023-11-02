class Solution 
{
    public int maxDepth(TreeNode root) 
    {
        if (root == null)
        {
            return 0;
        }

        else
        {
            return (int )Math.max(1+maxDepth(root.left), 1+maxDepth(root.right));
        }
    }
}
