public class DeadlineTask extends Task {

    String by_date;

    public DeadlineTask(String title, String by_date) {
        super(title);
        this.by_date = by_date;
    }

    @Override
    public String getStorageRepresentation() {
        String[] info = new String[4];
        info[0] = "D";
        info[1] = Integer.toString(this.isCompleted());
        info[2] = this.getTitle();
        info[3] = this.by_date;

        return String.join(" | ", info);
    }

    @Override
    public String toString(){
        return "[D]" + super.toString() + " (by: " + this.by_date + ")";
    }
}
