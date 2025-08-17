import java.util.Scanner;

public class Nacho {
    public static void main(String[] args) {

        // Visual Elements
        String horizontal_line = "_____________________________________";

        // Greeting
        System.out.println(horizontal_line);
        System.out.println("Hello I'm Nacho\nWhat can I do for you?");
        System.out.println(horizontal_line);

        /* Echo ==================================
        Scanner scanner = new Scanner(System.in);
        String query = scanner.nextLine();

        while(!query.equals("bye")) {
            System.out.println(horizontal_line);
            System.out.println(query);
            System.out.println(horizontal_line);

            query = scanner.nextLine();
        }
        // End of Echo ==================================
         */

        // List Items ===================================
        String[] todos = new String[100];
        int total_todos = 0;

        Scanner scanner = new Scanner(System.in);
        String new_todo = scanner.nextLine();

        while(!new_todo.equals("bye")) {
            if (!new_todo.equals("list")) {
                todos[total_todos] = new_todo;
                total_todos += 1;

                System.out.println("added: " + new_todo);

                System.out.println(horizontal_line);
            } else {
                for(int i = 0; i < total_todos; i++){
                    String item = String.format("%d. %s", i + 1, todos[i]);
                    System.out.println(item);
                }
                System.out.println(horizontal_line);
            }

            new_todo = scanner.nextLine();
        }

        // ===============================================

        // Exit
        System.out.println(horizontal_line);
        System.out.println("Bye. Hope to see you soon!");
        System.out.println(horizontal_line);
    }
}
