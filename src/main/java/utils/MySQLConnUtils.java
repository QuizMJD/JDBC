package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnUtils {
    // Kết nối vào MySQL.
    public static Connection getMySQLConnection() throws SQLException,
            ClassNotFoundException {
        String hostName = "localhost";

        String dbName = "learningJDBC";
        String userName = "root";
        String password = "123456";

        return getMySQLConnection(hostName, dbName, userName, password);
    }

    public static Connection getMySQLConnection(String hostName, String dbName,
                                                String userName, String password) throws SQLException, ClassNotFoundException {
        // Khai báo class Driver cho DB MySQL
        // Việc này cần thiết với Java 5, Java 6 tự động tìm kiếm Driver thích hợp.
        // Nếu dùng Java6, thì ko cần dòng này cũng được.
//        Class.forName("com.mysql.jdbc.Driver");

        // Cấu trúc URL Connection dành cho mysql: jdbc:mysql://localhost:3306/learningJDBC
        String connectionURL = "jdbc:mysql://" + hostName + ":3306/" +dbName+ "?useSSL=false";

        Connection conn = DriverManager.getConnection(connectionURL, userName, password);
        return conn;
    }
}
