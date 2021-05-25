package pl.matkoc.controllers.usersController;

import pl.matkoc.dao.UserDao;
import pl.matkoc.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListUserServlet", value = "/userList")
public class ListUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        UserDao userDao = new UserDao();
        List<User> userList = userDao.findLastFiveUser();

        request.setAttribute("list",userList);
        getServletContext().getRequestDispatcher("/user.jsp")
                .forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

    }
}
