package ds303.asymptotics;

import java.util.Arrays;

class Uniqueness {

    /**
     * Returns true if there are no duplicate elements in the array.
     */
    public static boolean unique1(int[] data) {
        int n = data.length;
        for (int j = 0; j < n - 1; j++)
            for (int k = j + 1; k < n; k++)
                if (data[j] == data[k])
                    return false;                    // found duplicate pair
        return true;                           // if we reach this, elements are unique
    }

    /**
     * Returns true if there are no duplicate elements in the array.
     */
    public static boolean unique2(int[] data) {
        int n = data.length;
        int[] temp = Arrays.copyOf(data, n);   // make copy of data
        Arrays.sort(temp);                     // and sort the copy
        for (int j = 0; j < n - 1; j++)
            if (temp[j] == temp[j + 1])            // check neighboring entries
                return false;                      // found duplicate pair
        return true;                           // if we reach this, elements are unique
    }

}
