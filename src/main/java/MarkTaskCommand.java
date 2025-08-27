public class MarkTaskCommand implements Command{

    @Override
    public void execute(String[] args, ChatContext context) {
       int target_index = Integer.parseInt(args[0]) - 1;

       if(target_index < 0 || target_index >= context.getTaskList().getTotalTasks())
           throw new UserInputException("Targeted Task Number not in list");

       Task targetTask = context.getTaskList().getTask(target_index);

        targetTask.markCompleted();

        String replyMessage = "Nice! I've marked this task as done:\n"
                + targetTask.toString().indent(context.get_indent_level());

        // Update External DB
        ExternalStorageController.updateStore(context.getTaskList().getStorageRepresentation());

        context.reply(replyMessage);

    }
}
