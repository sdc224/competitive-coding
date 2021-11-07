package geeksforgeeks.data_structures.binary_tree;

public class Sample {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(5);
        tree.add(6);
        tree.add(8);
        tree.add(11);
        tree.add(1);
        tree.add(9);

        tree.display();
    }
}
