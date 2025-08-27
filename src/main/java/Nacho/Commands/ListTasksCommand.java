package Nacho.Commands;

import Nacho.ChatContext;

public class ListTasksCommand implements Command {
    @Override
    public void execute(String[] args, ChatContext context) {

        String listMessage = "Here are your tasks in your list:\n" + context.getTaskList();
        context.reply(listMessage);
    }
}
