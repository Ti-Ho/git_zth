package team.dao.backup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.Result;

import team.utils.DbUtils;

public class BackupDaoImpl implements BackupDao {

	@Override
	public List<Backup> getAllBackups() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from backup";
		List<Backup> lists = new ArrayList<Backup>();
		try {
			conn = DbUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				lists.add(new Backup(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
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
	public List<Backup> getBackupsByNameAndType(String name, String type) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from backup where name=? and type=?";
		List<Backup> lists = new ArrayList<Backup>();
		try {
			conn = DbUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, type);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				lists.add(new Backup(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
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
	public String getAmountOfBackup(String name, String type) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String amount = null;
		String sql = "select amount from backup where name=? and type=?";
		try {
			conn = DbUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, type);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				amount = rs.getString("amount");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtils.close(rs);
			DbUtils.close(pstmt);
			DbUtils.close(conn);
		}
		return amount;
	}

	@Override
	public String getDeadlineOfBackup(String name, String type) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String deadline = null;
		String sql = "select deadline from backup where name=? and type=?";
		try {
			conn = DbUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, type);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				deadline = rs.getString("deadline");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtils.close(rs);
			DbUtils.close(pstmt);
			DbUtils.close(conn);
		}
		return deadline;
	}

	@Override
	public void updateAmountOfBackup(String name, String type, String amount) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update backup set amount=?  where name =? and type=?";
		try {
			conn = DbUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, amount);
			pstmt.setString(2, name);
			pstmt.setString(3, type);
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtils.close(pstmt);
			DbUtils.close(conn);
		}
	}

	@Override
	public void updateStatusOfBackup(String name, String type, String status) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update backup set status=?  where name =? and type=?";
		try {
			conn = DbUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, status);
			pstmt.setString(2, name);
			pstmt.setString(3, type);
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtils.close(pstmt);
			DbUtils.close(conn);
		}
	}

	@Override
	public void insertBackup(Backup backup) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into backup values (?, ?, ?, ?, ?, ?, ?)";
		try {
			conn = DbUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, backup.getName());
			pstmt.setString(2, backup.getType());
			pstmt.setString(3, backup.getPrice());
			pstmt.setString(4, backup.getAmount());
			pstmt.setString(5, backup.getIn_time());
			pstmt.setString(6, backup.getDeadline());
			pstmt.setString(7, backup.getStatus());
			pstmt.executeUpdate();
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			DbUtils.close(pstmt);
			DbUtils.close(conn);
		}
	}

	@Override
	public boolean searchBackup(String name, String type) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean flag = false;
		String sql = "select * from backup where name = ? and type = ?";
		try {
			conn = DbUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, type);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				flag = true;
			}
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			DbUtils.close(pstmt);
			DbUtils.close(conn);
		}
		return flag;
	}

	@Override
	public String getPriceOfBackup(String name, String type) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String price = null;
		String sql = "select price from backup where name=? and type=?";
		try {
			conn = DbUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, type);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				price = rs.getString("price");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtils.close(rs);
			DbUtils.close(pstmt);
			DbUtils.close(conn);
		}
		return price;
	}
	
	
}
