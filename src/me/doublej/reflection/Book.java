package me.doublej.reflection;

public class Book {

    private String title = "White Book";

    public static String madeIn = "Korea";

    private int price = 0;

    public Book() {
    }

    public Book(String title) {
        this.title = title;
    }

    private void printInfo() {
        System.out.println(title + "made in " + madeIn);
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return this.price;
    }

    public int sum(int left, int right) {
        return left + right;
    }

    @Override
    public String toString() {
        return "title : " + this.title;
    }
}
