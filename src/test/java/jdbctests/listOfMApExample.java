package jdbctests;

import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.*;

public class listOfMApExample {

    String dbURL = "jdbc:oracle:thin:@44.195.19.167:1521:XE";
    String dbUsername = "hr";
    String dbPassword = "hr";

    @Test
    public void test1() {

        List<Map<String, Object>> queryData = new ArrayList<>();

        Map<String, Object> row1 = new HashMap<>();
        row1.put("first_name", "stevens");
        row1.put("last_name", "king");
        row1.put("salary", 24000);
        row1.put("job_id", "ad-press");
        System.out.println(row1.toString());


        Map<String, Object> row2 = new HashMap<>();
        row2.put("first_name", "neena");
        row2.put("last_name", "kochhar");
        row2.put("salary", 17000);
        row2.put("job_id", "ad_VP");
        System.out.println(row2.toString());
        queryData.add(row1);
        queryData.add(row2);

        System.out.println("queryData.get(0).get(\"last_name\") = " + queryData.get(0).get("last_name"));
        System.out.println("queryData.get(1).get(\"salary\") = " + queryData.get(1).get("salary"));


    }

    @Test
    public void test2() throws SQLException {

        Connection connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select FIRST_NAME,LAST_NAME,SALARY,EMPLOYEE_ID\n" +
                "from EMPLOYEES\n" +
                "where ROWNUM<6");
        ResultSetMetaData rsmd = resultSet.getMetaData();
        resultSet.next();
        List<Map<String, Object>> queryData = new ArrayList<>();

        Map<String, Object> row1 = new HashMap<>();
        row1.put(rsmd.getColumnName(1), resultSet.getString(1));
        row1.put(rsmd.getColumnName(2), resultSet.getString(2));
        row1.put(rsmd.getColumnName(3), resultSet.getString(3));
        row1.put(rsmd.getColumnName(4), resultSet.getString(4));

        System.out.println(row1.toString());

        resultSet.next();
        Map<String, Object> row2 = new HashMap<>();

        row2.put(rsmd.getColumnName(1), resultSet.getString(1));
        row2.put(rsmd.getColumnName(2), resultSet.getString(2));
        row2.put(rsmd.getColumnName(3), resultSet.getString(3));
        row2.put(rsmd.getColumnName(4), resultSet.getString(4));
        System.out.println(row2.toString());


        queryData.add(row1);
        queryData.add(row2);

        System.out.println("queryData.get(0).get(\"last_name\") = " + queryData.get(0).get("last_name"));
        System.out.println("queryData.get(1).get(\"salary\") = " + queryData.get(1).get("salary"));

        //DynamicList



        resultSet.close();
        statement.close();
        connection.close();

    }


}
