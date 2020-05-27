package Servlets;

import Services.DataBaseBookSqlService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

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
//        System.out.println(sqlService.getBooks().get(0).getTitle());
        out.println(sqlService.getBooks().get(0).getTitle());
    }

}