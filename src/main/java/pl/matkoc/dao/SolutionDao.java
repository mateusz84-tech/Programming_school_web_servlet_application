package pl.matkoc.dao;

import pl.matkoc.DBUtil;
import pl.matkoc.model.Solution;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SolutionDao {

    private final String CREATED_SOLUTION_QUERY =
            "INSERT INTO solution(created,updated,description,exercise_id,user_id) VALUES(?,?,?,?,?)";
    private final String READ_SOLUTION_QUERY =
            "SELECT * FROM solution WHERE id_solution = ?";
    private final String UPDATE_SOLUTION_QUERY =
            "UPDATE solution SET created = ?, updated = ?, description = ?, exercise_id = ?, user_id = ? WHERE id_solution = ?";
    private final String DELETE_SOLUTION_QUERY =
            "DELETE FROM solution WHERE id_solution = ?";
    private final String FIND_ALL_SOLUTION_QUERY =
            "SELECT * FROM solution";
    // pobranie wszystkich rozwiązań danego użytkownika
    private final String FIND_ALL_BY_USER_ID_QUERY =
            "SELECT * FROM solution WHERE user_id = ?";
    // pobranie wszystkich rozwiązań danego zadania, posortowane od najnowszego
    private final String FIND_ALL_BY_EXERCISE_ID_QUERY =
            "SELECT * FROM solution  WHERE exercise_id = ? ORDER BY created DESC";
    private final String GET_LAST_FIVE_SOLUTION =
            "SELECT * FROM solution ORDER BY id_solution DESC LIMIT 5";


    public Solution create(Solution solution){
        try(Connection connection = DBUtil.getConnection()){
            PreparedStatement statement =
                    connection.prepareStatement(CREATED_SOLUTION_QUERY,PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setTimestamp(1, solution.getCreated());
            statement.setTimestamp(2,solution.getUpdated());
            statement.setString(3,solution.getDescription());
            statement.setInt(4,solution.getExerciseId());
            statement.setInt(5,solution.getUserId());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            while(resultSet.next()) {
                solution.setId(resultSet.getInt(1));
            }
            return solution;
        }catch (SQLException exc){
            exc.printStackTrace();
            return null;
        }
    }

    public Solution read(int id_solution){
        try(Connection connection = DBUtil.getConnection()){
            PreparedStatement statement = connection.prepareStatement(READ_SOLUTION_QUERY);
            statement.setInt(1,id_solution);
            ResultSet resultSet = statement.executeQuery();
            Solution solution = new Solution();
            while(resultSet.next()){
                solution.setId(resultSet.getInt("id_solution"));
                solution.setCreated(resultSet.getTimestamp("created"));
                solution.setUpdated(resultSet.getTimestamp("updated"));
                solution.setDescription(resultSet.getString("description"));
                solution.setExerciseId(resultSet.getInt("exercise_id"));
                solution.setUserId(resultSet.getInt("user_id"));
            }
            return solution;
        }catch (SQLException exc){
            exc.printStackTrace();
            return null;
        }
    }

    public void update(Solution solution){
        try(Connection connection = DBUtil.getConnection()){
            PreparedStatement statement = connection.prepareStatement(UPDATE_SOLUTION_QUERY);
            statement.setTimestamp(1,  solution.getCreated());
            statement.setTimestamp(2, solution.getUpdated());
            statement.setString(3,solution.getDescription());
            statement.setInt(4,solution.getExerciseId());
            statement.setInt(5,solution.getUserId());
            statement.setInt(6,solution.getId());
            statement.executeUpdate();
        }catch (SQLException exc){
            exc.printStackTrace();
        }
    }

    public void delete(int solutionId){
        try(Connection connection = DBUtil.getConnection()){
            PreparedStatement statement = connection.prepareStatement(DELETE_SOLUTION_QUERY);
            statement.setInt(1,solutionId);
            statement.executeUpdate();
        }catch (SQLException exc){
            exc.printStackTrace();
        }
    }

    public List<Solution> findAll(){
        List<Solution> solutionList = new ArrayList<>();

        try(Connection connection = DBUtil.getConnection()){
            PreparedStatement statement = connection.prepareStatement(FIND_ALL_SOLUTION_QUERY);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                Solution solution = new Solution();
                solution.setId(resultSet.getInt("id_solution"));
                solution.setCreated(resultSet.getTimestamp("created"));
                solution.setUpdated(resultSet.getTimestamp("updated"));
                solution.setDescription(resultSet.getString("description"));
                solution.setExerciseId(resultSet.getInt("exercise_id"));
                solution.setUserId(resultSet.getInt("user_id"));

                solutionList.add(solution);
            }
            return solutionList;
        }catch (SQLException exc){
            exc.printStackTrace();
            return null;
        }
    }

    public List<Solution> findAllByUserId(int userId){
        List<Solution> solutionList = new ArrayList<>();
        try(Connection connection = DBUtil.getConnection()){
            PreparedStatement statement = connection.prepareStatement(FIND_ALL_BY_USER_ID_QUERY);
            statement.setInt(1,userId);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                Solution solution = new Solution();
                solution.setId(resultSet.getInt("id_solution"));
                solution.setCreated(resultSet.getTimestamp("created"));
                solution.setUpdated(resultSet.getTimestamp("updated"));
                solution.setDescription(resultSet.getString("description"));
                solution.setExerciseId(resultSet.getInt("exercise_id"));
                solution.setUserId(resultSet.getInt("user_id"));

                solutionList.add(solution);
            }
            return solutionList;
        }catch (SQLException exc){
            exc.printStackTrace();
            return null;
        }
    }
    public List<Solution> findAllByExerciseId(int exerciseId){
        List<Solution> solutionList = new ArrayList<>();
        try(Connection connection = DBUtil.getConnection()){
            PreparedStatement statement = connection.prepareStatement(FIND_ALL_BY_EXERCISE_ID_QUERY);
            statement.setInt(1,exerciseId);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                Solution solution = new Solution();
                solution.setId(resultSet.getInt("id_solution"));
                solution.setDescription(resultSet.getString("description"));
                solution.setCreated(resultSet.getTimestamp("created"));
                solution.setUpdated(resultSet.getTimestamp("updated"));
                solution.setExerciseId(resultSet.getInt("exercise_id"));
                solution.setUserId(resultSet.getInt("user_id"));

                solutionList.add(solution);
            }
            return solutionList;
        }catch (SQLException exc){
            exc.printStackTrace();
            return null;
        }
    }
    public List<Solution> findLastFiveSolution(){
        List<Solution> lastFiveSolution = new ArrayList<>();
        try(Connection connection = DBUtil.getConnection()){
            PreparedStatement statement = connection.prepareStatement(GET_LAST_FIVE_SOLUTION);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                Solution lastFive = new Solution();
                lastFive.setId(resultSet.getInt("id_solution"));
                lastFive.setCreated(resultSet.getTimestamp("created"));
                lastFive.setUpdated(resultSet.getTimestamp("updated"));
                lastFive.setDescription(resultSet.getString("description"));
                lastFive.setExerciseId(resultSet.getInt("exercise_id"));
                lastFive.setUserId(resultSet.getInt("user_id"));

                lastFiveSolution.add(lastFive);
            }
        }catch (SQLException exc){
            exc.printStackTrace();
            return null;
        }
        return lastFiveSolution;
    }

}
