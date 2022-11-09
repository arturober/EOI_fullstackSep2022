package com.example.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.PooledConnection;

import com.example.App;
import com.example.entidades.Category;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CategoryDAOMariaDB implements CategoryDAO {
    private final PooledConnection pcon;

    @Override
    public List<Category> findAll() {
        List<Category> cats = new ArrayList<>();
        try(Connection conn = pcon.getConnection()) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM category");
            while(rs.next()) {
                cats.add(new Category(rs.getInt("id"), rs.getString("name")));
            }
        } catch(SQLException e) {
            System.err.println(e.getMessage());
        }
        return cats;
    }
    
}