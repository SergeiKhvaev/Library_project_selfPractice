package sergei.com.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import sergei.utility.DB_Util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class US_1_UserInfoStoredInDB_Step {
    List<String> listOfId;
    int countOfId;
    List <String> actualColumnsName;
    @When("Execute query to get all IDs from users")
    public void execute_query_to_get_all_i_ds_from_users() {
        DB_Util.runQuery("select distinct id from users");
        listOfId = DB_Util.getColumnDataAsList(1);
        countOfId = listOfId.size();
        System.out.println("count of users ID = " + countOfId);

    }

    @Then("verify all users has unique ID")
    public void verify_all_users_has_unique_id() {
        Set<String> setOfId = new HashSet<>(listOfId);
        int countUniqueId = setOfId.size();
        System.out.println("count of UNIQUE users ID = " + countUniqueId);
        Assert.assertEquals(countOfId, countUniqueId);

    }

    @When("Execute query to get all columns")
    public void execute_query_to_get_all_columns() {

        DB_Util.runQuery("select * from users");
        actualColumnsName = DB_Util.getAllColumnNamesAsList();

    }
    @Then("verify the below columns are listed in result")
    public void verify_the_below_columns_are_listed_in_result(List <String> expectedColunmsName) {


for (String eachColumnName : actualColumnsName){
    System.out.println(eachColumnName);
    // Assertion of columns name

    Assert.assertEquals(actualColumnsName,expectedColunmsName);


}
    }



}
