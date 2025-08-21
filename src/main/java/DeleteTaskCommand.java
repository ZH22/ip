public class DeleteTaskCommand implements Command{

    @Override
    public void execute(String[] args, ChatContext context) {
        if (args.length == 0) {
            throw new UserInputException("Require index number of task to delete");
        }

        int target_index = Integer.parseInt(args[0]) - 1;

        if(target_index < 0 || target_index >= context.getTaskList().getTotalTasks())
           throw new UserInputException("Targeted Task Number not in list");

        Task targetTask = context.getTaskList().getTask(target_index);
        context.getTaskList().deleteTask(target_index);

        String replyMessage = "Noted. I removed this task:\n"
                + targetTask.toString().indent(context.get_indent_level());

        context.reply(replyMessage);
    }
}
