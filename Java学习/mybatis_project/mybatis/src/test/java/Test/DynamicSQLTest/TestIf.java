package Test.DynamicSQLTest;

import com.how2java.pojo.Product;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Kai
 * @date 2020/4/19 17:57
 */
public class TestIf {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();

        System.out.println("查询所有的");
        List<Product> ps = session.selectList("listProduct");
        for (Product p : ps) {
            System.out.println(p);
        }

        System.out.println("模糊查询");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("name","a");
        List<Product> ps2 = session.selectList("listProduct",params);
        for (Product p : ps2) {
            System.out.println(p);
        }

        session.commit();
        session.close();

    }
}
