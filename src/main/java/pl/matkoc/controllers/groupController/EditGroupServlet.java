package pl.matkoc.controllers.groupController;

import pl.matkoc.dao.GroupDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

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
