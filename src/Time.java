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
        return addNull(hour()) + ":" + addNull(minute()) + ":" + addNull(second());
    }

    public String addNull(int numbrer){
        String num = Integer.toString(numbrer);
        return num.length() < 2 ? "0" + num : num;
    }

    public int hour(){
        return second/3600;
    }

    public int minute(){
        return second%3600/60;
    }
    public int second(){
        return second%60;
    }

    public static void main(String[] args) {
        Time t1 = new Time(34056);
        Time t2 = new Time(4532);
        Time t3 = new Time(123);
        System.out.println(t1.hour());
        System.out.println(t2.minute());
        System.out.println(t3.second());
    }
}
