package Nacho.Tasks;

import Nacho.ExternalStorageController;

import java.util.ArrayList;
import java.util.Objects;

/**
 * List of Task objects with implementations
 */
public class TaskList {
    ArrayList<Task> taskList = new ArrayList<>();

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
                taskList.add(temp);
            }
        } catch (Exception e) {
            // Highlight wrong input and start fresh
            System.out.println("WRONG INPUT DATA FORMAT!\n Saving wrong content as oldCorrupted.txt and creating new");
            taskList = new ArrayList<>();
            ExternalStorageController.createTempCorruptedFile();
        }

    }

    public void addTask(Task task) {
        taskList.add(task);
        ExternalStorageController.updateStore(this.getStorageRepresentation());
    }

    public void deleteTask(int taskIndex) {
        taskList.remove(taskIndex);
        ExternalStorageController.updateStore(this.getStorageRepresentation());
    }

    public Task getTask(int taskIndex) {
        return taskList.get(taskIndex);
    }

    public int getTotalTasks() {
        return taskList.size();
    }

    public String getStorageRepresentation() {
        String itemList = "";
        for (Task task : taskList) {
            itemList = itemList.concat(task.getStorageRepresentation() + "\n");
        }
        return itemList;
    }

    @Override
    public String toString() {
        String itemList = "";
        for(int i = 0; i < taskList.size(); i++){
            String item = String.format("%d. %s", i + 1, taskList.get(i));
            itemList = itemList.concat(item + "\n");
        }
        return itemList;
    }
}
