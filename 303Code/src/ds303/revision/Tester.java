package ds303.revision;

public class Tester {

    public static void main(String[] args) {
        /**
         * Singly Linked list
         */
        SinglyLinkedList list = new SinglyLinkedList();
        SinglyLinkedList list2 = new SinglyLinkedList();
        for (int i = 6; i >= 1; i--) {
            list.addFirst(i);
            System.out.println(list.toString());
        }

        for (int i = 5; i >= 1; i--) {
            list2.addLast(i);
            System.out.println(list2.toString());
        }

        // test get middle
        System.out.println(list.toString());
        System.out.println("get middle: " + list.getMiddle());

        // testing remove duplicates
        list.addFirst(2);
        list.addFirst(2);
        list.addFirst(2);
        list.addFirst(5);
        System.out.println("Before sorting :" + list.toString());
        list.sort();
        System.out.println("Before remove dub :" + list.toString());
        list.removeDup();
        System.out.println("After remove dub :" + list.toString());

        // test arrange odd even
        System.out.println();
        list.addLast(9);
        list.addLast(6);
        System.out.println("Before Rearrange Odd Even: " + list.toString());
        list.arrangeOddEven(list);
        System.out.println("After Rearrange Odd Even: " + list.toString());


        /**
         * Doubly Linked list
         */
        DoublyLinkedList dlist = new DoublyLinkedList();
        for (int i = 9; i >= 1; i--) {
            dlist.addFirst(i);
//            System.out.println(list.toString());
        }

        System.out.println("\ndeleting odd nodes from double list...");
        System.out.println(dlist.toString());
        dlist.deleteoddNodes();
        System.out.println(dlist.toString());
    }
}
