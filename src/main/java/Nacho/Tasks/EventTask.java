package Nacho.Tasks;

public class EventTask extends Task {

    String from_date, to_date;

    public EventTask(String title, String from_date, String to_date) {
        super(title);
        this.from_date = from_date;
        this.to_date = to_date;
    }


    @Override
    public String getStorageRepresentation() {
        String[] info = new String[5];
        info[0] = "E";
        info[1] = Integer.toString(this.isCompleted());
        info[2] = this.getTitle();
        info[3] = this.from_date;
        info[4] = this.to_date;

        return String.join(" | ", info);
    }

    @Override
    public String toString() {
        String event_date_string = "(from: " + this.from_date + " to: " + this.to_date + ")";
        return "[E]" + super.toString() + " " + event_date_string;
    }
}
