package Nacho.Commands;

import Nacho.ChatContext;
import Nacho.Tasks.EventTask;
import Nacho.Exceptions.UserInputException;

import java.util.Arrays;

public class AddEventCommand implements Command {

    @Override
    public void execute(String[] args, ChatContext context) {


        int fromIndex = Arrays.asList(args).indexOf("/from");
        int toIndex = Arrays.asList(args).indexOf("/to");

        if (args.length == 0 || fromIndex == -1 || toIndex == -1) {
            throw new UserInputException("Missing arguments!\nSee 'help' for more info");
        } else if (fromIndex == 0) {
            throw new UserInputException("Missing Event Title!!!");
        } else if (toIndex == args.length - 1) {
            throw new UserInputException("Missing Event End Timing!");
        } else if (toIndex - fromIndex == 1) {
            throw new UserInputException("Missing Event Start Timing");
        }

        String taskTitle = String.join(" ", Arrays.copyOfRange(args, 0, fromIndex));
        String fromDate =  String.join(" ", Arrays.copyOfRange(args, fromIndex + 1, toIndex));
        String toDate =  String.join(" ", Arrays.copyOfRange(args, toIndex + 1, args.length));

        EventTask newEvent = new EventTask(taskTitle, fromDate, toDate);
        context.getTaskList().addTask(newEvent);

        String replyMessage = "Got it. I've added this task:\n"
                + newEvent.toString().indent(context.get_indent_level())
                + "\nNow you have " + context.getTaskList().getTotalTasks() + " tasks in the list.";

        context.reply(replyMessage);
    }
}
