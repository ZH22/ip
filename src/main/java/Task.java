public class Task {
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

    @Override
    public String toString() {
        String checkbox = this.completed ? "[X]" : "[ ]";
        return checkbox + " " + this.title;
    }

}
