import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.time.format.DateTimeFormatter;

public class DeadlineTask extends Task {

    private LocalDateTime by_date;

    private String getByDateDisplayString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM y - hh:mm a");
        return this.by_date.format(formatter);
    }

    private String getByDateStorageString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy-HH:mm");
        return this.by_date.format(formatter);
    }

    public DeadlineTask(String title, String by_date) throws UserInputException{
        super(title);

        // Throws java.time.format.DateTimeParseException if invalid input
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy-HH:mm");
            this.by_date = LocalDateTime.parse(by_date, formatter);
        } catch (DateTimeParseException e) {
            throw new UserInputException("Wrong Date Format! Use dd/MM/yyyy-HH:mm");
        }
    }

    @Override
    public String getStorageRepresentation() {
        String[] info = new String[4];
        info[0] = "D";
        info[1] = Integer.toString(this.isCompleted());
        info[2] = this.getTitle();
        info[3] = this.getByDateStorageString();

        return String.join(" | ", info);
    }

    @Override
    public String toString(){
        return "[D]" + super.toString() + " (by: " + this.getByDateDisplayString() + ")";
    }
}
