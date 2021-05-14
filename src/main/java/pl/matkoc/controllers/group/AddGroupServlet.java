package pl.matkoc.controllers.group;

import pl.matkoc.dao.GroupDao;
import pl.matkoc.model.Group;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddGroupServlet", value = "/addGroup")
public class AddGroupServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("groupName");
        GroupDao groupDao = new GroupDao();
        Group group = new Group();
        group.setName(name);

        groupDao.create(group);
        response.sendRedirect("/group.jsp");

    }
}
