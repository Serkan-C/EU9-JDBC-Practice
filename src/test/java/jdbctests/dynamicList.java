package jdbctests;

import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.*;

public class dynamicList {


    String dbURL = "jdbc:oracle:thin:@44.195.19.167:1521:XE";
    String dbUsername = "hr";
    String dbPassword = "hr";

    @Test
    public void test2() throws SQLException {

        Connection connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select *from departments");
        ResultSetMetaData rsmd = resultSet.getMetaData();
        int rowCount = resultSet.getRow();
        int colCount = rsmd.getColumnCount();

        List<Map<String, Object>> queryData = new ArrayList<>();
        while(resultSet.next()) {

            Map<String, Object> row = new LinkedHashMap<>();
           for (int i=1;i<=colCount;i++) {
               row.put(rsmd.getColumnName(i), resultSet.getString(i));
           }
          //  System.out.println(row.toString());

            queryData.add(row);
        }

        for (Map<String,Object> row: queryData) {
            System.out.println(row.toString());
        }


    }
}
