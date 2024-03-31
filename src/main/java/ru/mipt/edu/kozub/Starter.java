package ru.mipt.edu.kozub;

import jakarta.persistence.Entity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import ru.mipt.edu.kozub.ValidateAnnotationBeanPostProcessor.ValidateAnnotationPost;
import ru.mipt.edu.kozub.jbdc.DBCreator;
import ru.mipt.edu.kozub.jbdc.DepartmentRepo;
import ru.mipt.edu.kozub.jbdc.EmployeeRepo;
import ru.mipt.edu.kozub.people.Student;
import ru.mipt.edu.kozub.spring.Config;
import ru.mipt.edu.kozub.spring.StudentBuilder;
import ru.mipt.edu.kozub.spring.TrafficLite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.*;

import static ru.mipt.edu.kozub.jbdc.DBCreator.createDB;


@SpringBootApplication
@EntityScan("ru.mipt.edu.kozub.jbdc")
@ComponentScan("ru.mipt.edu.kozub.jbdc")
public class Starter {

    public static void main(String[] args) throws Exception {
        createDB();
        ApplicationContext ctx = SpringApplication.run(Starter.class);
        DepartmentRepo repo = ctx.getBean(DepartmentRepo.class);
        EmployeeRepo repoEmp = ctx.getBean(EmployeeRepo.class);
        //System.out.println(repo.findAll());
        System.out.println(repoEmp.join());





//        Fraction fr = new Fraction(1, 2);
//        Fractionable fract = Utils.cache(fr);
//        System.out.println(fract.doubleValue());
//        System.out.println(fract.doubleValue());
//        System.out.println(fract.doubleValue());
//
////        Задание 1:
////        Написать следующую стриму: дан набор объектов типа Point, необходимо взять все Point в разных точках, (убрать с одинаковыми X,Y),отсортировать по X, отрицательные Y сделать положительными и собрать это все в ломаную (объект типа Polyline)
//
//        List<Point> points = Arrays.asList(new Point(2,3), new Point(3, 5), new Point(2,3));
//        BrokenLine polyline = points.stream()
//                .map(p->new Point(p.x, Math.abs(p.y)))
//                .distinct()
//                .sorted(Comparator.comparingInt(p->p.x))
//                .collect(Collectors.collectingAndThen(Collectors.toList(), BrokenLine::new));
//
//        System.out.println(polyline);
//
//
////        Задание 2:
////        Дан текстовый файл с строками содержащими имя человека и его номер в следующей форме:
////        Вася:5
////        Петя:3
////        Аня:5
////        Номера людей могут повторяться.
////        У каких-то людей может не быть номера.
////                Необходимо написать стриму выполняющую следующее:
////        читаются все люди из файла, все имена приводится к нижнему регистру, но с первой буквой в верхнем регистре, убираем из перечня всех людей без номеров, а имена оставшихся группируются по их номеру:
////[5:[Вася, Аня], 3:[Петя]]
//
//        Path path = Path.of("text.txt");
//        String r = Files.lines(path).toString();
//        var res = Files.lines(path)
//                .map(l->l.split(":"))
//                .filter(array -> array.length>1)
//                .map(array -> new String[]{array[0].substring(0,1).toUpperCase()+array[0].substring(1).toLowerCase(), array[1]})
//                .collect(Collectors.groupingBy(array -> array[1], Collectors.mapping(array -> array[0], Collectors.toList())));
//        System.out.println(res);
//
//        //7.1.1
//        System.out.println("\n\n//7.1.1");
//
//        Square sq = new Square(new Point(1,2), 2);
//        System.out.println(fieldCollection(sq.getClass()));
//
//        //7.1.2
//        System.out.println("\n\n//7.1.2");
//
//        Line l1 = new Line(new Point(1, 2), new Point(3,4));
//        Line l2 = new Line(new Point(5, 6), new Point(7,8));
//        lineConnector(l1, l2);
//        System.out.println(l1);
//        System.out.println(l2);
//
//        //7.1.3
//        System.out.println("\n\n//7.1.3");
//
//        System.out.println(new City("test", new Road(new City("t1"), 5)).toString());
//
//        //7.1.4, 7.2.4, 7.2.5
//        System.out.println("\n\n//7.1.4, 7.2.4");
//
//        Student s1 = new Student("Pety", 2,3);
//        Validation.validate(new Student[]{s1});
//
//        //7.1.5 Чтение работает только для классов, где аргументы - строки
//        System.out.println("\n\n//7.1.5");
//
//        ObjectsWriter ow = new ObjectsWriter("Name.txt");
//        ow.write(Arrays.asList(new Name("Petr", "Petrovich"), new Name("Ivan", "Ivanovich")));
//
//        ObjectsReader<Name> or = new ObjectsReader<>("Name.txt");
//        System.out.println(or.read());
//        System.out.println(or.read().get(1).getFirstName());
//
//        //7.3.1
//        System.out.println("\n\n//7.3.1");
//
//        Class name1 = or.read().get(1).getClass();
//        System.out.println(collect(new String[]{"Ivan", "Ivanov", "Ivanovich"}, name1));
//
//        //7.3.2
//        System.out.println("\n\n//7.3.2");
//        Square square = new Square(new Point(4,5), 2);
//        reset(square);
//        System.out.println(square);
//
//        //7.3.3
//        System.out.println("\n\n//7.3.3");
//
//        System.out.println(new City("test", new Road(new City("t1"), 5)).toString());

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