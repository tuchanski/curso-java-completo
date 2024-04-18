package application;

import db.DB;
import db.DbException;
import db.DbIntegrityException;

import java.sql.*;

public class Program {
    public static void main(String[] args) {

        // Deleting table

        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

        try{
            dbConnection = DB.getConnection(); // Connecting with database
            preparedStatement = dbConnection.prepareStatement(
                    "DELETE FROM coursejdbc.department "
                    + "WHERE "
                    + "Id = ?");

            preparedStatement.setInt(1, 2);

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);
        }
        catch (SQLException e){
            throw new DbIntegrityException(e.getMessage());
        }
        finally {
            DB.closeStatement(preparedStatement);
            DB.closeConnection();
        }

    }
}
