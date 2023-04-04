package ds303.revision;

import net.datastructures.LinkedStack;

public class SinglyLinkedList<E extends Comparable<E>> implements Cloneable {
    //---------------- nested Node class ----------------

    /**
     * The head node of the list
     */
    private Node<E> head = null;               // head node of the list (or null if empty)

    // instance variables of the SinglyLinkedList
    /**
     * The last node of the list
     */
    private Node<E> tail = null;               // last node of the list (or null if empty)
    /**
     * Number of nodes in the list
     */
    private int size = 0;                      // number of nodes in the list

    /**
     * Constructs an initially empty list.
     */
    public SinglyLinkedList() {
    }              // constructs an initially empty list

    public Node<E> getHead() {
        return head;
    }

    // update methods

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
        return head.getElement();
    }

    /**
     * Returns (but does not remove) the last element of the list.
     *
     * @return element at the end of the list (or null if empty)
     */
    public E last() {              // returns (but does not remove) the last element
        if (isEmpty()) return null;
        return tail.getElement();
    }

    /**
     * Adds an element to the front of the list.
     *
     * @param e the new element to add
     */
    public void addFirst(E e) {                // adds element e to the front of the list
        head = new Node<>(e, head);              // create and link a new node
        if (size == 0)
            tail = head;                           // special case: new node becomes tail also
        size++;
    }

    /**
     * Adds an element to the end of the list.
     *
     * @param e the new element to add
     */
    public void addLast(E e) {                 // adds element e to the end of the list
        Node<E> newest = new Node<>(e, null);    // node will eventually be the tail
        if (isEmpty())
            head = newest;                         // special case: previously empty list
        else
            tail.setNext(newest);                  // new node after existing tail
        tail = newest;                           // new node becomes the tail
        size++;
    }

    /**
     * Removes and returns the first element of the list.
     *
     * @return the removed element (or null if empty)
     */
    public E removeFirst() {                   // removes and returns the first element
        if (isEmpty()) return null;              // nothing to remove
        E answer = head.getElement();
        head = head.getNext();                   // will become null if list had only one node
        size--;
        if (size == 0)
            tail = null;                           // special case as list is now empty
        return answer;
    }

    //remove last to be added here
    public E removeLast() {
        if (isEmpty()) return null;
        E answer = tail.getElement();
        if (head == tail)
            head = tail = null;
        else {
            Node<E> tmp = head;
            while (tmp.getNext() != tail)
                tmp = tmp.getNext();
            tmp.setNext(null);
            tail = tmp;
        }
        size--;
        return answer;
    }

    /**
     * Returns the number of elements in the linked list.
     *
     * @return number of elements in the linked list
     */
    public int size() {
        return size;
    }

    @SuppressWarnings({"unchecked"})
    public boolean equals(Object o) {
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        SinglyLinkedList other = (SinglyLinkedList) o;   // use nonparameterized type
        if (size != other.size) return false;
        Node walkA = head;                               // traverse the primary list
        Node walkB = other.head;                         // traverse the secondary list
        while (walkA != null) {
            if (!walkA.getElement().equals(walkB.getElement())) return false; //mismatch
            walkA = walkA.getNext();
            walkB = walkB.getNext();
        }
        return true;   // if we reach this, everything matched successfully
    }

    @SuppressWarnings({"unchecked"})
    public SinglyLinkedList<E> clone() throws CloneNotSupportedException {
        // always use inherited Object.clone() to create the initial copy
        SinglyLinkedList<E> other = (SinglyLinkedList<E>) super.clone(); // safe cast
        if (size > 0) {                    // we need independent chain of nodes
            other.head = new Node<>(head.getElement(), null);
            Node<E> walk = head.getNext();      // walk through remainder of original list
            Node<E> otherTail = other.head;     // remember most recently created node
            while (walk != null) {              // make a new node storing same element
                Node<E> newest = new Node<>(walk.getElement(), null);
                otherTail.setNext(newest);     // link previous node to this one
                otherTail = newest;
                walk = walk.getNext();
            }
        }
        return other;
    }

    public int hashCode() {
        int h = 0;
        for (Node walk = head; walk != null; walk = walk.getNext()) {
            h ^= walk.getElement().hashCode();      // bitwise exclusive-or with element's code
            h = (h << 5) | (h >>> 27);              // 5-bit cyclic shift of composite code
        }
        return h;
    }

    /**
     * Produces a string representation of the contents of the list.
     * This exists for debugging purposes only.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        Node<E> walk = head;
        while (walk != null) {
            sb.append(walk.getElement());
            if (walk != tail)
                sb.append(", ");
            walk = walk.getNext();
        }
        sb.append(")");
        return sb.toString();
    }

    /* Write a recursive function to count the number of nodes in a given singly linked list */
