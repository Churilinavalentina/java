import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
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
    TestField entity1 = new TestField();
    TestFieldToString entity2 = new TestFieldToString();
    @Test
    @DisplayName("return type")
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
    @DisplayName("results string contains class name")
    public void testContainsNameClass(){
        Assertions.assertTrue(entity1.toString().contains(entity1.getClass().getName()),
                "results string not contains class name");
    }

    //Проверка на наследование
    @Test
    @DisplayName("results string contains parent fields")
    public void testContainsParentClass(){
        String str = entity2.toString();
        Assertions.assertTrue(()->str.contains("testYesParrent"),
                "results string not contains parent fields");
    }

    //Проверка на добавление атрибута при аннотации атрибута ToString = YES
    @Test
    @DisplayName("contains fields YES")
    public void testContainsFieldYES(){
        String str = entity2.toString();
        Assertions.assertTrue(()->str.contains("testYesParrent"));
        Assertions.assertTrue(()->str.contains("testYes"));
    }

    //Проверка на добавление атрибута при аннотации атрибута ToString = NO
    @Test
    @DisplayName("contains fields NO")
    public void testContainsFieldNO(){
        String str = entity2.toString();
        Assertions.assertTrue(()->!str.contains("testNoParrent"));
        Assertions.assertTrue(()->!str.contains("testNo"));
    }

    //Проверка на добавление атрибута без аннотации атрибута ToString, но при аннотации класса ToString = YES
    @Test
    @DisplayName("contains fields empty")
    public void testContainsFieldClassYES(){
        String str = entity2.toString();
        Assertions.assertTrue(()->str.contains("testEmpty"));
    }

}

class TestField extends Entity{
    @ToString(NeedToString.YES)
    private String testYesParrent = "qwe";

    @ToString(NeedToString.NO)
    private String testNoParrent = "rty";

    private String testEmptyParrent = "uio";
}

@ToString(NeedToString.YES)
class TestFieldToString extends TestField{
    @ToString(NeedToString.YES)
    String testYes = "qwe";

    @ToString(NeedToString.NO)
    String testNo = "rty";

    String testEmpty = "uio";
}