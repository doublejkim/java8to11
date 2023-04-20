package me.doublej.stream;

public class Books {

    private Integer id;

    private String title;

    private boolean rental;

    public Books(Integer id, String title, boolean rental) {
        this.id = id;
        this.title = title;
        this.rental = rental;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isRental() {
        return rental;
    }

    public void setRental(boolean rental) {
        this.rental = rental;
    }

    @Override
    public String toString() {
        return "( id : " + this.id + ", title : " + title + ", rental : " + rental + " )";
    }
}
