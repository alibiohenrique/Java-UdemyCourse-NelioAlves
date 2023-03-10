package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;

public class Program {

	public static void main(String[] args) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DB.getConnection();
			ps = conn.prepareStatement("INSERT INTO seller " + "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
					+ "VALUES " + "(?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, "Josh Yellow");
			ps.setString(2, "Joshe@yellow.com");
			ps.setDate(3, new java.sql.Date(sdf.parse("05/05/1989").getTime()));
			ps.setDouble(4, 35000);
			ps.setInt(5, 2);

			int rowsAffecteds = ps.executeUpdate();
			if (rowsAffecteds > 0) {
				ResultSet rst =  ps.getGeneratedKeys();
				while (rst.next()) {
					int id = rst.getInt(1); 
					System.out.println("Done! Id: " + id);
				}
				
			}
			else {
				System.out.println("No rows affected");
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (ParseException e) {
			e.printStackTrace();
		} finally {
			DB.closeStatement(ps);
			DB.closeConnection();
		}
	}

}