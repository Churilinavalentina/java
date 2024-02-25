package edu.mipt.kozub.reflection;

import edu.mipt.kozub.annotation.Default;
import edu.mipt.kozub.annotation.Invoke;
import edu.mipt.kozub.annotation.ToString;

import java.lang.reflect.Field;
import java.util.List;

import static edu.mipt.kozub.Utils.fieldCollection;

public abstract class Entity {
    @Override
    @Invoke
    public final String toString(){
        List<Field> fields = fieldCollection(this.getClass());
        String s = this.getClass().getName() + "{";
        for(Field f: fields){
            f.setAccessible(true);
            if(!(f.isAnnotationPresent(ToString.class) && f.getAnnotation(ToString.class).value().equals("NO"))) {
                try {
                    s = s + f.getName() + "=" + f.get(this) + ",";
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        s = s.substring(0,s.length()-1);
        s = s + "}";
        return  s;
    }
}
