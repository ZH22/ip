import java.util.Scanner;

public class Nacho {
    public static void main(String[] args) {

        // Visual Elements
        String horizontal_line = "_____________________________________";

        // Greeting
        System.out.println(horizontal_line);
        System.out.println("Hello I'm Nacho\nWhat can I do for you?");
        System.out.println(horizontal_line);

        // Echo
        Scanner scanner = new Scanner(System.in);
        String query = scanner.nextLine();

        while(!query.equals("bye")) {
            System.out.println(horizontal_line);
            System.out.println(query);
            System.out.println(horizontal_line);

            query = scanner.nextLine();
        }

        // Exit
        System.out.println(horizontal_line);
        System.out.println("Bye. Hope to see you soon!");
        System.out.println(horizontal_line);
    }
}
