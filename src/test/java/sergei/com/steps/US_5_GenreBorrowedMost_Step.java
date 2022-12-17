package sergei.com.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import sergei.utility.DB_Util;

public class US_5_GenreBorrowedMost_Step {
  String actualGenre;

  /*  @Given("Establish the database connection")
    public void establish_the_database_connection() {
        // that step finished by hook class with custom @After (@db) annotation
    }

   */
    @When("I execute query to find most popular book genre")
    public void i_execute_query_to_find_most_popular_book_genre() {
      DB_Util.runQuery("select book_categories.name, count(*)\n" +
              "from book_categories\n" +
              "         inner join books on book_categories.id = books.book_category_id\n" +
              "         inner join book_borrow on books.id = book_borrow.book_id\n" +
              "group by book_categories.name order by 2 desc ;");

       actualGenre = DB_Util.getCellValue(1,1);
      System.out.println("data from DB = " + actualGenre);



    }
    @Then("verify {string} is the most popular book genre.")
    public void verify_is_the_most_popular_book_genre(String expectedGenre) {

      Assert.assertEquals(expectedGenre, actualGenre);

    }




}
