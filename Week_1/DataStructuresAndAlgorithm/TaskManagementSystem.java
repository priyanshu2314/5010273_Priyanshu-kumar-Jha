class Task {
    private int taskId;
    private String taskName;
    private String status;

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    public int getTaskId() {
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Task{taskId=" + taskId + ", taskName='" + taskName + "', status='" + status + "'}";
    }
}

class Node {
    Task task;
    Node next;

    Node(Task task) {
        this.task = task;
        this.next = null;
    }
}

class TaskManager {
    private Node head;

    public TaskManager() {
        head = null;
    }

    public void addTask(int taskId, String taskName, String status) {
        Task task = new Task(taskId, taskName, status);
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public Task searchTask(int taskId) {
        Node current = head;
        while (current != null) {
            if (current.task.getTaskId() == taskId) {
                return current.task;
            }
            current = current.next;
        }
        return null;
    }

    public void traverseTasks() {
        Node current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    public void deleteTask(int taskId) {
        if (head == null) {
            System.out.println("The task list is empty.");
            return;
        }

        if (head.task.getTaskId() == taskId) {
            head = head.next;
            System.out.println("Task with ID " + taskId + " has been deleted.");
            return;
        }

        Node current = head;
        Node previous = null;
        while (current != null && current.task.getTaskId() != taskId) {
            previous = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("Task with ID " + taskId + " not found.");
        } else {
            previous.next = current.next;
            System.out.println("Task with ID " + taskId + " has been deleted.");
        }
    }
}

public class TaskManagementSystem {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        taskManager.addTask(1, "Design Homepage", "In Progress");
        taskManager.addTask(2, "Develop Backend", "Completed");
        taskManager.addTask(3, "Write Documentation", "Not Started");

        System.out.println("All Tasks:");
        taskManager.traverseTasks();

        System.out.println("\nSearch for Task with ID 2:");
        Task task = taskManager.searchTask(2);
        if (task != null) {
            System.out.println(task);
        } else {
            System.out.println("Task not found.");
        }

        System.out.println("\nDeleting Task with ID 3:");
        taskManager.deleteTask(3);

        System.out.println("\nAll Tasks after deletion:");
        taskManager.traverseTasks();
    }
}
