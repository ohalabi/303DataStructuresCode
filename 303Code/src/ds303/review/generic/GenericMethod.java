package ds303.review.generic;

public class GenericMethod {
    public static <T> void reverse(T[] data) {
        int low = 0, high = data.length - 1;
        while (low < high) {                   // swap data[low] and data[high]
            T temp = data[low];
            data[low++] = data[high];            // post-increment of low
            data[high--] = temp;                 // post-decrement of high
        }
    }

    //Demo
    public static void main(String[] args) {
        Integer[] inumbers = {1, 2, 3, 4, 5};
        Double[] dnumbers = {1.1, 2.2, 3.3, 4.4, 5.5};

      reverse(inumbers);
        for (Integer n : inumbers) {
            System.out.print (n + " ");
        }
        System.out.println();

        reverse(dnumbers);
        for (double n : dnumbers) {
            System.out.print (n + " ");
        }
    }
}
