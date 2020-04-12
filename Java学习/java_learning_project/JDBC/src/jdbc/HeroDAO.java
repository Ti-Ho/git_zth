package jdbc;

import charactor.Hero;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HeroDAO implements DAO{
    public HeroDAO(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8","root","");
    }
    public int getTotal(){
        int total = 0;
        try(Connection conn = getConnection(); Statement s = conn.createStatement();){
            String sql = "select count(*) from hero";
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()){
                total = rs.getInt(1);
            }
            System.out.println("total:" + total);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return total;
    }

    @Override
    public void add(Hero hero) {
        String sql = "insert into hero values(null, ?, ?, ?)";
        try(Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql);){
            ps.setString(1, hero.name);
            ps.setFloat(2, hero.hp);
            ps.setInt(3, hero.damage);
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next())
                hero.id = rs.getInt(1);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Hero hero) {
        String sql = "update hero set name = ?, hp = ?, damage = ? where id = ?";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql);){
            ps.setString(1, hero.name);
            ps.setFloat(2, hero.hp);
            ps.setInt(3, hero.damage);
            ps.setInt(1, hero.id);
            ps.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try(Connection conn = getConnection(); Statement s = conn.createStatement();){
            String sql = "delete from hero where id = " + id;
            s.execute(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Hero get(int id) {
        Hero hero = null;
        try(Connection conn = getConnection(); Statement s = conn.createStatement();){
            String sql = "select * from hero where id = " + id;
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()){
                hero.name = rs.getString(2);
                hero.hp = rs.getFloat("hp");
                hero.damage = rs.getInt(4);
                hero.id = id;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return hero;
    }

    @Override
    public List<Hero> list() {
        return list(0, Short.MAX_VALUE);
    }

    @Override
    public List<Hero> list(int start, int count) {
        List<Hero> heros = new ArrayList<>();
        String sql = "select * from hero order by id desc limit ?, ?";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql);){
            ps.setInt(1, start);
            ps.setInt(2, count);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Hero h = new Hero();
                h.id = rs.getInt(1);
                h.name = rs.getString(2);
                h.hp = rs.getFloat(3);
                h.damage = rs.getInt(4);
                heros.add(h);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return heros;
    }
}
