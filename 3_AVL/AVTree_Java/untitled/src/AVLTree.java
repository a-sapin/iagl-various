public class AVLTree {

    private class Node {
        int value;
        Node left;
        Node right;
        int height;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
            this.height = 1;
        }
    }

    private Node root;

    public int height(Node N) {
        if (N == null)
            return 0;
        return N.height;
    }

    public int sMax(int a, int b) {
        return (a > b) ? a : b;
    }

    public Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = sMax(height(y.left), height(y.right)) + 1;
        x.height = sMax(height(x.left), height(x.right)) + 1;

        return x;
    }

    public Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = sMax(height(x.left), height(x.right)) + 1;
        y.height = sMax(height(y.left), height(y.right)) + 1;

        return y;
    }

    public Node doubleRightRotate(Node z) {
        z.left = leftRotate(z.left);
        return rightRotate(z);
    }

    public Node doubleLeftRotate(Node z) {
        z.right = rightRotate(z.right);
        return leftRotate(z);
    }

    public Node balanceTree(Node root, int value) {
        int balance = height(root.left) - height(root.right);

        if (balance > 1 && value < root.left.value)
            return rightRotate(root);

        if (balance < -1 && value > root.right.value)
            return leftRotate(root);

        if (balance > 1 && value > root.left.value) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        if (balance < -1 && value < root.right.value) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    public Node insert(Node root, int value) {
        if (root == null)
            return new Node(value);

        if (value < root.value)
            root.left = insert(root.left, value);
        else if (value > root.value)
            root.right = insert(root.right, value);
        else
            return root;

        root.height = 1 + sMax(height(root.left), height(root.right));
        return balanceTree(root, value);
    }

    public Node findSuccessor(Node root) {
        Node current = root;
        while (current.left != null)
            current = current.left;
        return current;
    }

    public Node delete(Node root, int value) {
        if (root == null)
            return root;

        if (value < root.value)
            root.left = delete(root.left, value);
        else if (value > root.value)
            root.right = delete(root.right, value);
        else {
            if (root.left == null || root.right == null) {
                Node temp = root.left != null ? root.left : root.right;

                if (temp == null) {
                    temp = root;
                    root = null;
                } else {
                    root = temp;
                }
            } else {
                Node temp = findSuccessor(root.right);
                root.value = temp.value;
                root.right = delete(root.right, temp.value);
            }
        }

        if (root == null)
            return root;

        root.height = 1 + sMax(height(root.left), height(root.right));
        return balanceTree(root, value);
    }

    public void printTree(Node root, int space) {
        if (root == null)
            return;

        space += 10;
        printTree(root.right, space);

        System.out.println();
        for (int i = 10; i < space; i++)
            System.out.print(" ");
        System.out.println(root.value);

        printTree(root.left, space);
    }

    public void insert(int value) {
        root = insert(root, value);
    }

    public void delete(int value) {
        root = delete(root, value);
    }

    public void printTree() {
        printTree(root, 0);
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
        tree.insert(25);

        tree.printTree();
    }
}