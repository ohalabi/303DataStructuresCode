package net.datastructures;

public class HeapPriorityQueue<E> {
    private Node<E> heapArray[];
    private int size;

    public HeapPriorityQueue(int mx) {
        size = 0;
        heapArray = new Node[mx];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void upheap(int i) {
        int parent = (i - 1) / 2;
        Node<E> bottom = heapArray[i];
        while (i > 0 && heapArray[parent].key < bottom.key) {
            heapArray[i] = heapArray[parent];
            i = parent;
            parent = (parent - 1) / 2;
        }
        heapArray[i] = bottom;
    }

    public void insert(int k, E d) throws IllegalStateException {
        if (size() == heapArray.length) throw new IllegalStateException("Heap is full");
        Node<E> newNode = new Node<>(k, d);
        heapArray[size] = newNode;
        upheap(size);
        size++;
    }

    private boolean hasLeftChild(int i) {
        if ((2 * i + 1) < size)
            return true;
        else
            return false;
    }

    private boolean hasRightChild(int i) {
        if ((2 * i + 2) < size)
            return true;
        else
            return false;
    }

    private void downHeap(int i) {
        int largerChild;
        Node<E> top = heapArray[i];
        while (hasLeftChild(i))  // node has at least one child
        {
            int leftChild = 2 * i + 1;
            largerChild = leftChild;
            if (hasRightChild(i)) {
                int rightChild = 2 * i + 2;
                if (heapArray[rightChild].key > heapArray[leftChild].key)
                    largerChild = rightChild;
            }
            if (top.key > heapArray[largerChild].key)
                break;
            heapArray[i] = heapArray[largerChild];
            i = largerChild;
        }
        heapArray[i] = top;
    }

    public Node<E> removeMax() {
        if (isEmpty())
            return null;
        Node<E> tmp = heapArray[0];
        heapArray[0] = heapArray[--size];
        heapArray[size] = null;
        downHeap(0);
        return tmp;
    }

    public Node<E> max() {
        if (isEmpty())
            return null;
        return heapArray[0];
    }

    public void heapSort(int a[]) {
        HeapPriorityQueue h = new HeapPriorityQueue(a.length);
        for (int i = 0; i < a.length; i++)
            h.insert(a[i], null);

        for (int i = 0; i < a.length; i++)
            a[i] = h.removeMax().key;
    }

    public class Node<E> {
        private int key;
        private E data;

        public Node(int k, E d) {
            key = k;
            data = d;
        }

        public void display() {
            System.out.println("(" + key + "," + data + ") ");
        }
    }
}
