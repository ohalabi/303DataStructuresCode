package ds303.hash;

import net.datastructures.LinearProbingHashTable;

public class TestLinear {

    public static void main(String arg[]) {
        LinearProbingHashTable t2 = new LinearProbingHashTable(7); //table size

        Student s1 = new Student(17, "ali", 2);
        Student s2 = new Student(14, "ahmed", 2);
        Student s3 = new Student(28, "khaled", 2);
        Student s4 = new Student(7, "Omar", 2);

        t2.insert(s1.getId(), s1.getName());
        t2.insert(s2.getId(), s2.getName());
        t2.insert(s3.getId(), s3.getName());
        t2.insert(s4.getId(), s4.getName());

/*        t2.insert(new Student(17, "ali", 2));
        t2.insert(new Student(14, "ahmed", 2));
        t2.insert(new Student(28, "khaled", 2));
        t2.insert(new Student(7, "khaled", 2));*/

        t2.displayTable();
        System.out.println("---------------");
        System.out.println("delete 28 khaled...");
        t2.delete(28);
        t2.displayTable();

        System.out.println(t2.find(14));
        System.out.println(t2.find(15));

/*        Student st1 = t2.find(14);
        System.out.println(st1);
        Student st2 = t2.find(15);
        System.out.println(st2);*/
    }
}
