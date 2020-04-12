package team.dao.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import team.utils.DbUtils;



public class UserDaoImpl implements UserDao{

	@Override
	public boolean searchUser(User user) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean flag = false;
		try {
			conn = DbUtils.getConnection();
			String sql = "select account,password from user where role = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getRole());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String name = rs.getString(1);
                String password = rs.getString(2);
                if(name.equals(user.getAccount())&&password.equals(user.getPassword())){
                    flag = true;
                }
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtils.close(rs);
			DbUtils.close(pstmt);
			DbUtils.close(conn);
		}
		return flag;
	}

	@Override
	public List<String> getAllUsers() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Gson gson = new Gson();
		//List<User> users = new ArrayList<User>();
		List<String> lists = new ArrayList<String>();
		try {
			conn = DbUtils.getConnection();
			String sql = "select * from user";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				lists.add(gson.toJson(new User(rs.getString("account"), rs.getString("password"), rs.getString("role"))));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtils.close(rs);
			DbUtils.close(pstmt);
			DbUtils.close(conn);
		}
		return lists;
	}

	@Override
	public void deleteUser(String account) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DbUtils.getConnection();
			String sql = "delete from user where account = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtils.close(pstmt);
			DbUtils.close(conn);
		}
		
	}

	@Override
	public void updateUser(String account, String password, String role) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DbUtils.getConnection();
			String sql = "update user set password = ?, role = ? where account = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, password);
			pstmt.setString(2, role);
			pstmt.setString(3, account);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtils.close(pstmt);
			DbUtils.close(conn);
		}
		
	}

	@Override
	public List<String> getUserByRole(String role) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Gson gson = new Gson();
		List<String> lists = new ArrayList<String>();
		try {
			conn = DbUtils.getConnection();
			String sql = "select * from user where role = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, role);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				lists.add(gson.toJson(new User(rs.getString("account"), rs.getString("password"), rs.getString("role"))));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtils.close(rs);
			DbUtils.close(pstmt);
			DbUtils.close(conn);
		}
		return lists;
	}

	@Override
	public void addUser(String account, String password, String role) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DbUtils.getConnection();
			String sql = "insert into user values ( ?,?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account);
			pstmt.setString(2, password);
			pstmt.setString(3, role);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtils.close(pstmt);
			DbUtils.close(conn);
		}
		
	}
	
	
}
