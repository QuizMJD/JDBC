package query;

import sun.usagetracker.UsageTrackerClient;
import utils.MySQLConnUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryDataEmployee {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // Lấy ra đối tượng Connection kết nối vào DB.
        Connection connection = MySQLConnUtils.getMySQLConnection();

        // Tạo đối tượng Statement.
        Statement statement = connection.createStatement();

        String sql = "Select Emp_Id, Emp_No, Emp_Name, hire_Date from Employee";
        


        // Thực thi câu lệnh SQL trả về đối tượng ResultSet.
        ResultSet rs = statement.executeQuery(sql);

        // Duyệt trên kết quả trả về.
        while (rs.next()) {// Di chuyển con trỏ xuống bản ghi kế tiếp.
            int empId = rs.getInt(1);
            String empNo = rs.getString(2);
            String empName = rs.getString("Emp_Name");
            String hireDate= rs.getString("hire_date");
            System.out.println("--------------------");
            System.out.println("EmpId:" + empId);
            System.out.println("EmpNo:" + empNo);
            System.out.println("EmpName:" + empName);
            System.out.println("HireDate:" +hireDate);
        }
        // Đóng kết nối
        connection.close();
    }
}
