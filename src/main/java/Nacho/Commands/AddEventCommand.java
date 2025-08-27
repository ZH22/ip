package Nacho.Commands;

import Nacho.ChatContext;
import Nacho.Tasks.EventTask;
import Nacho.Exceptions.UserInputException;

import java.util.Arrays;

public class AddEventCommand implements Command {

    @Override
    public void execute(String[] args, ChatContext context) {


        int from_index = Arrays.asList(args).indexOf("/from");
        int to_index = Arrays.asList(args).indexOf("/to");

        if(args.length == 0 || from_index == -1 || to_index == -1)
            throw new UserInputException("Missing arguments!\nSee 'help' for more info");
        else if(from_index == 0)
            throw new UserInputException("Missing Event Title!!!");
        else if(to_index == args.length - 1)
            throw new UserInputException("Missing Event End Timing!");
        else if(to_index - from_index == 1)
            throw new UserInputException("Missing Event Start Timing");

        String taskTitle = String.join(" ", Arrays.copyOfRange(args, 0, from_index));
        String fromDate =  String.join(" ", Arrays.copyOfRange(args, from_index + 1, to_index));
        String toDate =  String.join(" ", Arrays.copyOfRange(args, to_index + 1, args.length));

        EventTask newEvent = new EventTask(taskTitle, fromDate, toDate);
        context.getTaskList().addTask(newEvent);

        String replyMessage = "Got it. I've added this task:\n"
                + newEvent.toString().indent(context.get_indent_level())
                + "\nNow you have " + context.getTaskList().getTotalTasks() + " tasks in the list.";

        context.reply(replyMessage);
    }
}
