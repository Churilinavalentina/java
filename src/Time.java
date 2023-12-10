public class Time {
    final int second;

    public Time(int second) {
        this.second = second;
    }

    public Time(int hour, int minets, int second) {
        this.second = hour*3600 + minets*60 + second;
    }

    public String time(){
        return convertToSring(second/3600) + ":" + convertToSring(second%3600/60) + ":" + convertToSring(second%60);
    }

    public String convertToSring(int numbrer){
        String num = Integer.toString(numbrer);
        return num.length() < 2 ? "0" + num : num;
    }

    public static void main(String[] args) {
        Time t1 = new Time(10000);
        Time t2 = new Time(2, 3, 5);
        System.out.println(t1.time());
        System.out.println(t2.time());
    }
}
