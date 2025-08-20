public class EventTask extends Task {

    String from_date, to_date;

    public EventTask(String title, String from_date, String to_date) {
        super(title);
        this.from_date = from_date;
        this.to_date = to_date;
    }

    @Override
    public String toString() {
        String event_date_string = "(from: " + this.from_date + " to: " + this.to_date + ")";
        return "[E]" + super.toString() + " " + event_date_string;
    }
}
