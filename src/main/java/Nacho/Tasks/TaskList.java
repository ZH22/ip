package Nacho.Tasks;

import Nacho.ExternalStorageController;

import java.util.ArrayList;
import java.util.Objects;

/**
 * List of Task objects with implementations
 */
public class TaskList {
    ArrayList<Task> task_list = new ArrayList<>();

    public TaskList(String storageInput) {
        try {
            // Load Incoming Data From storage location
            for (String line : storageInput.lines().toList()) {
                char taskType = line.charAt(0);
                String[] info = line.split(" \\| ");
                Task temp = null;

                if (taskType == 'T') {
                    temp = new TodoTask(info[2]);
                } else if (taskType == 'D') {
                    temp = new DeadlineTask(info[2], info[3]);
                } else if (taskType == 'E') {
                    temp = new EventTask(info[2], info[3], info[4]);
                } else {
                    throw new Exception("Wrong input format");
                }

                if (Objects.equals(info[1], "1")) {
                    temp.markCompleted();
                }
                task_list.add(temp);
            }
        } catch (Exception e) {
            // Highlight wrong input and start fresh
            System.out.println("WRONG INPUT DATA FORMAT!\n Saving wrong content as oldCorrupted.txt and creating new");
            task_list = new ArrayList<>();
            ExternalStorageController.createTempCorruptedFile();
        }

    }

    public void addTask(Task task) {
        task_list.add(task);
        ExternalStorageController.updateStore(this.getStorageRepresentation());
    }

    public void deleteTask(int task_index) {
        task_list.remove(task_index);
        ExternalStorageController.updateStore(this.getStorageRepresentation());
    }

    public Task getTask(int task_index) {
        return task_list.get(task_index);
    }

    public int getTotalTasks() {
        return task_list.size();
    }

    public String getStorageRepresentation() {
        String item_list = "";
        for(int i = 0; i < task_list.size(); i++){
            item_list = item_list.concat(task_list.get(i).getStorageRepresentation() + "\n");
        }
        return item_list;
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
