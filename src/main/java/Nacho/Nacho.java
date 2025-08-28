package Nacho;

import Nacho.Commands.*;
import Nacho.Tasks.TaskList;
import Nacho.Commands.FindCommand;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Nacho {
    public static void main(String[] args) {

        // Creating chat context
        TaskList tasklist = new TaskList(ExternalStorageController.getStore());

        // Add TaskList object to current chat's context
        ChatContext context = new ChatContext(tasklist);

        // Registering commands
        Map<String, Command> commandRegistry = new HashMap<>();
        commandRegistry.put("help", new HelpCommand());
        commandRegistry.put("todo", new AddTodoCommand());
        commandRegistry.put("deadline", new AddDeadlineCommand());
        commandRegistry.put("event", new AddEventCommand());
        commandRegistry.put("mark", new MarkTaskCommand());
        commandRegistry.put("unmark", new UnmarkTaskCommand());
        commandRegistry.put("delete", new DeleteTaskCommand());
        commandRegistry.put("list", new ListTasksCommand());
        commandRegistry.put("find", new FindCommand());


        // Creating Command dispatcher object -> will run the mapped command
        CommandDispatcher dispatcher = new CommandDispatcher(commandRegistry);

        // Greet the user
        context.reply("Hello I'm Nacho\nWhat can I do for you?");

        Scanner scanner = new Scanner(System.in);
        String query = scanner.nextLine();

        while (!query.equals("bye")) {

            // Handle incoming command
            dispatcher.dispatch(query, context);

            query = scanner.nextLine();
        }

        // Bye Message
        context.reply("Bye. Hope to see you soon!");
    }
}