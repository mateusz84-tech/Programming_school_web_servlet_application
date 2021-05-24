package pl.matkoc.controllers.exerciseController;

import pl.matkoc.dao.ExerciseDao;
import pl.matkoc.model.Exercise;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListExerciseServlet", value = "/exerciseList")
public class ListExerciseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        ExerciseDao exerciseDao = new ExerciseDao();
        List<Exercise> exerciseList = exerciseDao.findLastFiveExercise();
        request.setAttribute("list", exerciseList);
        getServletContext().getRequestDispatcher("/exercise.jsp")
                .forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

    }
}
