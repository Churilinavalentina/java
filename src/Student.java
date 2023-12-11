import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private List<Integer> grades = new ArrayList<>();

    public Student(String name, int...arr) {
        this.name = name;
        for(int x:arr) {
            if (x >=2 && x<=5) grades.add(x);
            else throw new IllegalArgumentException();
        }
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrades(int...arr) {
        for(int x:arr) {
            if (x >=2 && x<=5) this.grades.add(x);
            else throw new IllegalArgumentException();
        }
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

        a2.setGrades(1);

    }
}
