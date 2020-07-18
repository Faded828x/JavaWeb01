package com.WebTest;

public class book {
    private String name;
    private String author;
    private String genre;

    public book() {
    }

    public book(String name, String genre, String author) {
        this.name = name;
        this.genre = genre;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "book{" +
                "name='" + name + '\'' +
                ", genre=" + genre +
                ", author='" + author + '\'' +
                '}';
    }
}
