package jdbctests;

import java.sql.*;

public class TestConnection {

    public static void main(String[] args) throws SQLException {

        String dbURL="jdbc:oracle:thin:@44.195.19.167:1521:XE";
        String dbUsername="hr";
        String dbPassword="hr";

        Connection connection= DriverManager.getConnection(dbURL,dbUsername,dbPassword);
        Statement statement= connection.createStatement();
        ResultSet resultSet=statement.executeQuery("SELECT  * from regions");

       while (resultSet.next()){
           System.out.println(resultSet.getString(1)+"- "+ resultSet.getString("region_name"));

       };



        resultSet.close();
        statement.close();
        connection.close();




    }

}
