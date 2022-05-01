package dao;

import entity.Fruit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FruitDao {
    private Connection connection;
    private final String GET_FRUITS_QUERY = "SELECT * FROM fruit";
    private final String DELETE_FRUITS_QUERY = "DELETE FROM fruit WHERE id = ?";
    private final String UPDATE_FRUITS_QUERY = "UPDATE fruit SET name = ?, scientific_name = ? WHERE id = ? ";
    private final String CREATE_FRUITS_QUERY = "INSERT INTO fruit (name, scientific_name) VALUES(?,?) ";



    public FruitDao() {
        connection = DBConnection.getConnection();
    }

    public List<Fruit> getFruit() throws SQLException {
        ResultSet rs = connection.prepareStatement(GET_FRUITS_QUERY).executeQuery();
        List<Fruit> fruits = new ArrayList<>();

        while (rs.next()) {
            fruits.add(populateFruit(rs.getInt(1), rs.getString(2), rs.getString(3)));
        }
        return fruits;
    }

    private Fruit populateFruit(int id, String name , String scientific_name ) throws SQLException {
        return new Fruit(id, name,scientific_name );
    }

    public void deleteFruit(int id) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(DELETE_FRUITS_QUERY);
        ps.setInt(1,id);
        ps.executeUpdate();

    }
    public void updateFruit( int id, String name, String sn) throws SQLException
    {
        PreparedStatement ps = connection.prepareStatement(UPDATE_FRUITS_QUERY);
        ps.setString(1,name);
        ps.setString(2,sn);
        ps.setInt(3,id);
        ps.executeUpdate();
    }

    public void createFruit( String name, String sn) throws SQLException
    {
        PreparedStatement ps = connection.prepareStatement(CREATE_FRUITS_QUERY);
        ps.setString(1,name);
        ps.setString(2,sn);
        ps.executeUpdate();

    }


}
