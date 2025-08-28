package Nacho;

import Nacho.Tasks.TaskList;

/**
 * Handles UI and Chat Context for Nacho Chatbot
 */
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

    /**
     * Styles desired message with UI elements representing Nacho's voice
     * (e.g. Horizontal Line separation & Indentation)
     * @param message String containing information to be "said" by Nacho Chatbot
     */
    public void reply(String message) {
        String styled_message = (horizontalLine + "\n" + message + "\n" + horizontalLine).indent(indentLevel);
        System.out.print(styled_message);
    }
}
