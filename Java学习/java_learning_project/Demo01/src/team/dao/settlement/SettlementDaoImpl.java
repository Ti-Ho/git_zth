package team.dao.settlement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import team.utils.DbUtils;

public class SettlementDaoImpl implements SettlementDao{

	@Override
	public void insertSettle(Settlement settlement) {
		Connection conn = null;
        PreparedStatement pstmt = null;
        conn = DbUtils.getConnection();
        String  sql="insert into settlement values(?, ?, ?, ?, ?)";
		try {
			conn = DbUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, settlement.getFix_number());
			pstmt.setString(2, settlement.getFix_money());
			pstmt.setString(3, settlement.getMaterial_money());
			pstmt.setString(4, settlement.getTotal_money());
			pstmt.setString(5, settlement.getSettle_time());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtils.close(pstmt);
       	 	DbUtils.close(conn);
		}
		
	}

	@Override
	public List<String> getAllSettle() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Gson gson = new Gson();
		List<String> lists = new ArrayList<String>();
		String sql = "select * from settlement";
		try {
			conn = DbUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				lists.add(gson.toJson(new Settlement(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5))));
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
	public void insertTmpSettle(Settlement settlement) {
		Connection conn = null;
        PreparedStatement pstmt = null;
        conn = DbUtils.getConnection();
        String  sql="insert into new_settlement values(?, ?, ?, ?, ?)";
		try {
			conn = DbUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, settlement.getFix_number());
			pstmt.setString(2, settlement.getFix_money());
			pstmt.setString(3, settlement.getMaterial_money());
			pstmt.setString(4, settlement.getTotal_money());
			pstmt.setString(5, settlement.getSettle_time());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtils.close(pstmt);
       	 	DbUtils.close(conn);
		}
		
	}

	@Override
	public List<String> getTmpSettle() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Gson gson = new Gson();
		List<String> lists = new ArrayList<String>();
		String sql = "select * from new_settlement";
		try {
			conn = DbUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				lists.add(gson.toJson(new Settlement(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5))));
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
	public void deleteTmpSettle(String fix_number) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DbUtils.getConnection();
			String sql = "delete from new_settlement where fix_number = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, fix_number);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtils.close(pstmt);
			DbUtils.close(conn);
		}
	}

	@Override
	public List<String> getSettleByNumber(String fix_number) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from settlement where fix_number = ?";
		List<String> lists = new ArrayList<String>();
		Gson gson = new Gson();
		try {
			conn = DbUtils.getConnection();
			pstmt=conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next()) {
            	lists.add(gson.toJson(new Settlement(rs.getString("fix_number"), rs.getString("fix_money"), rs.getString("material_money"), rs.getString("total_money"), rs.getString("settle_time"))));
            	
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
	public List<Settlement> getAllSettlement() {
		List<Settlement> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        conn = DbUtils.getConnection();
        ResultSet rs = null;
        String  sql="select * from settlement";
        try {
            pstmt=conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next())
            {
            	String fix_number = rs.getString("fix_number");
            	String fix_money = rs.getString("fix_money");
            	String material_money = rs.getString("material_money");
            	String total_money = rs.getString("total_money");
            	String settle_time = rs.getString("settle_time");
            	list.add(new Settlement(fix_number,fix_money,material_money,total_money,settle_time));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DbUtils.close(conn);
            DbUtils.close(pstmt);
            DbUtils.close(rs);
        }
        return list;
	}

	@Override
	public List<Settlement> getSettlementByNumber(String Fix_number) {
		List<Settlement> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DbUtils.getConnection();
		ResultSet rs = null;
		String sql = "select * from settlement where fix_number = "+Fix_number;
        try {
            pstmt=conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next())
            {
            	String fix_number = rs.getString("fix_number");
            	String fix_money = rs.getString("fix_money");
            	String material_money = rs.getString("material_money");
            	String total_money = rs.getString("total_money");
            	String settle_time = rs.getString("settle_time");
            	list.add(new Settlement(fix_number,fix_money,material_money,total_money,settle_time));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DbUtils.close(conn);
            DbUtils.close(pstmt);
            DbUtils.close(rs);
        }
        return list;
	}
	
}
