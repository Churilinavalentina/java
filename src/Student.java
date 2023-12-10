import java.util.ArrayList;
import java.util.List;

public class Student {
    String name;
    List<Integer> grades = new ArrayList<>();

    public Student(String name, int...arr) {
        this.name = name;
        for(int x:arr) grades.add(x);
        this.grades = grades;
    }

    public String studentInfo(){
        return name +":"+grades;
    }

    public static void main(String[] args) {
        //1.2.2
        Student a1 = new Student("Вася", 3,4,5);
        System.out.println(a1.studentInfo());

        Student a2 = new Student("Петя");
        a2.grades = a1.grades;
        System.out.println(a2.studentInfo());

        a1.grades.add(5);
        System.out.println("");
        System.out.println(a1.studentInfo());
        System.out.println(a2.studentInfo());

        Student a3 = new Student("Андрей");
        a3.grades = new ArrayList<>(a1.grades);
        a1.grades.add(3);
        System.out.println("");
        System.out.println(a1.studentInfo());
        System.out.println(a2.studentInfo());
        System.out.println(a3.studentInfo());

        //1.4.7
        Student a4 = new Student("Максим");
        System.out.println(a4.studentInfo());
    }
}
