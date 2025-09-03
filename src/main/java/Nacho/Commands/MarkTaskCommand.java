package Nacho.Commands;

import Nacho.ChatContext;
import Nacho.Exceptions.UserInputException;
import Nacho.ExternalStorageController;
import Nacho.Tasks.Task;

/**
 * Marks target task completed, specified by position in TaskList
 */
public class MarkTaskCommand implements Command {

    @Override
    public void execute(String[] args, ChatContext context) {
        int targetIndex = Integer.parseInt(args[0]) - 1;

        if (targetIndex < 0 || targetIndex >= context.getTaskList().getTotalTasks()) {
            throw new UserInputException("Targeted Task Number not in list");
        }

        Task targetTask = context.getTaskList().getTask(targetIndex);

        targetTask.markCompleted();

        String replyMessage = "Nice! I've marked this task as done:\n"
                + targetTask.toString().indent(context.getIndentLevel());

        // Update External DB
        ExternalStorageController.updateStore(context.getTaskList().getStorageRepresentation());

        context.reply(replyMessage);

    }
}
