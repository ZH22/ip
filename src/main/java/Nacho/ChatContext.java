package Nacho;

import Nacho.Tasks.TaskList;

/**
 * Handles UI and Chat Context for Nacho Chatbot
 * chatType values:
 * (1): CLI -> Prints styled reply to CLI
 * (2): GUI -> Saves reply to latestMessage property to be read
 */
public class ChatContext {
    // Visual Elements
    private static String horizontalLine = "-----------------------------------";
    private static int indentLevel = 4;
    private TaskList taskList;
    private String chatType;
    private String latestMessage;

    /**
     * Sets the Chat Context Object
     * @param taskList List of Task Objects
     * @param chatType type of chat "GUI" or "CLI" -> Affects reply handling
     */
    public ChatContext(TaskList taskList, String chatType) {
        this.taskList = taskList;
        this.chatType = chatType;
    }

    public TaskList getTaskList() {
        return this.taskList;
    }

    public int getIndentLevel() {
        return indentLevel;
    }

    /**
     * Styles desired message with UI elements representing Nacho's voice
     * (e.g. Horizontal Line separation & Indentation)
     * @param message String containing information to be "said" by Nacho Chatbot
     */
    public void reply(String message) {
        assert (this.chatType == "CLI" || this.chatType == "GUI");

        if (this.chatType == "CLI") {
            String styledMessage = (horizontalLine + "\n" + message + "\n" + horizontalLine).indent(indentLevel);
            System.out.print(styledMessage);
        } else if (this.chatType == "GUI") {
            this.latestMessage = message;
        }
    }

    /**
     * Returns the latest message saved after replying in GUI mode
     * (Workaround to reduce need to rewrite old code)
     */
    public String getLatestReply() {
        String message = this.latestMessage;
        this.latestMessage = null; // Resets reply message after being "Read" to prevent reread
        return message;

    }
}
