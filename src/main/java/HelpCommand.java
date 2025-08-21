public class HelpCommand implements Command{

    @Override
    public void execute(String[] args, ChatContext context) {
       context.reply("Available commands: todo deadline event");
    }
}
