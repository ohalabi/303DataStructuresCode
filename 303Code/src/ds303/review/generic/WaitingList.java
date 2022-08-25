package ds303.review.generic;

public class WaitingList<E> {
    private E[] a;
    private int count;

    public WaitingList(int s) {
        a = (E[]) new Object[s];
        count = 0;
    }

    public void add(E e) {
        a[count] = e;
        count++;
    }

    public E get(int i) {
        if (i < count)
            return a[i];
        else
            return null;
    }

    public void print() {
        for (int i = 0; i < count; i++)
            System.out.println(a[i]);
    }

    //Demo
    public static void main(String[] args) {

        Student s1 = new Student("Ali", 3.3);
        Student s2 = new Student("Ahmed", 3.1);

        WaitingList<Student> ws = new WaitingList<Student>(5);

        ws.add(s1);
        ws.add(s2);

        Student tmp = ws.get(1);
        System.out.println(tmp);

        ws.print();
    }



} //class


