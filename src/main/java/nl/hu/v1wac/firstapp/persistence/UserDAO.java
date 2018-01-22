package nl.hu.v1wac.firstapp.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO extends BaseDAO {
	 public String findRoleForUsernameAndPassword(String username, String password) {
	 String role = null;
	 char x = '"';
	 String query = "SELECT role FROM "+x+"USERACCOUNT"+x+" WHERE username = ? AND password = ?";

	 try (Connection con = super.getConnection()) {

	 PreparedStatement pstmt = con.prepareStatement(query);
	 pstmt.setString(1, username);
	 pstmt.setString(2, password);
	 System.out.println(pstmt);
	 ResultSet rs = pstmt.executeQuery();
	 if (rs.next())
	 role = rs.getString("role");

	 } catch (SQLException sqle) {
	 sqle.printStackTrace();
	 }
	 System.out.println("Rol="+role);
	 return role;
	 }
	}