package edu.mipt.kozub;
import edu.mipt.kozub.geometry.line.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class Starter {

    public static void main(String[] args) throws Exception {

//        Задание 1:
//        Написать следующую стриму: дан набор объектов типа Point, необходимо взять все Point в разных точках, (убрать с одинаковыми X,Y),отсортировать по X, отрицательные Y сделать положительными и собрать это все в ломаную (объект типа Polyline)

        List<Point> points = Arrays.asList(new Point(2,3), new Point(3, 5), new Point(2,3));
        BrokenLine polyline = points.stream()
                .map(p->new Point(p.x, Math.abs(p.y)))
                .distinct()
                .sorted(Comparator.comparingInt(p->p.x))
                .collect(Collectors.collectingAndThen(Collectors.toList(), BrokenLine::new));

        System.out.println(polyline);


//        Задание 2:
//        Дан текстовый файл с строками содержащими имя человека и его номер в следующей форме:
//        Вася:5
//        Петя:3
//        Аня:5
//        Номера людей могут повторяться.
//        У каких-то людей может не быть номера.
//                Необходимо написать стриму выполняющую следующее:
//        читаются все люди из файла, все имена приводится к нижнему регистру, но с первой буквой в верхнем регистре, убираем из перечня всех людей без номеров, а имена оставшихся группируются по их номеру:
//[5:[Вася, Аня], 3:[Петя]]

        Path path = Path.of("text.txt");
        String r = Files.lines(path).toString();
        var res = Files.lines(path)
                .map(l->l.split(":"))
                .filter(array -> array.length>1)
                .map(array -> new String[]{array[0].substring(0,1).toUpperCase()+array[0].substring(1).toLowerCase(), array[1]})
                .collect(Collectors.groupingBy(array -> array[1], Collectors.mapping(array -> array[0], Collectors.toList())));
        System.out.println(res);



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