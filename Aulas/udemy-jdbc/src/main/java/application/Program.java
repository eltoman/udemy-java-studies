package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DbException;

public class Program {

    public static void main(String args[]){
        //querySeller();
        transaction();
    }

    private static void transaction(){

        Connection conn = null;
        Statement st = null;
        try {
            conn = DB.getConnection();

            conn.setAutoCommit(false);

            st = conn.createStatement();

            System.out.println("update numero 1");
            int rows1 = st.executeUpdate("UPDATE seller SET BaseSalary = 2090 WHERE DepartmentId = 1");

            //int x = 1;
            //if (x < 2) {
            //	throw new SQLException("Fake error");
            //}
            System.out.println("update numero 2");
            int rows2 = st.executeUpdate("UPDATE seller SET BaseSalary = 3090 WHERE DepartmentId = 2");

            conn.commit();
            System.out.println("commit done");

            System.out.println("rows1 = " + rows1);
            System.out.println("rows2 = " + rows2);
        }
        catch (SQLException e) {
            try {
                conn.rollback();
                throw new DbException("Transaction rolled back! Caused by: " + e.getMessage());
            }
            catch (SQLException e1) {
                throw new DbException("Error trying to rollback! Caused by: " + e1.getMessage());
            }
        }
        finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }

    private static void querySeller(){

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try{
            conn = DB.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("select * from seller");

            while (rs.next()){
                System.out.println(rs.getInt("Id") + " - "  + rs.getDouble("BaseSalary"));
            }

        }catch (SQLException ex){
            ex.printStackTrace();
        }finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}
