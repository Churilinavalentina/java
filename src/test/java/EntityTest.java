import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.mipt.edu.kozub.annotation.NeedToString;
import ru.mipt.edu.kozub.annotation.ToString;
import ru.mipt.edu.kozub.reflection.Entity;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static ru.mipt.edu.kozub.Utils.fieldCollection;

class EntityTest {
    @Test
    public void testTipeReturn(){
        Method method;
        try {
            method = Entity.class.getDeclaredMethod("toString");
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        Assertions.assertTrue(method.getReturnType().equals(String.class), "return type not equals String");
    }

    //Проверка на наличие в строке названия класса
    @Test
    public void testContainsNameClass(){
        TestField testField = new TestField();
        Assertions.assertTrue(testField.toString().contains(testField.getClass().getName()),
                "results string not contains class name");
    }

    //Проверка на добавление атрибута при аннотации атрибута ToString = YES
    @Test
    public void testContainsFieldYES(){
        TestField testField = new TestField();

        System.out.println(testField.toString());
        List<Field> fields = fieldCollection(testField.getClass());
        Field fieldYes=null;
        for(Field f: fields) {
            f.setAccessible(true);
            ToString toString = f.getDeclaredAnnotation(ToString.class);
            if (toString!=null && toString.equals(NeedToString.YES)) {
                fieldYes = f;
                Assertions.assertTrue(testField.toString().contains(fieldYes.getName()),
                        "results string not contains fields Yes");
            }
        }
    }

    //Проверка на добавление атрибута при аннотации атрибута ToString = NO
    @Test
    public void testContainsFieldNO(){
        TestField testField = new TestField();
        System.out.println(testField.toString());
        List<Field> fields = fieldCollection(testField.getClass());
        System.out.println(fields);
        Field fieldYes=null;
        for(Field f: fields) {
            f.setAccessible(true);
            ToString toString = f.getDeclaredAnnotation(ToString.class);
            if (toString!=null && toString.equals(NeedToString.NO)) {
                fieldYes = f;
                Assertions.assertTrue(!testField.toString().contains(fieldYes.getName()),
                        "results string contains fields  No");
            }
        }
    }

    //Проверка на добавление атрибута без аннотации атрибута ToString, но при аннотации класса ToString = YES
    @Test
    public void testContainsFieldClassYES(){
        TestFieldToString testField = new TestFieldToString();
        System.out.println(testField.toString());
        List<Field> fields = fieldCollection(testField.getClass());
        System.out.println(fields);
        Field fieldYes=null;
        for(Field f: fields) {
            f.setAccessible(true);
            ToString toString = f.getDeclaredAnnotation(ToString.class);
            if (toString==null && testField.getClass().getDeclaredAnnotation(ToString.class).equals(NeedToString.NO)) {
                fieldYes = f;
                Assertions.assertTrue(!testField.toString().contains(fieldYes.getName()),
                        "results string contains fields  No");
            }
        }
    }

}

class TestField extends Entity{
    @ToString(NeedToString.YES)
    String testYes = "qwe";

    @ToString(NeedToString.NO)
    String testNo = "rty";

    String testEmpty = "uio";
}

@ToString(NeedToString.YES)
class TestFieldToString extends Entity{
    @ToString(NeedToString.YES)
    String testYes = "qwe";

    @ToString(NeedToString.NO)
    String testNo = "rty";

    String testEmpty = "uio";
}