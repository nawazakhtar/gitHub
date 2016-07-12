package Terminal;

import java.io.IOException;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;

public class ExecuteShellCommands
{
	int iExitValue;
	public void execute() {
    DefaultExecutor oDefaultExecutor = new DefaultExecutor();
	CommandLine oCmdLine = new CommandLine("./executor.sh");
	try {
		  oDefaultExecutor.execute(oCmdLine);
				
		} 
	catch (IOException e) 
	{
		e.printStackTrace();
	}
	
		}
}
