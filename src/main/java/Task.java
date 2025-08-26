abstract class Task {
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
        ExternalStorageController.updateStore(this.getStorageRepresentation());
    }

    public void unmarkCompleted() {
        this.completed = false;
        ExternalStorageController.updateStore(this.getStorageRepresentation());
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
