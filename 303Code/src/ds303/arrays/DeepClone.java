package ds303.arrays;

import java.util.Arrays;

public class DeepClone {

    public static int[][] deepClone(int[][] original) {
        int[][] backup = new int[original.length][];  // create top-level array of arrays
        for (int k = 0; k < original.length; k++)
            backup[k] = original[k].clone();            // copy row k
        return backup;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        int[][] sample = {{1, 2, 3}, {4, 5, 6}};
        int[][] backup = deepClone(sample);

        System.out.println("Sample:");
        System.out.println(Arrays.deepToString(sample));
        System.out.println("Backup:");
        System.out.println(Arrays.deepToString(backup));

        for (int j = 0; j < sample.length; j++)
            for (int k = 0; k < sample[j].length; k++)
                sample[j][k] *= 10;

        System.out.println("Sample:");
        System.out.println(Arrays.deepToString(sample));
        System.out.println("Backup:");
        System.out.println(Arrays.deepToString(backup));

        //testing with deep clone of objects
        Person[] contacts = new Person[3];
        contacts[0] = new Person("Ali", 111111);
        contacts[1] = new Person("Salem", 222222);
        contacts[2] = new Person("Omar", 333333);
        System.out.println("Contancts:");
        System.out.println(Arrays.deepToString(contacts));

        Person[] guests = new Person[3];
        for (int i = 0; i < contacts.length; i++) {
            guests[i] = (Person) contacts[i].clone();

        }

        contacts[0].name = "Ahmed";
        contacts[0].mobile = 9999999;
        System.out.println("Contancts:");
        System.out.println(Arrays.deepToString(contacts));

        System.out.println("Guests:");
        System.out.println(Arrays.deepToString(guests));
    }

    public static class Person implements Cloneable {
        String name;
        int mobile;

        public Person(String name, int mobile) {
            this.name = name;
            this.mobile = mobile;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", mobile=" + mobile +
                    '}';
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }
}
