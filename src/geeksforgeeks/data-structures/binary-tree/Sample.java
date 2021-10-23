public class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
        this.left = this.right = null;
    }
}

public class BinaryTree {
    Node root;

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(int value) {
        root = new Node(value);
    }

    public void add(int value) {
        if (root.left == null) {
            root.left.value = value;
        } else if (root.right == null) {
            root.right.value = value;
        }
    }
}

public class Sample {
    public static void main(String[] args) {
    }
}
