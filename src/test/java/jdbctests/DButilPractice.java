package jdbctests;

import org.junit.jupiter.api.Test;
import utilities.DBUtilities;

import java.util.List;
import java.util.Map;

public class DButilPractice {
    /* when I use DBUtilities this information then its work.
    normaly DBUtilities Use Configuration properties to have this information
    String dbUrl="jdbc:oracle:thin:@44.195.19.167:1521:XE";
        String dbUsername="hr";
        String dbPassword="hr";
     */

    @Test
    public void test1(){

        DBUtilities.createConnection();

        String query="select FIRST_NAME,LAST_NAME,SALARY,EMPLOYEE_ID from EMPLOYEES where ROWNUM<6";

       List<Map<String,Object>> queryData=DBUtilities.getQueryResultMap(query);

        for (Map<String,Object> row:queryData    ) {
            System.out.println(row.toString());
        }
DBUtilities.destroy();
    }
    @Test
    public void test2(){

        DBUtilities.createConnection();

        String query="select FIRST_NAME,LAST_NAME,SALARY,EMPLOYEE_ID from EMPLOYEES where ROWNUM<2";

        Map<String,Object> rowMap=DBUtilities.getRowMap(query);


            System.out.println(rowMap.toString());

        DBUtilities.destroy();
    }

}
