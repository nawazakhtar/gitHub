package getPageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommitPage
{
	WebDriver driver;
	
	@FindBy(css=".commits a")
    WebElement commitlink;
	
	@FindBy(className="js-zeroclipboard")
	private List<WebElement> commitIdsButttons;
	
	public CommitPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	public String commitIdfromUI()
  {
		driver.get("https://github.com/vibhachugh93/abc");
	    commitlink.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
  }
 
	
	   String commitID;
	   commitID= commitIdsButttons.get(0).getAttribute("data-clipboard-text");
	   
	   return commitID;
}

}
