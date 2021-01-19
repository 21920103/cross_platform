package model.orm;

public class Client {
    private int id;

    public Client(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Client(String name) {
        this.name = name;
    }

    public Client() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    private String name;
}
