package pl.matkoc.dao;

import pl.matkoc.DBUtil;
import pl.matkoc.model.Group;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GroupDao {

    private final String CREATE_GROUP_QUERY =
            "INSERT INTO user_group(name) VALUES(?)";
    private final String READ_GROUP_QUERY =
            "SELECT * FROM user_group WHERE id_group = ?";
    private final String UPDATE_GROUP_QUERY =
            "UPDATE user_group SET name = ? WHERE id_group = ?";
    private final String DELETE_GROUP_QUERY =
            "DELETE FROM user_group WHERE id_group = ?";
    private final String GET_ALL_GROUP =
            "SELECT * FROM user_group";
    private final String GET_LAST_FIVE_GROUP =
            "SELECT * FROM user_group ORDER BY id_group DESC LIMIT 5";

    public Group create(Group group){
        try(Connection connection = DBUtil.getConnection()){
            PreparedStatement statement =
                    connection.prepareStatement(CREATE_GROUP_QUERY,PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1,group.getName());
            statement.executeUpdate();

            ResultSet resultSet = statement.getGeneratedKeys();
            if(resultSet.next()){
                group.setId(resultSet.getInt(1));
            }
            return group;
        }catch (SQLException exc){
            exc.printStackTrace();
            return null;
        }
    }

    public Group read(int groupId){
        try(Connection connection = DBUtil.getConnection()){
            PreparedStatement statement = connection.prepareStatement(READ_GROUP_QUERY);
            statement.setInt(1,groupId);
            ResultSet resultSet = statement.executeQuery();

            Group group = new Group();
            while(resultSet.next()){
                group.setId(resultSet.getInt("id_group"));
                group.setName(resultSet.getString("name"));
            }
            return group;
        }catch (SQLException exc){
            exc.printStackTrace();
            return null;
        }
    }

    public void update (Group group){
        try(Connection connection = DBUtil.getConnection()){
            PreparedStatement statement = connection.prepareStatement(UPDATE_GROUP_QUERY);
            statement.setString(1,group.getName());
            statement.setInt(2,group.getId());
            statement.executeUpdate();
        }catch (SQLException exc){
            exc.printStackTrace();
        }
    }
    public void delete(int id){
        try(Connection connection = DBUtil.getConnection()){
            PreparedStatement statement = connection.prepareStatement(DELETE_GROUP_QUERY);
            statement.setInt(1,id);
            statement.executeUpdate();
            System.out.println("Usunieto obiekt z bazy.");
        }catch (SQLException exc){
            exc.printStackTrace();
        }
    }

    public List<Group> findAll() {
        List<Group> groupList = new ArrayList<>();
        try(Connection connection = DBUtil.getConnection()){
            PreparedStatement statement = connection.prepareStatement(GET_ALL_GROUP);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Group group = new Group();
                group.setId(resultSet.getInt("id_group"));
                group.setName(resultSet.getString("name"));

                groupList.add(group);
            }
            return groupList;
        }catch (SQLException exc){
            exc.printStackTrace();
            return null;
        }
    }
    public List<Group> findFiveLastGroup(){
        List<Group> lastFiveGroup = new ArrayList<>();
        try(Connection connection = DBUtil.getConnection()){
            PreparedStatement statement = connection.prepareStatement(GET_LAST_FIVE_GROUP);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                Group groupFive = new Group();
                groupFive.setId(resultSet.getInt("id_group"));
                groupFive.setName(resultSet.getString("name"));

                lastFiveGroup.add(groupFive);
            }
        }catch (SQLException exc){
            exc.printStackTrace();
            return null;
        }
        return lastFiveGroup;
    }
}
