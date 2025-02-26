
class AVLNode {
    public int key;
    public AVLNode left;
    public AVLNode right;

    public AVLNode(int item) {
        key = item;
        left = null;
        right = null;
    }

    public int getHeight() {
        int l = (left != null) ? left.getHeight() : 0;
        int r = (right != null) ? right.getHeight() : 0;
        return Math.max(l, r) + 1;
    }

    public int getBalance() {
        int l = (left != null) ? left.getHeight() : 1;
        int r = (right != null) ? right.getHeight() : 1;
        return l - r;
    }
}
