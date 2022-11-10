package net.datastructures;

public class ChainingHashTable<E> {

    private SinglyLinkedSortedList[] hashArray;
    private int arraySize;

    public ChainingHashTable(int size) {
        arraySize = size;
        hashArray = new SinglyLinkedSortedList[arraySize];
        for (int j = 0; j < hashArray.length; j++)
            hashArray[j] = new SinglyLinkedSortedList();
    }

    public int hashFunc(int key) {
        return key % hashArray.length;
    }

    public void insert(int k, E d) {
        int hashVal = hashFunc(k);
        hashArray[hashVal].insert(k, d);
    }

    public void delete(int k) {
        int hashVal = hashFunc(k);
        hashArray[hashVal].delete(k);
    }

    public E find(int k) {
        int hashVal = hashFunc(k);
        E d = (E) hashArray[hashVal].find(k);
        return d;
    }

    public void displayTable() {
        for (int j = 0; j < hashArray.length; j++)
            hashArray[j].displayList();
    }
}


