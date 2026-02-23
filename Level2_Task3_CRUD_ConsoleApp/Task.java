package Level2_Task3_CRUD_ConsoleApp;

public class Task {

    int id;
    String title;

    public Task(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public String toString() {
        return "ID: " + id + " | Title: " + title;
    }
}