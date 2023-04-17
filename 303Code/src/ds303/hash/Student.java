package ds303.hash;

public class Student {
    private int id;
    private String name;
    private double GPA;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double gPA) {
        GPA = gPA;
    }

    public Student(int id, String name, double gPA) {
        super();
        this.id = id;
        this.name = name;
        GPA = gPA;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name;
    }
}

