package utilities;

import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class jdbcExample {
    public static void main(String[] args) throws Exception {
        DatabaseUtility.createConnection("jdbc:postgresql://157.230.48.97:5432/gmibank_db","techprodb_user","Techpro_@126");
        String query= "select * from tp_country";
      // String query1= "select * from tp_country where name='FRANCE'";
       //   Map<String,Object> mapQuery=DatabaseUtility.getRowMap(query);
       List<List<Object>> data=DatabaseUtility.getQueryResultList(query);
      //  List<Object> data= DatabaseUtility.getColumnData(query,"name");
      //  List<Map<String,Object>> data=DatabaseUtility.getQueryResultMap(query);
     //   System.out.println(data.get(0).get("name"));
     //   List<String> data=DatabaseUtility.getColumnNames(query);
      // int data=DatabaseUtility.getRowCount(query);
        System.out.println(data);

    }
}
