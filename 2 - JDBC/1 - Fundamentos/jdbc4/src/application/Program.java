package application;

import db.DB;
import db.DbException;

import java.sql.*;

public class Program {
    public static void main(String[] args) {

        // Updating tables

        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

        try{
            dbConnection = DB.getConnection(); // Connecting with database

            preparedStatement = dbConnection.prepareStatement(

                    "UPDATE coursejdbc.seller "
                    + "SET BaseSalary = BaseSalary + ? "
                    + "WHERE "
                    + "(DepartmentId = ?)");

            preparedStatement.setDouble(1, 200.0);
            preparedStatement.setInt(2, 2);

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);
        }
        catch (SQLException e){
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(preparedStatement);
            DB.closeConnection();
        }

    }
}
