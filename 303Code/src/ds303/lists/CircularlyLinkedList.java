package ds303.lists;

public class CircularlyLinkedList<E> {
    //---------------- nested Node class ----------------

    /**
     * Singly linked node, which stores a reference to its element and
     * to the subsequent node in the list.
     */
    private static class Node<E> {

        /**
         * The element stored at this node
         */
        private E element;     // an element stored at this node

        /**
         * A reference to the subsequent node in the list
         */
        private Node<E> next;  // a reference to the subsequent node in the list

        /**
         * Creates a node with the given element and next node.
         *
         * @param e the element to be stored
         * @param n reference to a node that should follow the new node
         */
        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        // Accessor methods

        /**
         * Returns the element stored at the node.
         *
         * @return the element stored at the node
         */
        public E getElement() {
            return element;
        }

        /**
         * Returns the node that follows this one (or null if no such node).
         *
         * @return the following node
         */
        public Node<E> getNext() {
            return next;
        }

        // Modifier methods

        /**
         * Sets the node's next reference to point to Node n.
         *
         * @param n the node that should follow this one
         */
        public void setNext(Node<E> n) {
            next = n;
        }
    } //----------- end of nested Node class -----------

    // instance variables of the CircularlyLinkedList
    /**
     * The designated cursor of the list
     */
    private Node<E> tail = null;                  // we store tail (but not head)

    /**
     * Number of nodes in the list
     */
    private int size = 0;                         // number of nodes in the list

    /**
     * Constructs an initially empty list.
     */
    public CircularlyLinkedList() {
    }             // constructs an initially empty list

    // access methods

    /**
     * Returns the number of elements in the linked list.
     *
     * @return number of elements in the linked list
     */
    public int size() {
        return size;
    }

    /**
     * Tests whether the linked list is empty.
     *
     * @return true if the linked list is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns (but does not remove) the first element of the list
     *
     * @return element at the front of the list (or null if empty)
     */
    public E first() {             // returns (but does not remove) the first element
        if (isEmpty()) return null;
        return tail.getNext().getElement();         // the head is *after* the tail
    }

    /**
     * Returns (but does not remove) the last element of the list
     *
     * @return element at the back of the list (or null if empty)
     */
    public E last() {              // returns (but does not remove) the last element
        if (isEmpty()) return null;
        return tail.getElement();
    }

    // update methods

    /**
     * Rotate the first element to the back of the list.
     */
    public void rotate() {         // rotate the first element to the back of the list
        if (tail != null)                // if empty, do nothing
            tail = tail.getNext();         // the old head becomes the new tail
    }

    /**
     * Adds an element to the front of the list.
     *
     * @param e the new element to add
     */
    public void addFirst(E e) {                // adds element e to the front of the list
        if (size == 0) {
            tail = new Node<>(e, null);
            tail.setNext(tail);                     // link to itself circularly
        } else {
            Node<E> newest = new Node<>(e, tail.getNext());
            tail.setNext(newest);
        }
        size++;
    }

    /**
     * Adds an element to the end of the list.
     *
     * @param e the new element to add
     */
    public void addLast(E e) {                 // adds element e to the end of the list
        addFirst(e);             // insert new element at front of list
        tail = tail.getNext();   // now new element becomes the tail
    }

    /**
     * Removes and returns the first element of the list.
     *
     * @return the removed element (or null if empty)
     */
    public E removeFirst() {                   // removes and returns the first element
        if (isEmpty()) return null;              // nothing to remove
        Node<E> head = tail.getNext();
        if (head == tail) tail = null;           // must be the only node left
        else tail.setNext(head.getNext());       // removes "head" from the list
        size--;
        return head.getElement();
    }

    /**
     * Produces a string representation of the contents of the list.
     * This exists for debugging purposes only.
     */
    public String toString() {
        if (tail == null) return "()";
        StringBuilder sb = new StringBuilder("(");
        Node<E> walk = tail;
        do {
            walk = walk.getNext();
            sb.append(walk.getElement());
            if (walk != tail)
                sb.append(", ");
        } while (walk != tail);
        sb.append(")");
        return sb.toString();
    }

    /* Give an implementation of the size( ) method for the CircularlyLinkedList class,
    assuming that we did not maintain size as an instance variable.*/
    // middle method
    public int size2() {
        if (tail == null) return 0;
        Node<E> walk = tail.next;//head
        int count = 1;
        while (walk != tail) {
            count++;
            walk = walk.getNext();
        }
        return count;
    }

    //demo
    public static void main(String[] args) {
        CircularlyLinkedList list = new CircularlyLinkedList();
        for (int i = 5; i >= 1; i--) {
            list.addFirst(i);
            System.out.println(list.toString());
        }

        list.addLast(99);
        System.out.println(list.toString());
        System.out.println("size: " + list.size2());
    }

}

