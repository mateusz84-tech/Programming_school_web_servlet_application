package pl.matkoc.controllers.group;

import pl.matkoc.dao.GroupDao;
import pl.matkoc.model.Group;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EditGroupServlet", value = "/editGroup")
public class EditGroupServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        GroupDao groupDao = new GroupDao();
        request.setAttribute("group", groupDao.findAll());

        getServletContext().getRequestDispatcher("/view_group/editGroup.jsp")
                .forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {



    }
}
