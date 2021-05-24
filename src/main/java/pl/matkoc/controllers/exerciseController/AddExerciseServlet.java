package pl.matkoc.controllers.exerciseController;

import pl.matkoc.dao.ExerciseDao;
import pl.matkoc.model.Exercise;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddExerciseServlet", value = "/addExercise")
public class AddExerciseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        String title = request.getParameter("title");
        String description = request.getParameter("description");

        Exercise exercise = new Exercise();
        exercise.setTitle(title);
        exercise.setDescription(description);

        ExerciseDao exerciseDao = new ExerciseDao();
        exerciseDao.create(exercise);

        response.sendRedirect("/exerciseList");

    }
}
