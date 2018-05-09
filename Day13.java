import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Day13 {
	public static void main(String[] args) {
		String site = "http://cs.coloradocollege.edu/~mwhitehead/courses/2017_2018/CP222/Assignments/10/test.txt";
		if(args.length != 1) {
			site = args[0];
		}
		Scanner scanner = null;
		try {
			scanner = Utils.pullText(new URL(site));
		} catch (MalformedURLException e) {
			System.out.println("Malformed URL: " + site);
			System.exit(1);
			return;
		}
		MyGraph graph = null;
		for(int j = 0; scanner.hasNextLine(); j++) {
			String[] line = scanner.nextLine().split(" ");
			if(graph == null) {
				graph = new MyGraph(line.length); // we assume the length and the height
			} 									  // of the file are the same.
			for(int i = 0; i < line.length; i++) {
				if(line[i].equals("1")) {
					graph.link(i, j);
				}
			}
		}
		
	}
}