public class Time {
    final int second;

    public Time(int second) {
        this.second = second;
    }

    public Time(int hour, int minets, int second) {
        this.second = hour*3600 + minets*60 + second;
    }

    @Override
    public String toString(){
        return addNull(second/3600) + ":" + addNull(second%3600/60) + ":" + addNull(second%60);
    }

    public String addNull(int numbrer){
        String num = Integer.toString(numbrer);
        return num.length() < 2 ? "0" + num : num;
    }

    public static void main(String[] args) {
        Time t1 = new Time(10000);
        Time t2 = new Time(2, 3, 5);
        System.out.println(t1.toString());
        System.out.println(t2.toString());
    }
}
