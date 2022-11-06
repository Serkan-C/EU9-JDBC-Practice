package jdbctests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.*;

public class jdbc_examples {


    String dbURL="jdbc:oracle:thin:@44.195.19.167:1521:XE";
    String dbUsername="hr";
    String dbPassword="hr";

    @Test
    public void test1() throws SQLException {
        Connection connection= DriverManager.getConnection(dbURL,dbUsername,dbPassword);
        Statement statement= connection.createStatement();
        ResultSet resultSet=statement.executeQuery("SELECT  * from departments");

        resultSet.next();
        while (        resultSet.next()){
            System.out.println( resultSet.getString(1)+"-"+resultSet.getString(2)+"-"+resultSet.getString(3)+"-"+resultSet.getString(4));

        }
        ResultSet resultSet2=statement.executeQuery("SELECT  * from regions");

        while (        resultSet2.next()){
            System.out.println( resultSet2.getString(1)+"-"+resultSet2.getString(2));

        }


        resultSet.close();
        statement.close();
        connection.close();
    }
  @DisplayName("Department Names")
    @Test
    public void test2() throws SQLException {
        Connection connection= DriverManager.getConnection(dbURL,dbUsername,dbPassword);
        Statement statement= connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet=statement.executeQuery("SELECT  * from departments");

        resultSet.last();
        int rowCount=resultSet.getRow();
        System.out.println("rowCount = " + rowCount);
        resultSet.beforeFirst();
while (resultSet.next()){
    System.out.println( resultSet.getString(2));
}



        resultSet.close();
        statement.close();
        connection.close();
    }
    @Test
    public void test3() throws SQLException {
        Connection connection= DriverManager.getConnection(dbURL,dbUsername,dbPassword);
        Statement statement= connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet=statement.executeQuery("SELECT  * from departments");

        DatabaseMetaData databaseMetaData= connection.getMetaData();
        System.out.println(databaseMetaData.getUserName());
        System.out.println(databaseMetaData.getDatabaseProductName());
        System.out.println(databaseMetaData.getDatabaseProductVersion());
        System.out.println(databaseMetaData.getDriverName());
        System.out.println(databaseMetaData.getDriverVersion());

        ResultSetMetaData rsMetaData=resultSet.getMetaData();
        int colCount=rsMetaData.getColumnCount();
        System.out.println(colCount);

        System.out.println("rsMetaData.getColumnName(1) = " + rsMetaData.getColumnName(1));
for (int i=1;i<=colCount;i++){
    System.out.println(rsMetaData.getColumnName(i));
        }


        resultSet.close();
        statement.close();
        connection.close();
    }


}
