package Nacho.Commands;

import Nacho.ChatContext;
import Nacho.Exceptions.UserInputException;
import Nacho.Tasks.TodoTask;

/**
 * Parses User Input and adds new TodoTask if valid
 */
public class AddTodoCommand implements Command {

    @Override
    public void execute(String[] args, ChatContext context) {

        // Error when user doesnt provide task tile
        if (args.length == 0) {
            throw new UserInputException("Missing Todo item title!\n"
                    + "Tell me what you want to do x_x don't leave it blank");
        }

        String taskTitle = String.join(" ", args);

        TodoTask newTodo = new TodoTask(taskTitle);
        context.getTaskList().addTask(newTodo);
        String replyMessage = "Got it. I've added this task:\n"
                + newTodo.toString().indent(context.getIndentLevel())
                + "\nNow you have " + context.getTaskList().getTotalTasks() + " tasks in the list.";

        context.reply(replyMessage);
    }
}
