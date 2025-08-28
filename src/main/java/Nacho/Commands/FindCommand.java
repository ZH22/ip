package Nacho.Commands;

import Nacho.ChatContext;
import Nacho.Exceptions.UserInputException;
import Nacho.Tasks.Task;

import java.util.ArrayList;

/**
 * Finds a task by searching for a keyword in task description
 */
public class FindCommand implements Command{
    @Override
    public void execute(String[] args, ChatContext context) {

        String keyword = null;

        try {
            keyword = args[0];
        } catch (Exception e) {
            throw new UserInputException("Improper Format. Require one Keyword to search by!");
        }


        ArrayList<Task> matchingTasks = new ArrayList<>();

        // Find and add matching tasks to list
        for (int i = 0; i < context.getTaskList().getTotalTasks(); i++) {
            Task currentTask = context.getTaskList().getTask(i);
            if (currentTask.getTitle().contains(keyword)) {
                matchingTasks.add(currentTask);
            }
        }

        // Print out matching tasks
        String replyMessage = "Here are the matching tasks in your list:\n";
        for (int i = 0; i < matchingTasks.size(); i++) {
            String currentTaskLine = String.format("%d. %s\n", i, matchingTasks.get(i));
            replyMessage = replyMessage + currentTaskLine;
        }
        context.reply(replyMessage);
    }
}
