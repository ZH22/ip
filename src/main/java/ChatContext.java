public class ChatContext {
    // Visual Elements
    private static String horizontal_line = "-----------------------------------";
    private static int indent_level = 4;
    private TaskList taskList;

    public ChatContext(TaskList taskList) {
        this.taskList = taskList;
    }

    public TaskList getTaskList() {
        return this.taskList;
    }

    public int get_indent_level() {
        return indent_level;
    }

    public void reply(String message) {
        String styled_message = (horizontal_line + "\n" + message + "\n" + horizontal_line).indent(indent_level);
        System.out.print(styled_message);
    }
}
