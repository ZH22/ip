package Nacho.Commands;

import Nacho.ChatContext;
import Nacho.Tasks.DeadlineTask;
import Nacho.Exceptions.UserInputException;

import java.util.Arrays;

public class AddDeadlineCommand implements Command {

    @Override
    public void execute(String[] args, ChatContext context) {

        int by_index = Arrays.asList(args).indexOf("/by");

        if(by_index == -1 || by_index == args.length - 1)
            throw new UserInputException("Missing Deadline Date.\nSend 'help' for example");
        else if(by_index == 0)
            throw new UserInputException("Missing Event Title\nSend 'help' for example");

        String taskTitle = String.join(" ", Arrays.copyOfRange(args, 0, by_index));
        String byDate =  String.join(" ", Arrays.copyOfRange(args, by_index + 1, args.length));

        DeadlineTask newDeadline = new DeadlineTask(taskTitle, byDate);
        context.getTaskList().addTask(newDeadline);

        String replyMessage = "Got it. I've added this task:\n"
                + newDeadline.toString().indent(context.get_indent_level())
                + "\nNow you have " + context.getTaskList().getTotalTasks() + " tasks in the list.";

        context.reply(replyMessage);
    }
}
