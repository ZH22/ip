public class HelpCommand implements Command{

    @Override
    public void execute(String[] args, ChatContext context) {
        String helpMessage = "Available Commands: (Replace <> tags with your content\n" +
                "list\n" +
                "todo <task_header>\n" +
                "deadline <task_header> /by <deadline_date>\n" +
                "event <task_header> /from <start_date> /to <end_date>";
        context.reply("Available commands: todo deadline event");
    }
}
