import java.lang.reflect.Array;
import java.util.ArrayList;

public class TaskList {
    ArrayList<Task> task_list = new ArrayList<>();

    public void addTask(Task task) {
        task_list.add(task);
    }

    public void deleteTask(int task_index) {
        task_list.remove(task_index);
    }

    public Task getTask(int task_index) {
        return task_list.get(task_index);
    }

    public int getTotalTasks() {
        return task_list.size();
    }

    @Override
    public String toString() {
        String item_list = "";
        for(int i = 0; i < task_list.size(); i++){
            String item = String.format("%d. %s", i + 1, task_list.get(i));
            item_list = item_list.concat(item + "\n");
        }
        return item_list;
    }
}
