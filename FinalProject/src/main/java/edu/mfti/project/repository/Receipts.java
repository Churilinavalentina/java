package edu.mfti.project.repository;

import jakarta.persistence.*;

import javax.sql.DataSource;
import java.util.Date;

@Entity
public class Receipts {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    public Integer book_id;
    public Integer user_id;
    public String open_dt;
    public String close_dt;
    public Receipts(){}

    public Receipts(Integer id, Integer book_id, Integer user_id, String open_dt, String close_dt) {
        this.id = id;
        this.book_id = book_id;
        this.user_id = user_id;
        this.open_dt = open_dt;
        this.close_dt = close_dt;
    }

    @Override
    public String toString() {
        return "Receipts{" +
                "id=" + id +
                ", book_id=" + book_id +
                ", user_id=" + user_id +
                ", open_dt=" + open_dt +
                ", close_dt=" + close_dt +
                '}';
    }
}
