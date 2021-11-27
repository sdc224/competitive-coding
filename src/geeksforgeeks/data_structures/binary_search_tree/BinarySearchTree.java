package geeksforgeeks.data_structures.binary_search_tree;

public class BinarySearchTree {
    Node root;

    public BinarySearchTree() {
    }

    private void init(int data) {
        root = new Node(data);
    }

    public BinarySearchTree(int data) {
        this.init(data);
    }

    private Node insertHelper(Node rootRef, int data) {
        if (rootRef == null) {
            rootRef = new Node(data);
            return rootRef;
        }

        if (data < rootRef.data)
            rootRef.left = insertHelper(rootRef.left, data);
        else
            rootRef.right = insertHelper(rootRef.right, data);

        return rootRef;
    }

    public void insert(int data) {
        if (root == null)
            init(data);
        else
            this.root = this.insertHelper(this.root, data);

    }

    private void deleteHelper(Node rootRef, int data) {
        if (rootRef == null)
            return;

        if (rootRef.data == data) {
            rootRef = null;
            return;
        }

        if (data < rootRef.data)
            deleteHelper(rootRef.left, data);

        deleteHelper(rootRef.right, data);
    }

    public void delete(int data) {
        deleteHelper(this.root, data);
    }

    private void inOrderHelper(Node rootRef, StringBuilder builder) {
        if (rootRef != null) {
            inOrderHelper(rootRef.left, builder);
            builder.append(rootRef.data + " ");
            inOrderHelper(rootRef.right, builder);
        }
    }

    private String inOrder() {
        StringBuilder builder = new StringBuilder();
        inOrderHelper(this.root, builder);

        return builder.toString();
    }

    @Override
    public String toString() {
        return this.inOrder();
    }
}
