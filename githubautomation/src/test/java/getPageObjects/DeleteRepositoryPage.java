package getPageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import userinfo.RepositoryData;

public class DeleteRepositoryPage
{
	WebDriver driver;
	 
	 @FindBy(className="js-selected-navigation-item")
	 private List<WebElement> deleteRepolinks;
	 
	 @FindBy(className="boxed-action")
	 private List<WebElement> dangerButtonsOnSettingsPage;
	 
	 @FindBy(name="verify")
	 private List<WebElement> deleteRepoTextBox;
	 	
	 @FindBy(className="btn-danger")
	 private List<WebElement> deleteIUnderStandButtons;
	  
	 
	 
	 
	 public DeleteRepositoryPage(WebDriver driver)
	 {
		 this.driver=driver;
	     PageFactory.initElements(driver, this);
	 }
	 
	 public String deleteRepo()
	 {
		 RepositoryData obj=new RepositoryData();
		 driver.navigate().to("https://github.com/vibhachugh93/"+obj.getNewRepositoryName());
		//driver.navigate().to("https://github.com/vibhachugh93/abc1");
		 deleteRepolinks.get(8).click(); //this will click on the settings button of existing repository
	     driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
	     dangerButtonsOnSettingsPage.get(2).click();
	     driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	     RepositoryData repoInfo=new RepositoryData();
	     deleteRepoTextBox.get(2).sendKeys(repoInfo.getNewRepositoryName());
	     driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	     deleteIUnderStandButtons.get(6).click();
	     driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
	     return driver.getCurrentUrl();
	     
		 
		 
	 }

}
