package Nacho.Tasks;

/**
 * Task with a time range (from - to)
 */
public class EventTask extends Task {

    String fromDate, toDate;

    public EventTask(String title, String from_date, String to_date) {
        super(title);
        this.fromDate = from_date;
        this.toDate = to_date;
    }


    @Override
    public String getStorageRepresentation() {
        String[] info = new String[5];
        info[0] = "E";
        info[1] = Integer.toString(this.isCompleted());
        info[2] = this.getTitle();
        info[3] = this.fromDate;
        info[4] = this.toDate;

        return String.join(" | ", info);
    }

    @Override
    public String toString() {
        String event_date_string = "(from: " + this.fromDate + " to: " + this.toDate + ")";
        return "[E]" + super.toString() + " " + event_date_string;
    }
}
