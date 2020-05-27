package Services;

import Models.Book;

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

}
