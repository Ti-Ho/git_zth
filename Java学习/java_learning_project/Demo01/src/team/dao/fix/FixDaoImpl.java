package team.dao.fix;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import team.utils.DbUtils;

public class FixDaoImpl implements FixDao{

	@Override
	public List<String> getAllFixs() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Gson gson = new Gson();
		List<String> lists = new ArrayList<String>();
		String sql = "select * from fix";
		try {
			conn = DbUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				lists.add(gson.toJson(new Fix(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6))));
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
	public List<String> getFixByStatus3() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Gson gson = new Gson();
		List<String> lists = new ArrayList<String>();
		String sql = "select * from fix where status = 3";
		try {
			conn = DbUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				lists.add(gson.toJson(new Fix(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6))));
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
	public String getWorkload(String number) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select workload from fix where number = ?" ;
		String workload = null;
		try {
			conn = DbUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, number);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				workload = rs.getString("workload");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtils.close(rs);
			DbUtils.close(pstmt);
			DbUtils.close(conn);
		}
		return workload;
	}

	@Override
	public void deleteFix(String number) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DbUtils.getConnection();
			String sql = "delete from fix where number = ?";
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
	public void insertFix(String number) {
		Connection conn = null;
        PreparedStatement pstmt = null;
        conn = DbUtils.getConnection();
        String  sql1="insert into fix values(?,null,null,null,null,?)";
        try {
        	pstmt=conn.prepareStatement(sql1);
        	pstmt.setString(1, number);
        	pstmt.setString(2, "0");
            pstmt.executeUpdate();
        }
        catch (SQLException e) {
        	e.printStackTrace();
        }
        finally {
       	 DbUtils.close(pstmt);
           DbUtils.close(conn);
        }

		
	}

	@Override
	public Fix searchFix(String number) {
		Connection  conn=null;
		PreparedStatement  pstmt=null;
		ResultSet  rs=null;
		String sql = "select * from fix where number=?";
		Fix fix = new Fix();
		try {
			conn = DbUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, number);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				fix.setNumber(rs.getString("number"));
				fix.setfix_people(rs.getString("fix_people"));
				fix.setdetection_record(rs.getString("detection_record"));
				fix.setfix_record(rs.getString("fix_record"));
				fix.setWorkload(rs.getString("workload"));
				fix.setStatus(rs.getString("status"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtils.close(rs);
			DbUtils.close(pstmt);
			DbUtils.close(conn);
		}
		return fix;
	}

	@Override
	public List<Fix> getAllFixsInTask() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Fix> lists = new ArrayList<Fix>();
		try {
			conn = DbUtils.getConnection();
			String sql = "select * from fix";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				lists.add(new Fix(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
			} 
			
			
			
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			DbUtils.close(rs);
			DbUtils.close(pstmt);
			DbUtils.close(conn);
		}
		return lists;
	}

	@Override
	public void updateFixInTask(String number, String fix_people) {
		Connection  conn=null;
		PreparedStatement  pstmt=null;
		try {
			conn=DbUtils.getConnection();	
			String  sql="update fix set fix_people = ?, status = 1 where number = ?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, fix_people);
			pstmt.setString(2, number);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			DbUtils.close(pstmt);
			DbUtils.close(conn);
		}
	}

	@Override
	public void deleteFixIntask(String number) {
		Connection  conn=null;
		PreparedStatement  pstmt=null;
		try {
			conn=DbUtils.getConnection();	
				String  sql="delete from fix where number = ?";
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, number);
				pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbUtils.close(pstmt);
			DbUtils.close(conn);
		}
	}

	@Override
	public Fix getFixByNumber(String number) {
		Connection  conn=null;
		PreparedStatement  pstmt=null;
		ResultSet  rs=null;
		Fix fix = new Fix();
		try {
			conn = DbUtils.getConnection();
			String  sql="select* from fix where number = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, number);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				fix.setNumber(rs.getString("number"));
				fix.setfix_people(rs.getString("fix_people"));
				fix.setdetection_record(rs.getString("detection_record"));
				fix.setfix_record(rs.getString("fix_record"));
				fix.setWorkload(rs.getString("workload"));
				fix.setStatus(rs.getString("status"));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DbUtils.close(rs);
			DbUtils.close(pstmt);
			DbUtils.close(conn);
		}
		return fix;
	}

	@Override
	public List<Fix> getAllFixInTech(String Fix_people) {
		List<Fix> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        conn = DbUtils.getConnection();
        ResultSet rs = null;
        String  sql="select * from fix where fix_people = ?";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1, Fix_people);
            rs = pstmt.executeQuery();
            while(rs.next())
            {
            	String number = rs.getString("number");
            	String fix_people = rs.getString("fix_people");
            	String detection_record = rs.getString("detection_record");
            	String fix_record = rs.getString("fix_record");
            	String workload = rs.getString("workload");
            	String status = rs.getString("status");
            	list.add(new Fix(number,fix_people,detection_record,fix_record,workload,status));
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
	public List<Fix> getFixByNumberInTech(String Number, String Fix_people) {
		List<Fix> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DbUtils.getConnection();
		ResultSet rs = null;
		String sql = "select * from fix where number = ? and fix_people = ?";
		//System.out.println("Dao : number： " + Number + ", Fix_people: " + Fix_people);
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1, Number);
            pstmt.setString(2, Fix_people);
            rs = pstmt.executeQuery();
            while(rs.next())
            {
            	String number = rs.getString("number");
            	String fix_people = rs.getString("fix_people");
            	String detection_record = rs.getString("detection_record");
            	String fix_record = rs.getString("fix_record");
            	String workload = rs.getString("workload");
            	String status = rs.getString("status");
//                System.out.println(name);
//                System.out.println(password);
            	list.add(new Fix(number,fix_people,detection_record,fix_record,workload,status));
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
	public void updateFix(Fix fix) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DbUtils.getConnection();
		String sql = "update fix set fix_people = ? , detection_record = ? , fix_record = ? , workload = ? , status = ? where number = ?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, fix.getfix_people());
			pstmt.setString(2, fix.getdetection_record());
			pstmt.setString(3, fix.getfix_record());
			pstmt.setString(4, fix.getWorkload());
			pstmt.setString(5, fix.getStatus());
			pstmt.setString(6, fix.getNumber());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
