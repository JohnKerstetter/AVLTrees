
public class AVLTree {
    
    public static AVLNode insert(AVLNode node, int item) {

        if (node == null) return new AVLNode(item);

        if (item < node.key)
            node.left = insert(node.left, item);
        else if (item > node.key)
            node.right = insert(node.right, item);
        else
            return node; // Duplicate keys are not allowed in BST

        // Get the balance factor
        int balance = node.getBalance();

        // If the node is unbalanced, then there are 4 cases

        // left...
        if (balance > 1) {

            // ...left
            if (item < node.left.key) {
                return rotateRight(node);
            }

            // ...right
            if (item > node.left.key) {
                node.left = rotateLeft(node);
                rotateRight(node);
            }
        }

        // right...
        if (balance < -1) {

            // ...right
            if (item > node.right.key) {
                return rotateLeft(node);
            }

            // ...left
            if (item < node.right.key) {
                node.right = rotateRight(node.right);
                return rotateLeft(node);
            }
        }

        return node;
    }

    public static AVLNode rotateLeft(AVLNode node) {
        System.out.println("rotate left");

        AVLNode newRoot = node.right;
        AVLNode temp = newRoot.left;

        newRoot.left = node;
        node.right = temp;

        return newRoot;
    }

    public static AVLNode rotateRight(AVLNode node) {
        System.out.println("rotate right");

        AVLNode newRoot = node.left;
        AVLNode temp = newRoot.right;

        newRoot.right = node;
        node.left = temp;

        return newRoot;
    }

    public static void traversePreOrder(AVLNode node) {
        if (node != null) {
            System.out.print(node.key + " ");
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    public static void traverseInOrder(AVLNode node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(node.key + " ");
            traverseInOrder(node.right);
        }
    }

    public static void traversePostOrder(AVLNode node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            System.out.print(node.key + " ");
        }
    }
}
