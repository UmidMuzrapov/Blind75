class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int smaller = (int) Math.min(p.val, q.val);
        int larger = (int) Math.max(p.val, q.val);

        if (root.val == smaller || root.val == larger || (root.val > smaller && root.val <larger)){
            return root;
        }

        else{
            if (root.left!=null && root.val>smaller && root.val>larger){
                return lowestCommonAncestor(root.left, p, q);
            }

            else{
                 return lowestCommonAncestor(root.right, p, q);
            }
        }
    }
}
