package githubapi;
import java.io.IOException;

import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;


public class githubApi
{
	@SuppressWarnings("deprecation")
	public void createRepoUsingApi() {
		try {
			GitHub github = GitHub.connectUsingPassword("akhtar.nawaz4@gmail.com", "Nawaz76-");
			GHRepository repo = github.createRepository("new Repo", "initial commit", "xyz", true);
			System.out.println(repo.getUrl());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
