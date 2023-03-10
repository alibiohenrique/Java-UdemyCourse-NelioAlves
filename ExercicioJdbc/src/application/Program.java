package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;

public class Program {

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DB.getConnection();
			ps = conn.prepareStatement(
					"UPDATE seller " + "SET BaseSalary = BaseSalary + ? " + "WHERE " + "(DepartmentId = ? )");
			ps.setDouble(1, 200);
			ps.setInt(2, 1);

			int rowsAffected = ps.executeUpdate();

			System.out.println("Done! Rows updated " + rowsAffected);

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			DB.closeStatement(ps);
			DB.closeConnection();
		}
	}

}