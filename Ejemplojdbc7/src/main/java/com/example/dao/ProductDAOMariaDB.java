package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.PooledConnection;

import com.example.entidades.Product;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProductDAOMariaDB implements ProductDAO {
    private final PooledConnection pcon;

    @Override
    public List<Product> findByCategory(int idCat) {
        List<Product> prods = new ArrayList<>();

        try(Connection conn = pcon.getConnection()) {
            PreparedStatement st = conn.prepareStatement("SELECT * FROM product WHERE category = ?");
            st.setInt(1, idCat);
            ResultSet rs = st.executeQuery();
            
            while(rs.next()) {
                prods.add(new Product(rs.getInt("id"), rs.getString("reference"), rs.getString("name"),
                    rs.getDouble("price"), rs.getInt("category")));
            }
        } catch(SQLException e) {
            System.err.println(e.getMessage());
        }

        return prods;
    }

    @Override
    public Product insert(Product p) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
