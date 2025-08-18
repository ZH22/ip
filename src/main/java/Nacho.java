import com.sun.source.tree.NewArrayTree;

import java.util.Scanner;

public class Nacho {
    // Visual Elements
    private static String horizontal_line = "-----------------------------------";
    private static int indent_level = 4;

    private static void greeting() {
        // Greeting
        System.out.println(horizontal_line);
        System.out.println("Hello I'm Nacho\nWhat can I do for you?");
        System.out.println(horizontal_line);
    }

    private static void reply(String message) {
        String indent = " ".repeat(indent_level);

        System.out.println(indent + horizontal_line);
        System.out.println(indent + message);
        System.out.println(indent + horizontal_line);
    }

    private static void echo() {
        // Echo ==================================
        Scanner scanner = new Scanner(System.in);
        String query = scanner.nextLine();

        while(!query.equals("bye")) {
            System.out.println(horizontal_line);
            System.out.println(query);
            System.out.println(horizontal_line);

            query = scanner.nextLine();
        }
    }


    public static void main(String[] args) {

        Nacho.greeting();

        // List Items ===================================
        Task[] todos = new Task[100];
        int total_todos = 0;

        Scanner scanner = new Scanner(System.in);
        String query = scanner.nextLine();

        while(!query.equals("bye")) {
            // Check and Uncheck =============================================
            String[] query_words = query.split(" ");

            if (query_words[0].equals("mark")) {
               int target = Integer.parseInt(query_words[1]) - 1;
               todos[target].markCompleted();

               System.out.println("Nice! I've marked this task as done:\n    " + todos[target]);
               System.out.println(horizontal_line);
               query = scanner.nextLine();
               continue;
            } else if (query_words[0].equals("unmark")) {
                int target = Integer.parseInt(query_words[1]) - 1;
                todos[target].unmarkCompleted();

                System.out.println("Nice! I've marked this task as not done yet:\n    " + todos[target]);
                System.out.println(horizontal_line);
                query = scanner.nextLine();
                continue;
            }


            // Add and List ==================================================
            if (!query.equals("list")) {
                Task new_task = new Task(query);
                todos[total_todos] = new_task;
                total_todos += 1;

                Nacho.reply("added: " + new_task.getTitle());

            } else {
                String item_list = "";
                String indent = " ".repeat(indent_level);
                for(int i = 0; i < total_todos; i++){
                    String item = String.format("%d. %s", i + 1, todos[i]);
                    item_list = item_list.concat("\n" + indent + item);
                }
                Nacho.reply("Here are the tasks in your list:" + item_list);
            }

            query = scanner.nextLine();
        }

        // ===============================================

        // Exit
        System.out.println(horizontal_line);
        System.out.println("Bye. Hope to see you soon!");
        System.out.println(horizontal_line);
    }
}
