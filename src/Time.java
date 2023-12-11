public class Time {
    private int second;

    public Time(int second) {
        if (second > 3600*24) this.second=3600*24;
        else this.second = second;
    }

    public Time(int hour, int minets, int second) {
        this(hour*3600 + minets*60 + second);
    }

    @Override
    public String toString(){
        return addNull(getHour()) + ":" + addNull(getMinute()) + ":" + addNull(getSecond());
    }

    public String addNull(int numbrer){
        String num = Integer.toString(numbrer);
        return num.length() < 2 ? "0" + num : num;
    }

    public int getHour(){
        return second/3600;
    }

    public int getMinute(){
        return second%3600/60;
    }
    public int getSecond(){
        return second%60;
    }

    public static void main(String[] args) {
        Time t1 = new Time(340000056);
        System.out.println(t1.toString());

        Time t2 = new Time(25, 34,6);
        System.out.println(t2.toString());
    }
}
