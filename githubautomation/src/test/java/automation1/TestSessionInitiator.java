package automation1;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Terminal.ExecuteShellCommands;
import Terminal.Utility;
import Terminal.githubTerminalAutomation;
import getPageObjects.CloneRepositoryPage;
import getPageObjects.CommitPage;
import getPageObjects.CreateNewRepositoryPage;
import getPageObjects.DeleteRepositoryPage;
import getPageObjects.signInPage;
import githubapi.githubApi;

public class TestSessionInitiator
{
	WebDriver driver;
	  
	  String url="https://github.com/login";
	  
	  public signInPage signIn;
	  public CreateNewRepositoryPage newRepo;
	  public DeleteRepositoryPage deleteRepo;
	  public CloneRepositoryPage cloneRepo;
	  public CommitPage  commitid;
	  public Utility util;
	  public githubTerminalAutomation shellscript;
	  public ExecuteShellCommands executecommands;
	  public githubApi p;
	  

	  public TestSessionInitiator()
	  {
		  webdriverInitiator();
		  testInitiator();
	  }
		  
	  	public void webdriverInitiator() {
	  		
			 driver=new FirefoxDriver();
			 driver.manage().window().maximize();
			 driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			 driver.get(url);
	  	}
	  	
		  public void _initPage()
		  {
			  
			signIn=new signInPage(driver);
			newRepo=new CreateNewRepositoryPage(driver);
			deleteRepo=new DeleteRepositoryPage(driver);
			cloneRepo=new CloneRepositoryPage(driver);
			commitid=new CommitPage(driver);
			util= new Utility();
			shellscript=new githubTerminalAutomation(driver);
			executecommands=new ExecuteShellCommands();
		    p=new githubApi();
		  }
		  public void testInitiator()
		  {
			  _initPage();
		  }
}
