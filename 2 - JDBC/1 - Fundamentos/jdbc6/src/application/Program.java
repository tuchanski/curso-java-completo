package application;

import db.DB;
import db.DbException;
import db.DbIntegrityException;

import java.sql.*;

public class Program {
    public static void main(String[] args) {

        // Transactions with JDBC ->
        // setAutoCommit(false) -> each change u made is automatically applied if is true.
        // commit() -> apply transaction
        // rollback() -> undo what is done until this moment

        Connection dbConnection = null;
        Statement statement = null;

        try{
            dbConnection = DB.getConnection(); // Connecting with database

            dbConnection.setAutoCommit(false); // Wait for confirmation to REALLY change in DB
            statement = dbConnection.createStatement();

            int rows1 = statement.executeUpdate("UDATE coursejdbc.seller SET BaseSalary = 2090 WHERE DepartmentId = 1");
            int rows2 = statement.executeUpdate("UDATE coursejdbc.seller SET BaseSalary = 3090 WHERE DepartmentId = 2");

            dbConnection.commit(); // Confirmation

            System.out.println("rows1: " + rows1 + ", rows2: " + rows2);
        }

        catch (SQLException e){
            // If there's an error, rollback to do not change in database.
            try {
                dbConnection.rollback();
                throw new DbException("Transaction rolled back, error: " + e.getMessage());
            } catch (SQLException ex) {
                throw new DbException("Failed to rollback transaction, error: " + ex.getMessage());
            }
        }

        finally {
            DB.closeStatement(statement);
            DB.closeConnection();
        }

    }
}
