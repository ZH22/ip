import java.util.Arrays;

public class AddEventCommand implements Command{

    @Override
    public void execute(String[] args, ChatContext context) {

        int from_index = Arrays.asList(args).indexOf("/from");
        int to_index = Arrays.asList(args).indexOf("/to");

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
