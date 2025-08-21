public class MarkTaskCommand implements Command{

    @Override
    public void execute(String[] args, ChatContext context) {
       int target_index = Integer.parseInt(args[0]) - 1;
       Task targetTask = context.getTaskList().getTask(target_index);

        targetTask.markCompleted();

        String replyMessage = "Nice! I've marked this task as done:\n"
                + targetTask.toString().indent(context.get_indent_level());

        context.reply(replyMessage);
    }
}
