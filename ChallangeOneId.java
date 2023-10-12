package spaceCadetsProjectOne;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ChallangeOneId {

	public static void main(String[] args) throws IOException {
		// BufferedReader object as instructed to get user input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter user ID:");
		String userId = br.readLine();
		// initialise the url object
		String webAdress = "https://www.ecs.soton.ac.uk/people/" + userId;
		URL url = new URL(webAdress);
		// ensure connection
		HttpURLConnection hurl = (HttpURLConnection) url.openConnection();
		hurl.setRequestMethod("GET");
		// another BufferedReader object to read the content of the web page
		BufferedReader webPage = new BufferedReader(new InputStreamReader(hurl.getInputStream()));

		boolean isFound = false;
		String line = webPage.readLine();
		// String mustNotContain = ;
		// StringBuilder name = new StringBuilder();
		String toBeDeleted = "| University of Southampton";
		int toBeDeletedLength = toBeDeleted.length();

		while (line != null) {
			if (line.contains("<title>")) {
				// two new int values to locate persons name extract it
				int start = line.indexOf("<title>") + "<title>".length();
				int end = line.indexOf("</title>", start);
				String name = line.substring((start), (end - toBeDeletedLength));
	                System.out.println("Person found: " + name);
	                isFound = true;
	                break;
	            }
	            line = webPage.readLine();

		}
		if (!isFound) {
			System.out.println("There is no such person");
		}

	}

}
