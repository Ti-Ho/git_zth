package team.dao.backupflow;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import team.utils.DbUtils;

public class BackupFlowDaoImpl implements BackupFlowDao{

	@Override
	public void insertBackupFlow(BackupFlow backupFlow) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into backupflow values (?, ?, ?, ?, ?, ?)";
		try {
			conn = DbUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, backupFlow.getName());
			pstmt.setString(2, backupFlow.getType());
			pstmt.setString(3, backupFlow.getFixNumber());
			pstmt.setString(4, backupFlow.getAmount());
			pstmt.setString(5, backupFlow.getPrice());
			pstmt.setString(6, backupFlow.getOutTime());
			pstmt.executeUpdate();
		}catch (SQLException e){
			e.printStackTrace();
		} finally {
			DbUtils.close(pstmt);
			DbUtils.close(conn);
		}
		
	}

	@Override
	public List<BackupFlow> getAllBackupFlows() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from backupflow";
		List<BackupFlow> lists = new ArrayList<BackupFlow>();
		try {
			conn = DbUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				lists.add(new BackupFlow(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
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
	public String getPrice(String fix_number) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select price from backupflow where fix_number = ?";
		String price = null;
		try {
			conn = DbUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, fix_number);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				price = rs.getString("price");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtils.close(rs);
			DbUtils.close(pstmt);
			DbUtils.close(conn);
		}
		return price;
	}

	@Override
	public String getAmount(String fix_number) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select amount from backupflow where fix_number = ?";
		String amount = null;
		try {
			conn = DbUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, fix_number);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				amount = rs.getString("amount");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtils.close(rs);
			DbUtils.close(pstmt);
			DbUtils.close(conn);
		}
		return amount;
	}
	
}
