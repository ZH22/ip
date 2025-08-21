import java.util.Arrays;
import java.util.Map;

public class CommandDispatcher {
    private final Map<String, Command> registry;

    public CommandDispatcher(Map<String, Command> registry) {
        this.registry = registry;
    }

    public void dispatch(String userInput, ChatContext context) {
        String[] parts = userInput.split(" ");
        String commandName = parts[0];
        String[] args = Arrays.copyOfRange(parts, 1, parts.length);

        Command cmd = registry.get(commandName);
        if (cmd != null) {
           cmd.execute(args, context);
        } else {
            context.reply("Sorry I don't know this command");
        }
    }

}
