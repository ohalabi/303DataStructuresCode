package ds303.asymptotics;

public class ArrayMax {
    public static double arrayMax(double[] data) {
        int n = data.length;
        double currentMax = data[0];     // assume first entry is biggest (for now)
        for (int j = 1; j < n; j++)        // consider all other entries
            if (data[j] > currentMax)      // if data[j] is biggest thus far...
                currentMax = data[j];        // record it as the current max
        return currentMax;
    }

}
