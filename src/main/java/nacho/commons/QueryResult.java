package nacho.commons;

public class QueryResult {
    public String reply;
    public boolean isError;

    public QueryResult(String reply, boolean isError) {
        this.reply = reply;
        this.isError = isError;
    }
}
