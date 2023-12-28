class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder.length == 0){
            return null;
        }
        
        if (preorder.length == 1){
            return new TreeNode(preorder[0]);
        }

        TreeNode root = new TreeNode(preorder[0]);
        List<int[]> inorders = breakInorder(inorder, preorder[0]);
        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, 1+ inorders.get(0).length);
        int[] rightPreorder = Arrays.copyOfRange(preorder, 1 + inorders.get(0).length, inorder.length);
        root.left = buildTree(leftPreorder, inorders.get(0));
        root.right = buildTree(rightPreorder, inorders.get(1));

        return root;
    }

    private List<int[]> breakInorder(int[] inorder, int pivot){
        LinkedList<Integer> left = new LinkedList<Integer> ();
        LinkedList<Integer> right = new LinkedList<Integer> ();

        LinkedList<Integer> cur = left;

        for (int elem: inorder){
            if (elem == pivot){
                cur = right;
                continue;
            }

            cur.add(elem);
        }

        return List.of(
            left.stream().mapToInt(Integer::intValue).toArray(),
            right.stream().mapToInt(Integer::intValue).toArray()
        );
    }
}
