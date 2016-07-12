package getPageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import userinfo.RepositoryData;

public class CreateNewRepositoryPage extends DeleteRepositoryPage
{
	WebDriver driver;
	String repoName="Git_Demo";

	 
	  
	  @FindBy(css=".btn.btn-sm.btn-primary")
	  WebElement newRepository;
	  
	  @FindBy(css="#repository_name")
	  WebElement repositoryName;
	  
	  @FindBy(css="#repository_auto_init")
	  WebElement readmeCheckbox;
	  
	  @FindBy(css=".btn.btn-primary.first-in-line")
	  WebElement createRepository;
	  
	//  @FindBy(id="repository_name")
	//  WebElement is-autocheck-errored;
	  
	  @FindBy(className="is-autocheck-errored")
	  private WebElement error;
	  
	  public CreateNewRepositoryPage(WebDriver driver)
	  {
		 super(driver);
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
	  }
	  
	  public String createNewRepository(String repoName) throws InterruptedException
	  {  String homePageAfterDeletionUrl = null;
		  RepositoryData obj;
		  DeleteRepositoryPage deleteobj = null ;
		  this.newRepository.click();
		  Thread.sleep(2000);
		  obj=new RepositoryData();
		  this.repositoryName.sendKeys(obj.getNewRepositoryName());
		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		  
		  if(error.isDisplayed()==true)
		  {
		    deleteobj = new DeleteRepositoryPage(driver);
		    homePageAfterDeletionUrl = deleteobj.deleteRepo();
		    this.newRepository.click();
	      }
	      this.repositoryName.sendKeys(obj.getNewRepositoryName());
		  this.readmeCheckbox.click();
		  this.createRepository.click();
		  return driver.getCurrentUrl();
      }
}
