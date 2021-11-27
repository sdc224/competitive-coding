package geeksforgeeks.data_structures.binary_search_tree;

import java.util.Stack;

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

    private Node deleteHelper(Node rootRef, int data) {
        if (rootRef == null)
            return rootRef;

        if (data < rootRef.data)
            rootRef.left = deleteHelper(rootRef.left, data);
        else if (data > rootRef.data)
            rootRef.right = deleteHelper(rootRef.right, data);
        else {
            if (rootRef.left == null)
                return rootRef.right;
            else if (rootRef.right == null)
                return rootRef.left;

            rootRef.data = BinarySearchTreeUtils.minValue(rootRef.right);
            rootRef.right = deleteHelper(rootRef.right, rootRef.data);
        }

        return rootRef;
    }

    public void delete(int data) {
        deleteHelper(this.root, data);
    }

    private void inOrderHelper(Node rootRef, StringBuilder builder) {
        Node curr = rootRef;
        Stack<Node> stack = new Stack<>();

        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                Node temp = stack.pop();
                builder.append(temp.data + " ");
                curr = temp.right;
            }
        }
    }

    private void inOrderRecursiveHelper(Node rootRef, StringBuilder builder) {
        if (rootRef != null) {
            inOrderRecursiveHelper(rootRef.left, builder);
            builder.append(rootRef.data + " ");
            inOrderRecursiveHelper(rootRef.right, builder);
        }
    }

    private void preOrderHelper(Node rootRef, StringBuilder builder) {
        Stack<Node> stack = new Stack<>();
        Node curr = rootRef;

        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                builder.append(curr.data + " ");
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop().right;
            }
        }
    }

    private void preOrderRecursiveHelper(Node rootRef, StringBuilder builder) {
        if (rootRef != null) {
            builder.append(rootRef.data + " ");
            preOrderRecursiveHelper(rootRef.left, builder);
            preOrderRecursiveHelper(rootRef.right, builder);
        }
    }

    private void postOrderRecursiveHelper(Node rootRef, StringBuilder builder) {
        if (rootRef != null) {
            postOrderRecursiveHelper(rootRef.left, builder);
            postOrderRecursiveHelper(rootRef.right, builder);
            builder.append(rootRef.data + " ");
        }
    }

    private String traversal(String type) {
        StringBuilder builder = new StringBuilder();

        switch (type) {
            case "IN_ORDER":
                this.inOrderHelper(this.root, builder);
                break;

            case "IN_ORDER_REC":
                this.inOrderRecursiveHelper(this.root, builder);
                break;

            case "PRE_ORDER":
                this.preOrderHelper(this.root, builder);
                break;

            case "PRE_ORDER_REC":
                this.preOrderRecursiveHelper(this.root, builder);
                break;

            case "POST_ORDER":
            case "POST_ORDER_REC":
                this.postOrderRecursiveHelper(this.root, builder);

            default:
                break;
        }

        return builder.toString();
    }

    @Override
    public String toString() {
        return this.traversal("IN_ORDER");
    }

    public String toString(String type) {
        return this.traversal(type);
    }
}
