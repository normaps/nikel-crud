package repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersRepository {

    private Connection conn;

    public UsersRepository() {
        this.conn = connectDB();
    }

    public boolean create(String firstName, String lastName) {
        String sql = "INSERT INTO USERS (first_name, last_name) values (?, ?)";
        try {
            PreparedStatement preparedStmt = this.conn.prepareStatement(sql);
            preparedStmt.setString(1, firstName);
            preparedStmt.setString(2, lastName);
            return preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(String id, String firstName, String lastName) {
        String sql = "UPDATE USERS SET first_name = ?, last_name = ? WHERE id = ?";
        try {
            PreparedStatement preparedStmt = this.conn.prepareStatement(sql);
            preparedStmt.setString(1, firstName);
            preparedStmt.setString(2, lastName);
            preparedStmt.setString(3, id);
            return preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(String id) {
        String sql = "DELETE FROM USERS WHERE id = ?";
        try {
            PreparedStatement preparedStmt = this.conn.prepareStatement(sql);
            preparedStmt.setString(1, id);
            return preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ResultSet findById(String id) {
        String sql = "SELECT * FROM USERS WHERE id = ?";
        try {
            PreparedStatement preparedStmt = this.conn.prepareStatement(sql);
            preparedStmt.setString(1, id);
            return preparedStmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Connection connectDB() {
        String dbURL = "jdbc:mysql://localhost:3306/nikel";
        String username = "root";
        String password = "secret";

        try {
            Connection conn = DriverManager.getConnection(dbURL, username, password);

            if (conn != null) {
                System.out.println("Connected");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return conn;
    }

}
