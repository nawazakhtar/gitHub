package getPageObjects;


import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import userinfo.RepositoryData;

public class CloneRepositoryPage
{
	WebDriver driver;
	  
	  @FindBy(css="button[title='Clone or download this repository']")
	  WebElement cloneButton;
	  
	  @FindBy(className="js-zeroclipboard")
	  private List<WebElement> clipBoardButtons;
	  
	  @FindBy(className="form-control")
	  private List<WebElement> clipBoardText;
	  
	  //@FindBy(css=".form-control.input-monospace.input-sm.js-zeroclipboard-target.js-url-field")
	  //WebElement getRepoUrl;
	  
	  public CloneRepositoryPage(WebDriver driver)
	  {
		  this.driver=driver;
			PageFactory.initElements(driver, this);
	  }
	  
	  public String CloneRepository() throws IOException
	  {
		  RepositoryData obj=new RepositoryData();
		  this.cloneButton.click();
		  clipBoardButtons.get(0).click();   //copy url to clone git repository 
		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		  String cloneLink=clipBoardText.get(5).getAttribute("value"); // get the url of repository
		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		  System.out.println("Clone Link"+cloneLink);
		  File clonedrepo= new File("/home/nawazakhtar/Desktop/"+obj.getNewRepositoryName());
		  clonedrepo.createNewFile();
		  return cloneLink;
		  
		  
	  }
}
