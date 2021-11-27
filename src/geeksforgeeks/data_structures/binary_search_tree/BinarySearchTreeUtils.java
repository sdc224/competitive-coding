package geeksforgeeks.data_structures.binary_search_tree;

public class BinarySearchTreeUtils {
    public static int minValue(Node root) {
        int min = root.data;
        Node curr = root;

        while (curr.left != null) {
            min = curr.left.data;
            curr = curr.left;
        }

        return min;
    }

    public static int maxValue(Node root) {
        int max = root.data;
        Node curr = root;

        while (curr.right != null) {
            max = curr.right.data;
            curr = curr.right;
        }

        return max;
    }
}
