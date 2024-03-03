package ru.mipt.edu.kozub.storage;

public class Storage<T> {
    private T object;

    public Storage(T object) {
        this.object = object;
    }


    public T getObject() {
        return object;
    }

    public T getObject(T alternetiva){
        if (this.object==null) return alternetiva;
        return this.object;
    }

}
