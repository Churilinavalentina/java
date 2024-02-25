package edu.mipt.kozub.reflection;

import java.lang.reflect.Field;
import java.util.List;

import static edu.mipt.kozub.Utils.fieldCollection;

public abstract class Entity {
    @Override

    public final String toString(){
        List<Field> fields = fieldCollection(this.getClass());
        String s = this.getClass().getName() + "{";
        for(Field f: fields){
            f.setAccessible(true);
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
