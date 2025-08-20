public class TaskList {
    Task[] task_list = new Task[100];
    int total_tasks = 0;

    public int addTask(Task task) {
        task_list[total_tasks] = task;
        total_tasks += 1;

        return 0;
    }

    public Task getTask(int task_index) {
        return task_list[task_index];
    }

    public int getTotalTasks() {
        return total_tasks;
    }

    @Override
    public String toString() {
        String item_list = "";
        for(int i = 0; i < total_tasks; i++){
            String item = String.format("%d. %s", i + 1, task_list[i]);
            item_list = item_list.concat(item + "\n");
        }
        return item_list;
    }
}
