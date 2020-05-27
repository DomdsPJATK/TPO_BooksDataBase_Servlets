package Servlets;

import Models.Book;
import Services.DataBaseBookSqlService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class BooksServlet extends HttpServlet {

    private DataBaseBookSqlService sqlService;

    @Override
    public void init() throws ServletException {
        super.init();
        sqlService = new DataBaseBookSqlService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println(addCSS(getTableHTML(sqlService.getBooks())));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String row = getRowHTML(sqlService.getBook(request.getParameter("index")));
        out.println(addCSS( "<table>" + addHeadersTable() + row + "</table>"));
    }

    public String addHeadersTable(){
        return "<thead>\n" +
                "<tr>\n" +
                "<th>Id książki</th>\n" +
                "<th>Tytuł</th>\n" +
                "<th>Liczba stron</th>\n" +
                "<th>Data wydania</th>\n" +
                "<th>Autor</th>\n" +
                "</tr>\n" +
                "</thead>";
    }

    public String getTableHTML(List<Book> books) {
        String res = "<table>";
        res+=addHeadersTable();
        for (Book book : books) {
            res+=getRowHTML(book);
        }
        res += "</table>";
        return res;
    }

    public String getRowHTML(Book book) {
        String res="";
        res += "<tr>";
        res += "<th>" + book.getIdBook() + "</th>";
        res += "<th>" + book.getTitle() + "</th>";
        res += "<th>" + book.getNumberOfPages() + "</th>";
        res += "<th>" + book.getReleaseDate() + "</th>";
        res += "<th>" + book.getIdAuthor() + "</th>";
        res += "</tr>";
        return res;
    }

    public String addCSS(String text){
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\"\n" +
                "\"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                "<html>\n" +
                "<head>\n" +
                "    <title>Wyszukiwarka książek</title>\n" +
                "    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css\">\n" +
                "    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js\" type=\"\"></script>\n" +
                "</head>\n" +
                "<body>\n" + text +
                "</body>\n" +
                "</html>\n";
    }

}