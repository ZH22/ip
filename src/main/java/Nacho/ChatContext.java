package Nacho;

import Nacho.Tasks.TaskList;

public class ChatContext {
    // Visual Elements
    private static String horizontalLine = "-----------------------------------";
    private static int indentLevel = 4;
    private TaskList taskList;

    public ChatContext(TaskList taskList) {
        this.taskList = taskList;
    }

    public TaskList getTaskList() {
        return this.taskList;
    }

    public int get_indent_level() {
        return indentLevel;
    }

    public void reply(String message) {
        String styled_message = (horizontalLine + "\n" + message + "\n" + horizontalLine).indent(indentLevel);
        System.out.print(styled_message);
    }
}
