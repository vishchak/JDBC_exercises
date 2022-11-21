package com.gmail.vishchak.denis.flatJDBC;


import java.sql.*;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/flatdb?serverTimezone=UTC";
    static final String DB_USER = "root";
    static final String DB_PASSWORD = "password";

    static Connection conn;

    public static void main(String[] args) {

    }
    private static void initDB() throws SQLException {
        Statement st = conn.createStatement();
        try {
            st.execute("DROP TABLE IF EXISTS Flats");
            st.execute("CREATE TABLE Flats(" +
                    "id INT NOT NULL AUTO_INCREMENT PRIMARY KEY," +
                    "district VARCHAR(50) DEFAULT NULL," +
                    "area FLOAT NOT NULL," +
                    "roomsTotal INT DEFAULT NULL," +
                    "price BIGINT DEFAULT NULL)");
        } finally {
            st.close();
        }
    }

    private static void addFlat(Scanner sc) throws SQLException {
        System.out.println("Input flat's district");
        String district = sc.nextLine();
        System.out.println("Input flat's area");
        double area = sc.nextDouble();
        System.out.println("Input flat's rooms total");
        int totalRooms = sc.nextInt();
        System.out.println("Input flat's price");
        long price = sc.nextLong();

        PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO Flats (district, area, roomsTotal, price) VALUES(?, ?, ?, ?)");
        try {
            ps.setString(1, district);
            ps.setDouble(2, area);
            ps.setInt(3, totalRooms);
            ps.setLong(4, price);
            ps.executeUpdate();
        } finally {
            ps.close();
        }
    }

    private static void addRandomFlat(Scanner sc) throws SQLException {
        System.out.println("Add flats count");
        int count = sc.nextInt();
        Random random = new Random();

        conn.setAutoCommit(false);
        try {
            try {
                PreparedStatement ps = conn.prepareStatement(
                        "INSERT INTO Flats (district, area, roomsTotal, price) VALUES(?, ?, ?, ?)");

                try {
                    for (int i = 0; i < count; i++) {
                        ps.setString(1, "district" + i);
                        ps.setDouble(2, random.nextDouble() * 100);
                        ps.setInt(3, random.nextInt(10));
                        ps.setLong(4, random.nextInt(1000000));
                        ps.executeUpdate();
                    }
                    conn.commit();
                } finally {
                    ps.close();
                }
            } catch (Exception e) {
                conn.rollback();
            }
        } finally {
            conn.setAutoCommit(true);
        }
    }


}