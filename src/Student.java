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

    @Override
    public String toString(){
        return name +":"+grades;
    }

    public double average() {
        double average=0;
        int count = 0;

        if (grades.isEmpty()) return 0;

        for (int i: grades){
            average = average+i;
            count++;
        }
        return average/count;
    }

    public boolean excellent() {
        if (this.average()==5) return true;
        return false;
    }

    public static void main(String[] args) {
        Student a1 = new Student("Вася", 3,4,5,4);
        System.out.println(a1.average());
        System.out.println(a1.excellent());

        Student a2 = new Student("Петя", 5,5,5,5);
        System.out.println(a2.average());
        System.out.println(a2.excellent());

    }
}
