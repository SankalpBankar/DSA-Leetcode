class Solution {
    int preIndex = 0;
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // store inorder indices
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return construct(preorder, 0, inorder.length - 1);
    }

    private TreeNode construct(int[] preorder, int inStart, int inEnd) {
        if (inStart > inEnd) return null;

        // root from preorder
        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);

        // split inorder
        int inIndex = map.get(rootVal);

        // build left subtree
        root.left = construct(preorder, inStart, inIndex - 1);

        // build right subtree
        root.right = construct(preorder, inIndex + 1, inEnd);

        return root;
    }
}