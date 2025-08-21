import java.util.Arrays;
import java.util.Map;

public class CommandDispatcher {
    private final Map<String, Command> registry;

    public CommandDispatcher(Map<String, Command> registry) {
        this.registry = registry;
    }

    public void dispatch(String userInput, ChatContext context) {

        try {

            String[] parts = userInput.split(" ");
            String commandName = parts[0];
            String[] args = Arrays.copyOfRange(parts, 1, parts.length);

            Command cmd = registry.get(commandName);
            if (cmd != null) {
                cmd.execute(args, context);
            } else {
                context.reply("Sorry I don't know this command. \n\nTry 'help' for a list of commands to use!");
            }
        } catch (UserInputException e){
            context.reply(e.getMessage());
        } catch (Exception e) {
            context.reply("Unexpected Error!! Nacho doesn't really know either T^T");
        }
    }

}
