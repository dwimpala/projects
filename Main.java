import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static Scanner input = new Scanner(System.in);
	public static AlbumLinkedList list = new AlbumLinkedList();

	public static void main(String[] args) throws Exception {
		while (true) {
			int choice = displayMenu();
			if (choice < 8 && choice > 0) {
				System.out.println("Your choice: " + choice);
			} else if (choice == 8) {
				break;
			} else {
				System.out.println("Wrong input!");
				continue;
			}
			switch (choice) {
			case 1:
				add();
				break;
			case 2:
				remove();
				break;
			case 3:
				display();
				break;
			case 4:
				search();
				break;
			case 5:
				list();
				break;
			case 6:
				save();
				break;
			case 7:
				load();
				break;
			}
		}
		System.out.println("Bye!");
	}

	private static void load() throws Exception {
		System.out.println("Input name of the file to be loaded: ");
		Path filePath = new File(input.nextLine()).toPath();
		Charset charset = Charset.defaultCharset();
		ArrayList<String> stringList = (ArrayList<String>) Files.readAllLines(filePath, charset);
		String[] stringArray = stringList.toArray(new String[] {});
		for (String line : stringArray) {
			Album temp = parseAlbumString(line);
			list.add(temp);
		}
		System.out.println("Loaded!");
	}

	public static void save() throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(new FileOutputStream("albums.txt"));
		for (Album a : list)
			pw.println(a.toString());
		pw.close();
	}

	private static void list() {
		System.out.println("Enter genre of the album to be listed: ");
		String genre = input.nextLine();
		int flag = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).genre.equalsIgnoreCase(genre)) {
				System.out.println(list.get(i).toString());
				flag = 1;
			}
		}
		if (flag == 0) {
			System.out.println("There isn't any album found with that genre.");
		}
	}

	private static void search() {
		System.out.println("Enter title of the album for searching: ");
		String title = input.nextLine();
		int flag = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).title.equalsIgnoreCase(title)) {
				System.out.println(list.get(i).toString());
				flag = 1;
			}
		}
		if (flag == 0) {
			System.out.println("Not found!");
		} else {
			System.out.println("Found!");
		}
	}

	private static void display() {
		for (Album a : list) {
			System.out.println(a.toString());
		}
		System.out.println("Total time: " + list.getTotalTime());
	}

	private static void remove() {
		System.out.println("Enter title of the album for removing: ");
		String title = input.nextLine();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).title.equalsIgnoreCase(title)) {
				list.remove(i);
			}
		}
		System.out.println("Removed!");
	}

	private static void add() {
		System.out.println("Add information for adding: ");
		String inputString = input.nextLine();
		Album temp = parseAlbumString(inputString);
		if(temp == null){
			return;
		}
		list.add(temp);
		System.out.println("Added!");
	}

	private static Album parseAlbumString(String inputString) {
		String infos[] = inputString.split(", ");
		if(infos.length != 5){
			System.out.println("Input is not valid.");
			return null;
		}
		Album temp = new Album(infos[0], infos[1], infos[2], infos[3], infos[4]);
		return temp;
	}

	public static int displayMenu() {
		System.out.println();
		System.out.println("1. Add");
		System.out.println("2. Remove");
		System.out.println("3. Display");
		System.out.println("4. Search");
		System.out.println("5. List");
		System.out.println("6. Save");
		System.out.println("7. Load");
		System.out.println("8. Exit");
		return Integer.parseInt(input.nextLine());
	}
}
