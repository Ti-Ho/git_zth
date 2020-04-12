package team.dao.client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import team.utils.DbUtils;

public class ClientDaoImpl implements ClientDao{

	@Override
	public boolean searchClientByNumber(String number) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String  sql="select * from client where number = ?";
        boolean flag = false;
        try {
        	conn = DbUtils.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,number);
            rs = pstmt.executeQuery();
            if(rs.next()) {
            	flag=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DbUtils.close(rs);
            DbUtils.close(pstmt);
            DbUtils.close(rs);
        }
        return flag;
	}

	@Override
	public List<String> getAllClients() {
		List<String> lists = new ArrayList<String>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String  sql="select * from client";
        Gson  gson = new Gson();
        gson=new Gson();
        try {
        	conn = DbUtils.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.execute(sql);
            rs = pstmt.getResultSet();
            while(rs.next()){
                lists.add(gson.toJson(new Client(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
        	 DbUtils.close(rs);
        	 DbUtils.close(pstmt);
            DbUtils.close(conn);
        }
        return lists;
	}
	
	
	@Override
	public List<String> getClientByIDNumber(String ID_number) {
		List<String> lists = new ArrayList<String>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String  sql="select * from client where ID_number = " + ID_number;
        Gson  gson = new Gson();
        gson=new Gson();
        try {
        	conn = DbUtils.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.execute(sql);
            rs = pstmt.getResultSet();
            while(rs.next()){
                lists.add(gson.toJson(new Client(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
        	 DbUtils.close(rs);
        	 DbUtils.close(pstmt);
            DbUtils.close(conn);
        }
        return lists;
	}

	@Override
	public boolean deleteClient(String ID_number) {
		Connection conn = null;
        PreparedStatement pstmt = null;
        String  sql="delete from client where ID_number=" + ID_number;
        boolean flag = true;
        try {
        	conn = DbUtils.getConnection();
        	pstmt=conn.prepareStatement(sql);
            pstmt.executeUpdate();
        }
        catch (SQLException e) {
        	e.printStackTrace();
        	flag = false;
        }
        finally {
       	 DbUtils.close(pstmt);
           DbUtils.close(conn);
        }
        return flag;
	}

	@Override
	public void insertClient(Client client) {
		Connection conn = null;
        PreparedStatement pstmt = null;
        String  sql="insert into client values(?, ?, ?, ?)";
        try {
        	conn = DbUtils.getConnection();
        	pstmt=conn.prepareStatement(sql);
        	pstmt.setString(1, client.getNumber());
            pstmt.setString(2, client.getID_number());
        	pstmt.setString(3, client.getPhone());
            pstmt.setString(4, client.getEmail());
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
	public void updateClient(Client client) {
		Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = "update client set phone = ?, email = ? where number = ?";
        try {
        	conn = DbUtils.getConnection();
        	pstmt=conn.prepareStatement(sql);
            pstmt.setString(1, client.getPhone());
            pstmt.setString(2, client.getEmail());
            pstmt.setString(3, client.getNumber());
            pstmt.executeUpdate();
        } catch (SQLException e) {
        	e.printStackTrace();
        } finally {
       	 	DbUtils.close(pstmt);
       	 	DbUtils.close(conn);
        }
	}

	@Override
	public String getNumberOfClient(String ID_number) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String str = null;
        String  sql="select number from client where ID_number = " + ID_number;
        try {
        	conn = DbUtils.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.execute(sql);
            rs = pstmt.getResultSet();
            while(rs.next()){
            	str = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
        	 DbUtils.close(rs);
        	 DbUtils.close(pstmt);
            DbUtils.close(conn);
        }
        return str;
	}


	
}
