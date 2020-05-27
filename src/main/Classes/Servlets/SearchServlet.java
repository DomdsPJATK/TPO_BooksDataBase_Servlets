package Servlets;

import Services.DataBaseBookSqlService;
import Services.JspFileReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class SearchServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\"\n" +
                "\"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                "<html>\n" +
                "<head>\n" +
                "    <title>Wyszukiwarka książek</title>\n" +
                "    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css\">\n" +
                "    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js\" type=\"\"></script>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h3>Wprowadź index książki</h3>\n" +
                "<form method=\"post\" action=\"books\">\n" +
                "    <input type=\"text\" name=\"index\">\n" +
                "    <input type=\"submit\" value=\"Szukaj\">\n" +
                "</form>\n" +
                "<script type=\"text/javascript\" src=\"js/materialize.min.js\"></script>\n" +
                "</body>\n" +
                "</html>\n");
    }

}
