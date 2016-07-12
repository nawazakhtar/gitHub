package getPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class signInPage 
{

	WebDriver driver;
	  
	  @FindBy(css="input[name='login']")
	  WebElement username;
	  
	  @FindBy(css="#password")
	  WebElement passwrd;
	  
	  @FindBy(css="input[name='commit']")
	  WebElement signBtn;
	  
	  @FindBy(className="auth-form-header")
	  private WebElement title;
	  

	  
	  public signInPage(WebDriver driver)
	  {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	  }
	  
	  
	 	public String getTitle()
	 	{
	  	String signInTitle=title.getText();
	  	System.out.println(signInTitle);
	  	return signInTitle;
	 	}
	  
	 	public String loginWithusernameandpassword(String userName,String password)
	  {
		  driver.get("https://github.com/login");
		 //String SignInTitle= driver.getTitle();
		  //System.out.println(SignInTitle);
		  this.username.sendKeys(userName);
		  this.passwrd.sendKeys(password);
		  this.signBtn.click();
		  return driver.getCurrentUrl();
		 
	 
}
}
