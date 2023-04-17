package net.datastructures;

public class SinglyLinkedSortedList<E> {
    private Node<E> head = null;

    public void insert(int k, E d) {

        Node<E> previous = null;
        Node<E> current = head;

        while (current != null && k > current.key) {
            previous = current;
            current = current.next;
        }
        if (previous == null)
            head = new Node(k, d, head);
        else
            previous.next = new Node(k, d, current);

    }

    public E find(int k) {
        Node<E> current = head;
        while (current != null && current.key <= k) {
            if (current.key == k)
                return current.data;
            current = current.next;
        }
        return null;

    }

    public void delete(int k) {

        if (head != null)
            if (head.key == k)
                head = head.next;
            else {
                Node<E> previous = null;
                Node<E> current = head;
                while (current != null && k != current.key) {
                    previous = current;
                    current = current.next;
                }
                if (current != null)
                    previous.next = current.next;
            }

    }

    public void displayList() {
        Node<E> current = head;

        while (current != null) {
            current.display();
            current = current.next;
        }
    }

    public class Node<E> {
        Node next;
        private int key;
        private E data;

        public Node(int k, E d, Node<E> n) {
            key = k;
            data = d;
            next = n;
        }

        public void display() {
            System.out.print(key + ":");
            System.out.println(data);
        }
    }
}
