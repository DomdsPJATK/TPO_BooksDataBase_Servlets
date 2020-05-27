package Services;

import Models.Author;
import Models.Book;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBaseBookSqlService {

    private Connection connection;
    private Statement statement;
    private final String connectionString = "jdbc:mysql://localhost:3306/bookdatabase";

    public DataBaseBookSqlService() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookdatabase?serverTimezone=UTC", "root", "admin");
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Book> getBooks(){
        List<Book> res = new ArrayList<>();
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery("Select * FROM book");
            while(resultSet.next()){
                Book book = new Book();
                book.setIdAuthor(resultSet.getInt("idauthor"));
                book.setIdBook(resultSet.getInt("idbook"));
                book.setTitle(resultSet.getString("title"));
                book.setNumberOfPages(resultSet.getInt("pages"));
                book.setReleaseDate(resultSet.getDate("creationdate"));
                res.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    public Book getBook(String index) {
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery("Select * FROM book WHERE idbook=" + index);
            if(resultSet.next()){
                Book book = new Book();
                book.setIdAuthor(resultSet.getInt("idauthor"));
                book.setIdBook(resultSet.getInt("idbook"));
                book.setTitle(resultSet.getString("title"));
                book.setNumberOfPages(resultSet.getInt("pages"));
                book.setReleaseDate(resultSet.getDate("creationdate"));
                return book;
            } else return null;
        } catch (SQLException e) {
            return null;
        }
    }

    public Author getAuthor(String index){
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery("Select * FROM author WHERE idauthor=" + index);
            if(resultSet.next()){
                Author author = new Author();
                author.setIdAuthor(resultSet.getInt("idauthor"));
                author.setSurname(resultSet.getString("surname"));
                author.setName(resultSet.getString("name"));
                author.setBirthdate(resultSet.getDate("birthdate"));
                return author;
            } else return null;
        } catch (SQLException e) {
            return null;
        }
    }

    public Book setAuthorsForBook(Book book){
        if(book == null) return null;
        Author author = getAuthor(String.valueOf(book.getIdAuthor()));
        if(author == null) {
            book.setAuthorName("Nieznane");
            book.setAuthorSurname("Nieznane");
        }
        book.setAuthorSurname(author.getSurname());
        book.setAuthorName(author.getName());
        return book;
    }

}
