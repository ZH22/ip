public class AddTodoCommand implements Command{

    @Override
    public void execute(String[] args, ChatContext context) {

        String taskTitle = String.join(" ", args);

        TodoTask newTodo = new TodoTask(taskTitle);
        context.getTaskList().addTask(newTodo);
        String replyMessage = "Got it. I've added this task:\n"
                + newTodo.toString().indent(context.get_indent_level())
                + "\nNow you have " + context.getTaskList().getTotalTasks() + " tasks in the list.";

        context.reply(replyMessage);
    }
}
