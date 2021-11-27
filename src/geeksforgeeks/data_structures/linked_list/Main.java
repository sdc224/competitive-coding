package geeksforgeeks.data_structures.linked_list;

/**
 * Main
 */
public class Main {
    private static LinkedList mergeAndReverse(LinkedList linkedList1, LinkedList linkedList2) {
        LinkedList mergedList = new LinkedList();

        if ((linkedList1 == null && linkedList2 == null) || (linkedList1.head == null && linkedList2.head == null))
            return null;

        while (linkedList1.head != null && linkedList2.head != null) {
            if (linkedList1.head.data <= linkedList2.head.data) {
                mergedList.insertBegin(linkedList1.head.data);
                linkedList1.head = linkedList1.head.next;
            } else {
                mergedList.insertBegin(linkedList2.head.data);
                linkedList2.head = linkedList2.head.next;
            }
        }

        while (linkedList1.head != null) {
            mergedList.insertBegin(linkedList1.head.data);
            linkedList1.head = linkedList1.head.next;
        }

        while (linkedList2.head != null) {
            mergedList.insertBegin(linkedList2.head.data);
            linkedList2.head = linkedList2.head.next;
        }

        return mergedList;
    }

    public static void main(String[] args) {
        LinkedList linkedList1 = new LinkedList(1);
        linkedList1.insertEnd(7);
        linkedList1.insertEnd(10);
        linkedList1.insertEnd(15);
        linkedList1.insertEnd(21);

        LinkedList linkedList2 = new LinkedList(2);
        linkedList2.insertEnd(6);
        linkedList2.insertEnd(9);
        linkedList2.insertEnd(13);
        linkedList2.insertEnd(14);
        linkedList2.insertEnd(17);

        LinkedList mergedList = mergeAndReverse(linkedList1, linkedList2);
        System.out.println(mergedList);
    }
}