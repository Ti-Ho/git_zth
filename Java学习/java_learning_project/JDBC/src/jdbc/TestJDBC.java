package jdbc;

import charactor.Hero;

import java.sql.*;
import java.util.List;

public class TestJDBC {
    public static void main(String[] args) {
        DAO dao = new HeroDAO();
        List<Hero> l = dao.list(0, 5);
        for(Hero h : l){
            System.out.println(h.id + " " + h.name + " " + h.hp + " " + h.damage);
        }
    }
}
