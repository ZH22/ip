public class DeadlineTask extends Task {

    String by_date;

    public DeadlineTask(String title, String by_date) {
        super(title);
        this.by_date = by_date;
    }

    @Override
    public String toString(){
        return "[D]" + super.toString() + " (by: " + this.by_date + ")";
    }
}
