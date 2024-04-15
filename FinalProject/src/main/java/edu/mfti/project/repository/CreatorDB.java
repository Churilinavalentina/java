package edu.mfti.project.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreatorDB {
    public static void createDB() {
        try (Connection con = DriverManager.getConnection("jdbc:h2:.\\Library")) {
            Statement stm = con.createStatement();
            stm.executeUpdate("DROP TABLE Book IF EXISTS");
            stm.executeUpdate("CREATE TABLE Book(ID INT PRIMARY KEY, NAME VARCHAR(255), AUTHOR VARCHAR(255))");
            stm.executeUpdate("INSERT INTO Book VALUES(1, 'War and Peace', 'Leo Tolstoy')");
            stm.executeUpdate("INSERT INTO Book VALUES(2,'1984', 'George Orwell')");
            stm.executeUpdate("INSERT INTO Book VALUES(3,'Ulysses', 'James Joyce')");
            stm.executeUpdate("INSERT INTO Book VALUES(4,'Lolita', 'Vladimir Nabokov')");

            stm.executeUpdate("DROP TABLE User IF EXISTS");
            stm.executeUpdate("CREATE TABLE User(ID INT PRIMARY KEY, NAME VARCHAR(255))");
            stm.executeUpdate("INSERT INTO User VALUES(1,'Pete')");
            stm.executeUpdate("INSERT INTO User VALUES(2,'Ann')");
            stm.executeUpdate("INSERT INTO User VALUES(3,'Liz')");
            stm.executeUpdate("INSERT INTO User VALUES(4,'Tom')");

            stm.executeUpdate("DROP TABLE Receipts IF EXISTS");
            stm.executeUpdate("CREATE TABLE Receipts(ID INT PRIMARY KEY, USER_ID INT, BOOK_Id INT, OPEN_DT DATE, CLOSE_DT DATE)");
            stm.executeUpdate("INSERT INTO Receipts VALUES(1, 1, 2, '2024-03-12', NULL)");
            stm.executeUpdate("INSERT INTO Receipts VALUES(2, 1, 3, '2024-03-12', NULL)");

            stm.executeUpdate("INSERT INTO Receipts VALUES(3, 2, 1, '2024-02-01', '2024-02-15')");
            stm.executeUpdate("INSERT INTO Receipts VALUES(4, 2, 4, '2024-02-15', NULL)");

            stm.executeUpdate("INSERT INTO Receipts VALUES(5, 3, 1, '2024-02-18', NULL)");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}