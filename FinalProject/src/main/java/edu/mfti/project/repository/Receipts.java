package edu.mfti.project.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import javax.sql.DataSource;
import java.util.Date;

@Entity
public class Receipts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer book_id;
    private Integer user_id;
    private Date open_dt;
    private Date close_dt;
    public Receipts(){}

    public Receipts(Integer id, Integer book_id, Integer user_id, Date open_dt, Date close_dt) {
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
