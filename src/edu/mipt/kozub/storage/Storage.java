package edu.mipt.kozub.storage;

public class Storage<T> {
    private T object;

    public Storage(T object) {
        this.object = object;
    }


    public T getObject() {
        return object;
    }

    public static<T> T getObject(T object, T alternetiva){
        if (object==null) return alternetiva;
        return object;
    }

}
