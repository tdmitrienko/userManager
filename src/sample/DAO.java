package sample;

import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface DAO {
    Connection dbConnect();
    void dbDisconnect() throws SQLException;
    ResultSet dbExecuteQueryDao(String queryStmt) throws SQLException, ClassNotFoundException;
    void dbExecuteUpdateDao(String sqlStmt) throws SQLException, ClassNotFoundException;
    void updateUsersDao (ObservableList<User> users);
    ObservableList<User> create (String query) throws SQLException;
    void createDbUserTableDao() throws SQLException;
}
