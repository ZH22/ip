package Nacho.Commands;

import Nacho.ChatContext;
import Nacho.Exceptions.UserInputException;
import Nacho.ExternalStorageController;
import Nacho.Tasks.Task;

/**
 * Removes Completed Status from Task (if any)
 */
public class UnmarkTaskCommand implements Command {

    @Override
    public void execute(String[] args, ChatContext context) {
        int targetIndex = Integer.parseInt(args[0]) - 1;

        if (targetIndex < 0 || targetIndex >= context.getTaskList().getTotalTasks()) {
            throw new UserInputException("Targeted Task Number not in list");
        }

        Task targetTask = context.getTaskList().getTask(targetIndex);

        targetTask.unmarkCompleted();

        String replyMessage = "OK, I've marked this task as not done yet:\n"
                + targetTask.toString().indent(context.getIndentLevel());

        // Update External DB
        ExternalStorageController.updateStore(context.getTaskList().getStorageRepresentation());

        context.reply(replyMessage);

    }
}
