package Level3_Task5_CRUD_FileIO;

public class Task {

    int id;
    String title;

    public Task(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public String toString() {
        return id + "," + title;
    }
}