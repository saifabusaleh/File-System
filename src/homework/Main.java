package homework;

//Author: Saif abu saleh

public class Main {

	public static void main(String[] args) {
		try {
			FileSystem fs = new FileSystem();
			fs.addDir("/", "home");
			fs.addDir("home", "a");
			fs.addDir("a", "b");
			fs.addDir("b", "c");
			fs.addFile("a", "a.txt", 500);
			fs.addFile("b", "b.txt", 500);

			fs.addFile("c", "c.txt", 500);

			fs.delete("a.txt");
			fs.delete("c");

			fs.showFileSystem();

		} catch(IllegalArgumentException e) {
			System.out.println("IllegalArgumentException: " + e.getMessage());
		}
		catch(Exception e) {
			System.out.println("Exception: " + e.getMessage());

		}
	}
}
