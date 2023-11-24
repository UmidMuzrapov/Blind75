class Solution 
{
    public List<List<Integer>> levelOrder(TreeNode root) 
    {
        // base
        if (root == null)
        {
            return new ArrayList<List<Integer>>();
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        queue.add(root);
        // use a delim as a seperator between levels
        queue.add(getDelim());
        int innerList = 0;

        while (!queue.isEmpty())
        {
            TreeNode cur = queue.remove();
            // process all nodes at the same elevel
            while (cur.val!=Integer.MIN_VALUE)
            {
                // create inner list if needed.
                if (result.size()==innerList)
                {
                    result.add(new LinkedList<Integer>());
                }

                result.get(innerList).add(cur.val);
                
                if (cur.left !=null)
                {
                    queue.add(cur.left);
                }

                if (cur.right!=null)
                {
                    queue.add(cur.right);
                }

                cur = queue.remove();
            }

            if (!queue.isEmpty())
            {
                queue.add(getDelim());
            }

            else
            {
                return result;
            }
            
            innerList++;
        }

        return result;

    }

    private TreeNode getDelim()
    {
        TreeNode node = new TreeNode();
        node.val = Integer.MIN_VALUE;

        return node;
    }
}
