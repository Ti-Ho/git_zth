package com.junit;

import com.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.omg.CORBA.UserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
//batis
public class TestMyBatis {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        List<Student> list1 = session.selectList("getAllStudent");
        for (Student stu : list1) System.out.println(stu.toString());
    }
}
