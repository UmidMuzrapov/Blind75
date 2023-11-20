class Solution 
{
    public int kthSmallest(TreeNode root, int k) 
    {
        int[] intArray = {k, -1};
        recursiveSolve(root, intArray);
        return intArray[1];
    }

    private void recursiveSolve(TreeNode root, int[] intArray)
    {
        if (root == null)
        {
            return;
        }

        recursiveSolve(root.left, intArray);
        intArray[0]-=1;
        if (intArray[0]==0 && intArray[1]==-1)
        {
            intArray[1]=root.val;
            return;
        }
        recursiveSolve(root.right, intArray);
    }
}
