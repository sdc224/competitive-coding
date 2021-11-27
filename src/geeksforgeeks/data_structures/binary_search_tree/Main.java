package geeksforgeeks.data_structures.binary_search_tree;

public class Main {

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree(10);
        binarySearchTree.insert(5);
        binarySearchTree.insert(11);
        binarySearchTree.insert(8);
        binarySearchTree.insert(3);
        binarySearchTree.insert(16);
        binarySearchTree.insert(9);
        binarySearchTree.insert(25);

        System.out.println(binarySearchTree);
        System.out.println(binarySearchTree.toString("POST_ORDER"));
    }
}
