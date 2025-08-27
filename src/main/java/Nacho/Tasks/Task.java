package Nacho.Tasks;

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

    public abstract String getStorageRepresentation();

    @Override
    public String toString() {
        String checkbox = this.completed ? "[X]" : "[ ]";
        return checkbox + " " + this.title;
    }

}
