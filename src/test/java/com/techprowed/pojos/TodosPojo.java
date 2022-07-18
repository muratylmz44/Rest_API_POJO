package com.techprowed.pojos;

public class TodosPojo {







    private int userId;
    private  int id;
    private String title;
    private boolean completed;

    public int getUserId() {
        return userId;
    }


    //  Generate ile Gettir Settir
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;

    }
// Generate ile Parametresiz Constructor
    public TodosPojo() {
    }
    // Generate ile Parametreli Constructor


    public TodosPojo(int userId, int id, String title, boolean completed) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.completed = completed;
    }
    //Genarate ile ToString Metodu


    @Override
    public String toString() {
        return "TodosPojo{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }
}
