package edu.mipt.kozub.other;

public class Gun {
    private int patron;

    public Gun(int patron) {
        this.patron = patron;
    }
    public Gun() {
        this.patron = 5;
    }

    public void setPatron(int patron) {
        if (patron<0) {
            System.out.println("Пистолет не может содержать отрицательное количество патронов");
            throw new IllegalArgumentException();
        }
        if (patron <= this.patron) this.patron = patron;
        else {
            this.patron = patron;
            System.out.println(patron-this.patron +" патронов оказались лишние");
        }
    }

    public int getPatron() {
        return patron;
    }

    public int getAllPatron() {
        int count = patron;
        patron = 0;
        return count;
    }

    public boolean charged() {
        if (patron>0) return true;
        return false;
    }


    public void shot(int countShot){
        for (int i =0;i<countShot;i++){
            if (patron > 0){
                patron -= 1;
                System.out.println("Бaх!");
            } else {
                System.out.println("Клац!");
            }
        }
    }
}
