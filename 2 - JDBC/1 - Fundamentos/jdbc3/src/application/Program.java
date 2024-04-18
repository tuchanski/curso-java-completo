package application;

import db.DB;
import db.DbException;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Program {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Connection conn = null;
        // Creating new seller
        PreparedStatement st = null;
        try{
            conn = DB.getConnection(); // Connecting with database

            /*

            st = conn.prepareStatement(
                    "INSERT INTO coursejdbc.seller "
                            + "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
                            + "VALUES "
                            + "(?, ?, ?, ?, ?)",
                            Statement.RETURN_GENERATED_KEYS);

            // Setting ? to value
            st.setString(1, "Joao Afonso");
            st.setString(2, "joaoafonso@gmail.com");
            st.setDate(3, new java.sql.Date(sdf.parse("12/03/2004").getTime()));
            st.setDouble(4, 1550.50);
            st.setInt(5, 1);
            */

            st = conn.prepareStatement(
                    "INSERT INTO coursejdbc.department (Name) VALUES ('D5'), ('D6')",
                    Statement.RETURN_GENERATED_KEYS);

            // Executing updates
            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0){
                ResultSet rs = st.getGeneratedKeys();
                while (rs.next()){
                    int id = rs.getInt(1);
                    System.out.println(id);
                }
            }
            else{
                System.out.println("No records were inserted");
            }
        }

        catch(SQLException e){
            throw new DbException(e.getMessage());
        }

        finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}
