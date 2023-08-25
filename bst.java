class Node {
    int val;
    Node left, right;

    public Node(int item) {
        val = item;
        left = right = null;
    }
}

class BST {
    Node root;

    BST() {
        root = null;
    }

    void insert(int val) {
        root = insertRec(root, val);
    }

    Node insertRec(Node node, int val) {
        if (node == null) {
            node = new Node(val);
            return node;
        }

        if (val < node.val)
            node.left = insertRec(node.left, val);
        else if (val > node.val)
            node.right = insertRec(node.right, val);

        return node;
    }

    void delete(int val) {
        root = deleteRec(root, val);
    }

    Node deleteRec(Node node, int val) {
        if (node == null)
            return node;

        if (val < node.val)
            node.left = deleteRec(node.left, val);
        else if (val > node.val)
            node.right = deleteRec(node.right, val);
        else {
            if (node.left == null)
                return node.right;
            else if (node.right == null)
                return node.left;

            node.val = minValue(node.right);

            node.right = deleteRec(node.right, node.val);
        }

        return node;
    }

    int minValue(Node node) {
        int minVal = node.val;
        while (node.left != null) {
            minVal = node.left.val;
            node = node.left;
        }
        return minVal;
    }

    boolean search(int val) {
        return searchRec(root, val);
    }

    boolean searchRec(Node node, int val) {
        if (node == null || node.val == val)
            return node != null;

        if (val < node.val)
            return searchRec(node.left, val);
        else
            return searchRec(node.right, val);
    }

    void inorderTraversal() {
        inorderRec(root);
    }

    void inorderRec(Node node) {
        if (node != null) {
            inorderRec(node.left);
            System.out.print(node.val + " ");
            inorderRec(node.right);
        }
    }
}

public class BSTtree {
    public static void main(String[] args) {
        BST bst = new BST();

        // Insertion
        bst.insert(1);
        bst.insert(2);
        bst.insert(3);
        bst.insert(4);
        bst.insert(5);
        bst.insert(6);
        bst.insert(7);

        // Inorder traversal
        System.out.println("Inorder traversal:");
        bst.inorderTraversal();
        System.out.println();

        // Search
        int val = 2;
        System.out.println("Is " + val + " present in the BST? " + bst.search(val));

        // Deletion
        val = 3;
        System.out.println("Deleting " + val + " from the BST.");
        bst.delete(val);

        // Inorder traversal after deletion
        System.out.println("Inorder traversal after deletion:");
        bst.inorderTraversal();
    }
}

