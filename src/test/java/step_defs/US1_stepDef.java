package step_defs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import utils.JdbcUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class US1_stepDef {


    int totalId;
    int uniqueTotalId;

    @Given("Establish the database connection")
    public void establishTheDatabaseConnection() {
        JdbcUtils.connectConnection();
    }

    @When("Execute {string} query to get total number of all IDs from users")
    public void executeQueryToGetAllIDsFromUsers(String query) throws SQLException {
        ResultSet rs = JdbcUtils.assignQuery(query);

        totalId = Integer.parseInt(JdbcUtils.getSingularValue(rs));
    }

    @When("Execute {string} query to get all unique total number IDs from users")
    public void executeQueryToGetAllUniqueTotalNumberIDsFromUsers(String query) {
        ResultSet rs = JdbcUtils.assignQuery(query);

        uniqueTotalId = Integer.parseInt(JdbcUtils.getSingularValue(rs));

    }

    @Then("verify all users has unique ID")
    public void verifyAllUsersHasUniqueID() {
        Assert.assertTrue(totalId == uniqueTotalId);

    }


    List<String> actualAllColumNames = null;

    @When("Execute {string} query to get all columns")
    public void executeQueryToGetAllColumns(String string) {
        ResultSet rs = JdbcUtils.assignQuery(string);
        actualAllColumNames = JdbcUtils.getAllColumNames(rs);
    }

    @Then("verify the below columns are listed in result:")
    public void verifyTheBelowColumnsAreListedInResult(List<String> expectedAllColumnNames) {
        Assert.assertEquals(actualAllColumNames, expectedAllColumnNames);
    }


}
