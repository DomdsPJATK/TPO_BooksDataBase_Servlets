package Models;

import java.util.Date;

public class Book {

    private int idBook;
    private String title;
    private int numberOfPages;
    private Date releaseDate;
    private int idAuthor;
    private String authorName;
    private String authorSurname;

    public Book(int idBook, String title, int numberOfPages, Date releaseDate, int idAuthor) {
        this.idBook = idBook;
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.releaseDate = releaseDate;
        this.idAuthor = idAuthor;
    }

    public Book() {

    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(int idAuthor) {
        this.idAuthor = idAuthor;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorSurname() {
        return authorSurname;
    }

    public void setAuthorSurname(String authorSurname) {
        this.authorSurname = authorSurname;
    }
}
