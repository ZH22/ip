// Interface inspired by https://medium.com/@neerukapoor/command-design-pattern-in-java-7d06dfdd31

public interface Command {
    public void execute(String[] args, ChatContext context);
}
