import com.sun.source.tree.NewArrayTree;
import jdk.jfr.Event;

import java.util.Scanner;

public class Nacho {

    // Data Structures
    private static TaskList tasklist = new TaskList();

    // Visual Elements
    private static String horizontal_line = "-----------------------------------";
    private static int indent_level = 4;

    private static void NachoSays(String message) {
        String styled_message = (horizontal_line + "\n" + message + "\n" + horizontal_line).indent(indent_level);
        System.out.print(styled_message);
    }

    private static void greeting() {
        // Greeting
        NachoSays("Hello I'm Nacho\nWhat can I do for you?");
    }

    private static void exit() {
        // Goodbye Message
        NachoSays("Bye. Hope to see you soon!");
    }

    private static void echo() {
        // Echo ==================================
        Scanner scanner = new Scanner(System.in);
        String query = scanner.nextLine();

        while(!query.equals("bye")) {
            NachoSays(query);
            query = scanner.nextLine();
        }
    }

    private static void addTaskToList(Task newTask) {
        tasklist.addTask(newTask);
        String replyMessage = "Got it. I've added this task:\n"
                + newTask.toString().indent(indent_level)
                + "\nNow you have " + tasklist.getTotalTasks() + " tasks in the list.";
        NachoSays(replyMessage);
    }

    public static void main(String[] args) {

        // Reused variables in case (a lil ugly)
        String replyMessage;
        int target_index;
        Task targetTask;
        String taskTitle;
        // ================================

        Nacho.greeting();

        // Command Loop
        Scanner scanner = new Scanner(System.in);
        String query = scanner.nextLine();

        while(!query.equals("bye")) {

            // Get command
            String[] query_words = query.split(" ");

            String command = query_words[0];

            switch(command) {
                case "list":
                    String listMessage = "Here are your tasks in your list:\n" + tasklist;
                    NachoSays(listMessage);
                    break;

                case "todo":
                    taskTitle = query.replace("todo ", "");
                    TodoTask newTodo = new TodoTask(taskTitle);
                    Nacho.addTaskToList(newTodo);
                    break;

                case "deadline":
                    taskTitle = query.substring(0, query.indexOf("/by") - 1).replace("deadline ", "");
                    String byDate = query.substring(query.indexOf("/by")).replace("/by ", "");
                    DeadlineTask newDeadline = new DeadlineTask(taskTitle, byDate);
                    Nacho.addTaskToList(newDeadline);
                    break;

                case "event":
                    taskTitle = query.substring(0, query.indexOf("/from") - 1).replace("event ", "");
                    String fromDate = query.substring(query.indexOf("/from"), query.indexOf("/to") - 1)
                            .replace("/from ", "");
                    String toDate = query.substring(query.indexOf("/to ")).replace("/to ", "");
                    EventTask newEvent = new EventTask(taskTitle, fromDate, toDate);
                    Nacho.addTaskToList(newEvent);
                    break;

                case "mark":
                    target_index = Integer.parseInt(query_words[1]) - 1;
                    targetTask = tasklist.getTask(target_index);
                    targetTask.markCompleted();

                    replyMessage = "Nice! I've marked this task as done:\n"
                            + targetTask.toString().indent(indent_level);
                    NachoSays(replyMessage);
                    break;

                case "unmark":
                    target_index = Integer.parseInt(query_words[1]) - 1;
                    targetTask = tasklist.getTask(target_index);
                    targetTask.unmarkCompleted();
                    replyMessage = "OK, I've marked this task as not done yet:\n"
                            + targetTask.toString().indent(indent_level);
                    NachoSays(replyMessage);
                    break;
                default:
                    NachoSays("Sorry I don't know this command");
            }

            query = scanner.nextLine();
        }

        Nacho.exit();
    }
}
