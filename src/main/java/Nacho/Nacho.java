package Nacho;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import Nacho.Commands.AddDeadlineCommand;
import Nacho.Commands.AddEventCommand;
import Nacho.Commands.AddTodoCommand;
import Nacho.Commands.Command;
import Nacho.Commands.CommandDispatcher;
import Nacho.Commands.DeleteTaskCommand;
import Nacho.Commands.FindCommand;
import Nacho.Commands.HelpCommand;
import Nacho.Commands.ListTasksCommand;
import Nacho.Commands.MarkTaskCommand;
import Nacho.Commands.SortCommand;
import Nacho.Commands.UnmarkTaskCommand;
import Nacho.Tasks.TaskList;

/**
 * Main class of Nacho Chatbot
 * Task Tracking tool based on commands from CLI input
 */
public class Nacho {

    private TaskList taskList;
    private ChatContext context;
    private Map<String, Command> commandRegistry = new HashMap<>();
    private CommandDispatcher dispatcher;

    /**
     * Nacho Bot Constructor
     * @param chatType Either "GUI" or "CLI" to provide chat context
     */
    public Nacho(UiType chatType) {
        assert chatType != null;

        // Creating chat context
        taskList = new TaskList(ExternalStorageController.getStore());

        // Add TaskList object to current chat's context
        context = new ChatContext(taskList, chatType);

        // Registering commands
        commandRegistry.put("help", new HelpCommand());
        commandRegistry.put("todo", new AddTodoCommand());
        commandRegistry.put("deadline", new AddDeadlineCommand());
        commandRegistry.put("event", new AddEventCommand());
        commandRegistry.put("mark", new MarkTaskCommand());
        commandRegistry.put("unmark", new UnmarkTaskCommand());
        commandRegistry.put("delete", new DeleteTaskCommand());
        commandRegistry.put("list", new ListTasksCommand());
        commandRegistry.put("find", new FindCommand());
        commandRegistry.put("sort", new SortCommand());

        // Creating Command dispatcher object -> will run the mapped command
        dispatcher = new CommandDispatcher(commandRegistry);
    }


    public static void main(String[] args) {

        // Greet the user
        Nacho nacho = new Nacho(UiType.CLI);
        nacho.context.reply("Hello I'm Nacho\nWhat can I do for you?");

        Scanner scanner = new Scanner(System.in);
        String query = scanner.nextLine();

        while (!query.equals("bye")) {

            // Handle incoming command
            nacho.dispatcher.dispatch(query, nacho.context);

            query = scanner.nextLine();
        }

        // Bye Message
        nacho.context.reply("Bye. Hope to see you soon!");
    }

    /**
     * For GUI Usage
     * @param query user input command text
     * @return reply message from Nacho Bot
     */
    public String handleQuery(String query) {
        this.dispatcher.dispatch(query, this.context);
        return this.context.getLatestReply();
    }
}
