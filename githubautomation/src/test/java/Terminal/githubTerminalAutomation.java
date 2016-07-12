package Terminal;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import getPageObjects.signInPage;
import getPageObjects.CreateNewRepositoryPage;

public class githubTerminalAutomation
{
	File file;
	public FileWriter fw;
	public BufferedWriter bw;
	WebDriver driver;
	public String sys_user;

	public String sys;
	public Process p;
	public githubTerminalAutomation(WebDriver driver)
	{
		this.driver=driver;
	    PageFactory.initElements(driver, this);
		}
		

		@FindBy(css=".form-control.js-git-clone-help-field.url-field.js-zeroclipboard-target")
		WebElement cloneurl;
		
		public void createShellFile() throws IOException{
			file = new File("executor.sh");
			file.createNewFile();
		    file.setExecutable(true);
		    file.setWritable(true);
			fw = new FileWriter(file.getAbsoluteFile());
			bw = new BufferedWriter(fw);	
			sys_user=System.getProperty("user.name");
		    System.out.println(sys_user);
		    sys=System.getProperty("os.name");
		    System.out.println(sys);
		}
		public void execute() throws IOException, InterruptedException{
			 if(sys.equalsIgnoreCase("Linux"))
			 {
				String repname=Utility.getConfigValue("repository");
				String url=cloneurl.getAttribute("value");
				String user=Utility.getConfigValue("usernamescript");
				String pass=Utility.getConfigValue("passwordscript");
				System.out.println(file.canWrite());
				System.out.println(file.canExecute());
				System.out.println(url);
				bw.write("#!/bin/bash");
				bw.write("cd ~");
				bw.write("git clone "+url);
				bw.write("cd "+repname);
				bw.write("gedit >'Hello'");
				bw.write("git status");
				bw.write("git add .");
				bw.write("git commit -m'First Commit'");
				bw.write("git status");
				bw.write("git push http://"+user+":"+pass+"@github.com/"+user+"/"+repname+".git master");
				bw.close();
			}
			else
			{
			 	PrintWriter writer;
		    	file = new File("executor.bat");
		    	file.createNewFile();
		        file.setExecutable(true);
		        file.setWritable(true);
		        writer = new PrintWriter(fw);
		       	String repname=Utility.getConfigValue("repository");
		        String url=cloneurl.getAttribute("value");
		        String user=Utility.getConfigValue("usernamescript");
		        String pass=Utility.getConfigValue("passwordscript");
		        writer.println("C:");
		        writer.println("cd users");
		        writer.println("cd "+sys_user);
		        writer.println("cd Desktop");
		        writer.println("git clone "+url);
		        writer.println("cd "+repname);
		        writer.println("type nul > hello");
		        writer.println("git add .");
		        writer.println("git status");
		        writer.println("git commit -m 'First Commit'");
		        writer.println("git status");
		        writer.println("git push http://"+user+":"+pass+"@github.com/"+user+"/"+repname+".git");
		        writer.close();	
		        p=new ProcessBuilder("./executor.bat").start();
		        p.waitFor();
		    }
	    }

}
