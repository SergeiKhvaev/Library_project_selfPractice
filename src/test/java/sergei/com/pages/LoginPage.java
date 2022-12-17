package sergei.com.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sergei.utility.Driver;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(id = "inputEmail")
    public WebElement emailAddressInput;

    @FindBy(id = "inputPassword")
    public WebElement passwordInput;


    @FindBy (xpath = "//button[.='Sign in']")
    public WebElement submitButton;

    public void login(String username, String password){
        emailAddressInput.sendKeys(username);
        passwordInput.sendKeys((password));
        submitButton.click();

    }

}
