package pl.matkoc.dao;


import pl.matkoc.DBUtil;
import pl.matkoc.model.Exercise;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExerciseDao {

    private final String CREATE_EXERCISE_QUERY =
            "INSERT INTO exercise(title, description) VALUES(?,?)";
    private final String READ_EXERCISE_QUERY =
            "SELECT * FROM exercise WHERE id_exercise = ?";
    private final String UPDATE_EXERCISE_QUERY =
            "UPDATE exercise SET title = ?, description = ? WHERE id_exercise = ?";
    private final String DELETE_EXERCISE_QUERY =
            "DELETE FROM exercise WHERE id_exercise = ?";
    private final String GET_ALL_EXERCISE =
            "SELECT * FROM exercise";
    private final String GET_LAST_FIVE_EXERCISE_QUERY =
            "SELECT * FROM exercise ORDER BY id_exercise DESC LIMIT 5";

    public Exercise create(Exercise exercise){
        try(Connection connection = DBUtil.getConnection()) {
            PreparedStatement statement =
                    connection.prepareStatement(CREATE_EXERCISE_QUERY,PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, exercise.getTitle());
            statement.setString(2,exercise.getDescription());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            while(resultSet.next()){
                exercise.setId(resultSet.getInt(1));
            }
            return exercise;
        }catch (SQLException exc){
            exc.printStackTrace();
            return null;
        }
    }

    public Exercise read(int exercise_id){
        try(Connection connection = DBUtil.getConnection()){
            PreparedStatement statement = connection.prepareStatement(READ_EXERCISE_QUERY);
            statement.setInt(1,exercise_id);
            ResultSet resultSet = statement.executeQuery();
            Exercise exercise = new Exercise();
            while(resultSet.next()){
                exercise.setId(resultSet.getInt("id_exercise"));
                exercise.setTitle(resultSet.getString("title"));
                exercise.setDescription(resultSet.getString("description"));
            }
            return exercise;
        }catch (SQLException exc){
            exc.printStackTrace();
            return null;
        }
    }

    public void update(Exercise exercise){
        try(Connection connection = DBUtil.getConnection()){
            PreparedStatement statement = connection.prepareStatement(UPDATE_EXERCISE_QUERY);
            statement.setString(1,exercise.getTitle());
            statement.setString(2, exercise.getDescription());
            statement.setInt(3,exercise.getId());
            statement.executeUpdate();
        }catch (SQLException exc){
            exc.printStackTrace();
        }
    }

    public void delete(int id){
        try(Connection connection = DBUtil.getConnection()){
            PreparedStatement statement = connection.prepareStatement(DELETE_EXERCISE_QUERY);
            statement.setInt(1,id);
            statement.executeUpdate();
        }catch (SQLException exc){
            exc.printStackTrace();
        }
    }

    public List<Exercise> findAll() {
        List<Exercise> exerciseList = new ArrayList<>();
        try(Connection connection = DBUtil.getConnection()){
            PreparedStatement statement = connection.prepareStatement(GET_ALL_EXERCISE);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                Exercise exercise = new Exercise();
                exercise.setId(resultSet.getInt("id_exercise"));
                exercise.setTitle(resultSet.getString("title"));
                exercise.setDescription(resultSet.getString("description"));

                exerciseList.add(exercise);
            }
            return exerciseList;
        }catch (SQLException exc){
            exc.printStackTrace();
            return null;
        }
    }

    public List<Exercise> findLastFiveExercise(){
        List<Exercise> lastFiveList = new ArrayList<>();
        try(Connection connection = DBUtil.getConnection()){
            PreparedStatement statement = connection.prepareStatement(GET_LAST_FIVE_EXERCISE_QUERY);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                Exercise exercise = new Exercise();
                exercise.setId(resultSet.getInt("id_exercise"));
                exercise.setTitle(resultSet.getString("title"));
                exercise.setDescription(resultSet.getString("description"));

                lastFiveList.add(exercise);
            }
        }catch (SQLException exc){
            exc.printStackTrace();
            return null;
        }
        return lastFiveList;
    }
}
