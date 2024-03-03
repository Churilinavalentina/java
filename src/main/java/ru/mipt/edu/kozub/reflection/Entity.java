package ru.mipt.edu.kozub.reflection;

import ru.mipt.edu.kozub.annotation.Invoke;
import ru.mipt.edu.kozub.annotation.NeedToString;
import ru.mipt.edu.kozub.annotation.ToString;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;

import static ru.mipt.edu.kozub.Utils.fieldCollection;


public abstract class Entity {
    @Override
    @Invoke
    public final String toString(){
        List<Field> fields = fieldCollection(this.getClass());
        String s = this.getClass().getName() + "{";
        for(Field f: fields){
            f.setAccessible(true);
            ToString toString=f.getDeclaredAnnotation(ToString.class);
            if(toString==null) toString=f.getDeclaringClass().getDeclaredAnnotation(ToString.class);
            if(!(toString==null||toString.value()== NeedToString.YES)) continue;
            if(Modifier.isStatic(f.getModifiers())) continue;
            try {
                s = s + f.getName() + "=" + f.get(this) + ",";
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        s = s.substring(0,s.length()-1);
        s = s + "}";
        return  s;
    }
}
