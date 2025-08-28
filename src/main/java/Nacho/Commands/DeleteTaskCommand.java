package Nacho.Commands;

import Nacho.ChatContext;
import Nacho.Tasks.Task;
import Nacho.Exceptions.UserInputException;

/**
 * Deletes Task from TaskList specified by position of task in list
 */
public class DeleteTaskCommand implements Command {

    @Override
    public void execute(String[] args, ChatContext context) {
        if (args.length == 0) {
            throw new UserInputException("Require index number of task to delete");
        }

        int targetindex = Integer.parseInt(args[0]) - 1;

        if(targetindex < 0 || targetindex >= context.getTaskList().getTotalTasks()) {
            throw new UserInputException("Targeted Task Number not in list");
        }

        Task targetTask = context.getTaskList().getTask(targetindex);
        context.getTaskList().deleteTask(targetindex);

        String replyMessage = "Noted. I removed this task:\n"
                + targetTask.toString().indent(context.get_indent_level());

        context.reply(replyMessage);
    }
}
