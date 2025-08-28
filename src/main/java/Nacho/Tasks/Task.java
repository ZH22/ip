package Nacho.Tasks;

/**
 * Abstract Parent Class of all Task Classes
 * <p>
 *     Every Task will have at least a Title and Completion Status
 * </p>
 */

public abstract class Task {
    private boolean completed;
    private String title;

    public Task(String title) {
        this.title = title;
        this.completed = false;
    }

    public String getTitle() {
        return this.title;
    }

    public void markCompleted() {
        this.completed = true;
    }

    public void unmarkCompleted() {
        this.completed = false;
    }

    public int isCompleted() {
        return this.completed ? 1 : 0;
    }


    /**
     *  Returns a string with details of all fields in a specific format.
     *  <p>
     *  Exact implementation will be handled by child classes.
     *  Content within all representations are to be delimited by " | "  strings.
     *  </p>
     *
     *  @return string representation of all fields in Task instance.
     */
    public abstract String getStorageRepresentation();

    @Override
    public String toString() {
        String checkbox = this.completed ? "[X]" : "[ ]";
        return checkbox + " " + this.title;
    }

}