//    private int getCountRec(Node<E> node) {
//        // Base case
//        if (node == null)
//            return 0;
//
//        // Count is this node plus rest of the list
//        return 1 + getCountRec(node.next);
//    }
//
//    /* Wrapper over getCountRec() */
//    private int getCount() {
//        return getCountRec(head);
//    }

    /**
     * Given a singly linked list of N nodes.
     * The task is to find the middle of the linked list. For example, if the linked list is
     * 1-> 2->3->4->5, then the middle node of the list is 3.
     * If there are two middle nodes(in case, when N is even), print the second middle element.
     * For example, if the linked list given is 1->2->3->4->5->6, then the middle node of the list is 4.
     **/
    public E getMiddle() {
        // Your code here.
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return (E) slow.getElement();
    }


    /**
     * Given a linked list sorted in increasing order,
     * write a function that removes duplicate nodes from it by traversing the list only once.
     * For example, the list {1, 2, 2, 2, 3, 4, 4, 5} should be converted into
     * the list {1, 2, 3, 4, 5}.
     **/
    public void removeDup() {
        Node<E> current = head;
        // compare the current node with the next node
        while (current != null && current.next != null) {
            if (current.getElement() == current.next.getElement()) {
                current.next = current.next.next;
            } else {
                current = current.next;    // only advance if no deletion
            }
        }
        tail = current; //super error!!
    }

    /**
     * You are given a Singly Linked List that holds integers. Write a method
     * arrangeOddEven(SinglyLinkedList list) that takes a SinglyLinkedList as a parameter.
     * The method should rearrange the elements of the linked list such that all the odd elements appear
     * before the even elements. Your implementation should use a stack to accomplish this task.
     * <p>
     * Example input: 1 -> 2 -> 4 -> 8 -> 5
     * Example output: 1 -> 5 -> 8 -> 4 -> 2
     **/
    public void arrangeOddEven(SinglyLinkedList list) {
        LinkedStack<E> stack = new LinkedStack<>();
        for (int i = 0; i < list.size(); i++) {
            E num = (E) list.removeFirst();
            if ((Integer) num % 2 == 0) {
                stack.push(num);
            } else {
                list.addLast(num);
            }
        }
        while (!stack.isEmpty()) {
            list.addLast(stack.pop());
        }
    }

    /**
     * Bubble sorting algorithm for a list
     */
    public void sort() {
        if (head == null || head.next == null) {
            return; // empty or only one element in the list, no need to sort
        }
        boolean swapped;
        Node<E> current;
        do {
            swapped = false;
            current = head;
            while (current.next != null) {
                E elem = current.getElement();
                if (elem.compareTo(current.next.getElement()) > 0) {
                    // swap current and current.next
                    E temp = current.getElement();
                    current.element = current.next.getElement();
                    current.next.element = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }

    /**
     * Node of a singly linked list, which stores a reference to its
     * element and to the subsequent node in the list (or null if this
     * is the last node).
     */
    private static class Node<E> {

        /**
         * The element stored at this node
         */
        private E element;            // reference to the element stored at this node

        /**
         * A reference to the subsequent node in the list
         */
        private Node<E> next;         // reference to the subsequent node in the list

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
}


