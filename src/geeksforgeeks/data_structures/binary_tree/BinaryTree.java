package geeksforgeeks.data_structures.binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    Node root;

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(int value) {
        root = new Node(value);
    }

    private void displayInOrder(Node node) {
        if (node == null) {
            return;
        }

        displayInOrder(node.left);
        System.out.print(node.value + " ");
        displayInOrder(node.right);
    }

    private void displayPreOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.value + " ");
        displayInOrder(node.left);
        displayInOrder(node.right);
    }

    private void displayPostOrder(Node node) {
        if (node == null) {
            return;
        }

        displayInOrder(node.left);
        displayInOrder(node.right);
        System.out.print(node.value + " ");
    }

    public void display() {
        display("IN_ORDER");
    }

    public void display(String type) {
        switch (type) {
        case "IN_ORDER":
            displayInOrder(this.root);
            break;

        case "PRE_ORDER":
            displayPreOrder(this.root);
            break;

        case "POST_ORDER":
            displayPostOrder(this.root);
            break;

        default:
            displayInOrder(this.root);
            break;
        }
    }

    public void add(int value) {
        Node node = new Node(value);

        if (this.root == null) {
            this.root = node;
            return;
        }

        Node temp = this.root;
        Queue<Node> queue = new LinkedList<>();

        queue.add(temp);

        while (!queue.isEmpty()) {
            temp = queue.poll();

            if (temp.left == null) {
                temp.left = node;
                break;
            } else
                queue.add(temp.left);

            if (temp.right == null) {
                temp.right = node;
                break;
            } else
                queue.add(temp.right);
        }
    }
}