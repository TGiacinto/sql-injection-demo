package tuccia.sqlinjection.repository;

import java.sql.*;

import org.springframework.stereotype.Repository;
import tuccia.sqlinjection.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class UserDao {

    static final String DB_URL = "jdbc:mysql://localhost:3306/sqlInjection";
    static final String USER = "root";
    static final String PASS = "root";

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";


    public List<User> getBy(String username) {

        List<User> users = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
        ) {
            Class.forName(JDBC_DRIVER);

            String sql = "select * from user where username='" + username + "'";

            ResultSet rs = stmt.executeQuery(sql);
            // Execute a query
            while (rs.next()) {
                //Display values
                users.add(
                        User.builder()
                                .id(rs.getInt("id"))
                                .lastname(rs.getString("lastname"))
                                .username(rs.getString("username"))
                                .firstname(rs.getString("firstname"))
                                .build()
                );
            }

            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return users;
    }

}
