package database.model;

public class User {
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User [id=" + id + "]";
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;
}
