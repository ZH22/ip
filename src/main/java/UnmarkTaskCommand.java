public class UnmarkTaskCommand implements Command{

    @Override
    public void execute(String[] args, ChatContext context) {
       int target_index = Integer.parseInt(args[0]) - 1;
       Task targetTask = context.getTaskList().getTask(target_index);

        targetTask.unmarkCompleted();

        String replyMessage = "OK, I've marked this task as not done yet:\n"
                + targetTask.toString().indent(context.get_indent_level());

        context.reply(replyMessage);
    }
}
