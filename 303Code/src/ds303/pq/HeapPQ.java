package ds303.pq;

import net.datastructures.HeapPriorityQueue;

public class HeapPQ {
    // Driver Code
    public static void main(String[] args) {

  /*           45
            /        \
           31      14
          /  \    /  \
         13  20  7   11
        /  \
       12   7
    Create a priority queue shown in
    example in a binary max heap form.
    Queue will be represented in the
    form of array as:
    45 31 14 13 20 7 11 12 7 */

        // Insert the element to the priority queue
        HeapPriorityQueue<String> pq = new HeapPriorityQueue<>(10);

        int[] keys = {20, 31, 14, 13, 46, 7, 11, 12, 7};
        String[] names = {"Ali", "Ahmed", "Omar", "Salim", "Khaled", "Hani", "Maher", "Amr", "Samer"};

        System.out.println("size= " + keys.length);

        for (int i = 0; i < keys.length; i++) {
            System.out.println("inserting...(" + keys[i] + "," + names[i] + ")");
            pq.insert(keys[i], names[i]);
        }

        System.out.println("pq size: " + pq.size());

        while (!pq.isEmpty()) {
            System.out.print("remove top: ");
            pq.removeMax().display();
        }
        System.out.println("just adding new line to test github");
        System.out.println("pq size: " + pq.size());

    }
}
