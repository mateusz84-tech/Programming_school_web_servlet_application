package pl.matkoc.controllers;

import pl.matkoc.DBUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "Servlet1Test", value = "/test1")
public class Servlet1Test extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        try {
            Connection connection = DBUtil.getConnection();

            response.getWriter().append(connection.getCatalog());
            response.getWriter().println(connection.getMetaData());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
