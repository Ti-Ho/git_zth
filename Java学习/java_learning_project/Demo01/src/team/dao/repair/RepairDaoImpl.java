package team.dao.repair;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import team.utils.DbUtils;

public class RepairDaoImpl implements RepairDao{

	@Override
	public void insertRepair(Repair repair) {
		Connection conn = null;
        PreparedStatement pstmt = null;
        conn = DbUtils.getConnection();
        String  sql="insert into repair values(?, ?, ?, ?, ?, ?, ?)";
		try {
			conn = DbUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, repair.getNumber());
			pstmt.setString(2, repair.getclient_number());
			pstmt.setString(3, repair.getproduct_type());
			pstmt.setString(4, repair.getfault_phenomena());
			pstmt.setString(5, repair.getfault_type());
			pstmt.setString(6, repair.getTime());
			pstmt.setString(7, repair.getStatus());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtils.close(pstmt);
       	 	DbUtils.close(conn);
		}
	}

	@Override
	public void deleteRepair(String number) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DbUtils.getConnection();
			String sql = "delete from repair where number = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, number);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtils.close(pstmt);
			DbUtils.close(conn);
		}
	}

	@Override
	public List<String> getRepair() {
		List<String> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        conn = DbUtils.getConnection();
        ResultSet rs = null;
        String  sql="select * from repair where status != " + "2";
        Gson  gson = new Gson();
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.execute();
            rs = pstmt.getResultSet();
            while(rs.next())
            {
                String number = rs.getString(1);
                String client_number = rs.getString(2);
                String product_type = rs.getString(3);
                String fault_phenomena = rs.getString(4);
                String fault_type = rs.getString(5);
                String time = rs.getString(6);
                String status = rs.getString(7);
                
                list.add(gson.toJson(new Repair(number,client_number,product_type,fault_phenomena,fault_type,time,status)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
        	 DbUtils.close(rs);
        	 DbUtils.close(pstmt);
            DbUtils.close(conn);
        }
    	return  list;
	}

	@Override
	public void updateStatusTo2(String number) {
		Connection conn = null;
        PreparedStatement pstmt = null;
        conn = DbUtils.getConnection();
        String  sql="update repair set status = ? where number = ?";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1, "2");
            pstmt.setString(2, number);
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
        	 DbUtils.close(pstmt);
             DbUtils.close(conn);
        }
	}
	
}
