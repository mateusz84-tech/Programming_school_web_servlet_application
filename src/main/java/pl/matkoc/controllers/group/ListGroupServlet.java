package pl.matkoc.controllers.group;

import pl.matkoc.dao.GroupDao;
import pl.matkoc.model.Group;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListGroupServlet", value = "/groupList")
public class ListGroupServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        GroupDao groupDao = new GroupDao();
        List<Group> groupList = groupDao.findAll();
        request.setAttribute("group", groupList);
        getServletContext().getRequestDispatcher("/group.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

    }
}
