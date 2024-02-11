package edu.mipt.kozub;
import edu.mipt.kozub.geometry.Circle;
import edu.mipt.kozub.geometry.Group;
import edu.mipt.kozub.geometry.Square;
import edu.mipt.kozub.geometry.line.*;
import edu.mipt.kozub.people.Save;
import edu.mipt.kozub.people.Student;

import java.util.*;
import java.util.function.*;

public class Starter {

    public static void main(String[] args) throws Exception {

        Student student= new Student("vasia");

        student.setGrades(5);

        student.setGrades(3);
        Save save= student.getSave();

        student.setGrades(4);

        student.setName("anna");

        student.removeGrades(2);//удаление по индексу
        System.out.println(student);

        student.undo();
        System.out.println(student);


        student.undo();
        System.out.println(student);

        student.undo();
        System.out.println(student);

        student.undo();
        System.out.println(student);

        save.load();
        System.out.println(student);

//        List.of("Qwwqw","ty5ty","6","A11");
//        DataStream<Integer> ds = DataStream.create(List.of(4, -2, 9, -4, 25, -7, -8));
//        ds = ds.filter(x -> x > 0)
//                .map(x -> Math.sqrt(x))
//                .map(x -> x.intValue());
//        //int res=ds.reduce((x,y)->x+y,0);
//        //System.out.println(res);
//
//        List<Integer> resList=ds.collect(ArrayList::new,(xLst,x)->xLst.add(x));
//        System.out.println(resList.toString());
//
//        //4.1 есть список строк, отобрать те строки, которые начинаются с большой буквы, и посчитать общую длину оставшихся строк
//        DataStream<String> ds1 = DataStream.create(List.of("Qwwqw","ty5ty","6","A11"));
//        ds1 = ds1.filter(x-> Character.isUpperCase(x.charAt(0)));
//        int res1= ds1.reduce((x,y)-> x+y,"").length();
//        System.out.println(res1);
//
//        //4.2 есть список чисел, удалить нули, результат разложить по двум спискам: в одном отрицательные значения, в другом положительные
//        DataStream<Integer> ds2 = DataStream.create(List.of(1, 0, -3, 8, -4, 0));
//        ds2 = ds2.filter(x->x!=0);
//        List<Integer> lst1 = ds2
//                .collect(ArrayList::new, (xLst,x)-> {
//                    if (x > 0) xLst.add(x);
//                });
//        List<Integer> lst2 = ds2
//                .collect(ArrayList::new, (xLst,x)-> {
//                    if (x < 0) xLst.add(x);
//                });
//        System.out.println(lst1.toString());
//        System.out.println(lst2.toString());
//
//        //4.3 дан список строк, некоторые из них числа. Удалить все строки НЕ являющиеся числами, преобразовать строки в числа, и получить их сумму
//        DataStream<String> ds3 = DataStream.create(List.of("Qwwqw","ty5ty","6","A11","5"));
//        List<Integer> lst3 = ds3.filter(x-> x.matches("[-+]?\\d+"))
//                .collect(ArrayList::new, (xLst,x)->xLst.add(Integer.valueOf(x)));
//        int res3= DataStream.create(lst3).reduce((x,y)-> x+y,0);
//        System.out.println(res3);


        Group gr1 = new Group(Line.of(1,2,3,4), new Point(1,2), new Point3D(1,2,3), new Circle(new Point(5,6), 5));
        Group gr2 = new Group(new Square(7,8,9));
        Group gr3 = new Group(gr1, gr2);

        System.out.println(gr3);

        gr3.move(2,3);

        System.out.println(gr3);

    }
}
/*
1) статический метод инициализации
2) доделать метод collect
3) опционально: переделать текущую реализацию в ОО стиле
4) выполнить задачки c применением нашего DataStream
4.1 есть список строк, отобрать те строки, которые начинаются с большой буквы, и посчитать общую длину оставшихся строк
4.2 есть список чисел, удалить нули, результат разложить по двум спискам: в одном отрицательные значения, в другом положительные
4.3 дан список строк, некоторые из них числа. Удалить все строки НЕ являющиеся числами, преобразовать строки в числа, и получить их сумму
 */
class DataStream<T> {
    private List<T> list;
    private List actions=new ArrayList();

    public static<T> DataStream<T> create(List<T> list){
        return new DataStream<>(list);
    }

    private DataStream(List<T> list) {
        this.list = list;
    }

    public <R> DataStream<R> map(Function<T, R> function) {
        actions.add(function);
        return (DataStream)this;
    }

    public DataStream<T> filter(Predicate<T> rule) {
        actions.add(rule);
        return this;
    }

    public<R> R collect(Supplier<R> init, BiConsumer<R, T> op) {
        R res = init.get();
        up: for (T t:list) {
            for (Object action:actions) {
                if(action instanceof Function){
                    Function fun= (Function) action;
                    t=(T)fun.apply(t);
                    continue;
                }
                if(action instanceof Predicate){
                    Predicate rule= (Predicate) action;
                    if(!rule.test(t)){
                        continue up;
                    }
                }
            }
            op.accept(res, t);
        }
        return res;

    }

    public T reduce(BinaryOperator<T> operator, T start) {
        T res = start;
        up: for (T t:list) {
            for (Object action:actions) {
                if(action instanceof Function){
                    Function fun= (Function) action;
                    t=(T)fun.apply(t);
                    continue;
                }
                if(action instanceof Predicate){
                    Predicate rule= (Predicate) action;
                    if(!rule.test(t)){
                        continue up;
                    }
                }
            }
            res = operator.apply(res, t);
        }
        return res;
    }
}