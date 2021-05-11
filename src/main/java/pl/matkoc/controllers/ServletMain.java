package pl.matkoc.controllers;

import pl.matkoc.dao.SolutionDao;
import pl.matkoc.model.Solution;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ServletMain", value = "/")
public class ServletMain extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {


        request.setAttribute("solutions","napis");
        getServletContext().getRequestDispatcher("/main.jsp")
                .forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
