package sample;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public TableView<User> table;
    public TableColumn idColumn;
    public TableColumn loginColmn;
    public TableColumn passwordColmn;
    public TextField strokapoiska;
    public DAO dao= new DBConnect();
    public ObservableList<User> users = null;
    public ObservableList<User> tableData = null;
    public TextField numberdobav;
    public TextField logindobav;
    public TextField passworddobav;
    public TextField loginydalenie;
    public TextField loginizmen;
    public TextField pasOldizmen;
    public TextField pasNewizmn;

    @Override
    public void initialize(URL location, ResourceBundle resources){
        Connection connection= dao.dbConnect();

     /*   String s="DROP TABLE users";
        try {
            dao.dbExecuteUpdateDao(s);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/

        try {
            dao.createDbUserTableDao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String query ="Select * from users";

        try {
            users= dao.create(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

       /* users.add(new User("Robert","1234"));
        dao.updateUsersDao(users);
        users.add(new User("Nikola","qazxdr1234"));
        dao.updateUsersDao(users);
        users.add(new User("Petro","sobaka"));
        dao.updateUsersDao(users);*/

        ResultSet resultSet = null;
        try {
            resultSet = dao.dbExecuteQueryDao(query);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        while (true) {
            try {

                if (!resultSet.next())
                    break;
                else {
                    idColumn.setCellValueFactory(new PropertyValueFactory<User, Integer>("uuid"));
                    loginColmn.setCellValueFactory(new PropertyValueFactory<User, String>("username"));
                    passwordColmn.setCellValueFactory(new PropertyValueFactory<User, String>("password"));
                    table.setItems(users);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            tableData = table.getItems();
        }


    }

    public void poisk(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String log=strokapoiska.getText();
        String zapros="Select * from users where USERNAME='"+log+"'";
        ResultSet rez=dao.dbExecuteQueryDao(zapros);
        while (rez.next()) {
            User user = new User (Integer.parseInt(rez.getString(1)), rez.getString(2), rez.getString(3));
            tableData.clear();
            tableData.add(user); // добавляем строку
        }
    }

    public void dobavlenie(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String login=logindobav.getText();
        String passw=passworddobav.getText();
        users.add(new User(login,passw));
        dao.updateUsersDao(users);
        users.clear();
        String zapros="Select * from users";
        users=dao.create(zapros);
        tableData.clear();
        ResultSet rez=dao.dbExecuteQueryDao(zapros);
        while (rez.next()) {
            User user = new User (Integer.parseInt(rez.getString(1)), rez.getString(2), rez.getString(3));
            tableData.add(user); // добавляем строку
        }

    }

    public void clear(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String log=loginydalenie.getText();
        String s="DELETE from users where username='"+log+"'";
        dao.dbExecuteUpdateDao(s);
        users.clear();
        String zapros="Select * from users";
        users=dao.create(zapros);
        tableData.clear();
        ResultSet rez=dao.dbExecuteQueryDao(zapros);
        while (rez.next()) {
            User user = new User (Integer.parseInt(rez.getString(1)), rez.getString(2), rez.getString(3));
            tableData.add(user); // добавляем строку
        }
    }

    public void izmen(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String log=loginizmen.getText();
        String pasOld=pasOldizmen.getText();
        String pasNew=pasNewizmn.getText();
        String s="UPDATE users set password='"+pasNew+"' where username='"+log+"' and password='"+pasOld+"'";
        dao.dbExecuteUpdateDao(s);
        users.clear();
        String zapros="Select * from users";
        users=dao.create(zapros);
        tableData.clear();
        ResultSet rez=dao.dbExecuteQueryDao(zapros);
        while (rez.next()) {
            User user = new User (Integer.parseInt(rez.getString(1)), rez.getString(2), rez.getString(3));
            tableData.add(user); // добавляем строку
        }
    }
}