package edu.mipt.kozub.basket;

public class Basket<T> {
    private T element;

    public T getElement() {
        T tmp = element;
        this.element=null;
        return tmp;
    }

    public void setElement(T element) {
        if (this.element!=null) throw new IllegalArgumentException("Коробка не пустая");
        this.element = element;
    }

    public boolean chekEmpty(){
        return element==null;
    }
}
