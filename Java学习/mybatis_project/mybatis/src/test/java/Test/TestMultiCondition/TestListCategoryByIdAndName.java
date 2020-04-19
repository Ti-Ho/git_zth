package Test.TestMultiCondition;

import com.how2java.pojo.Category;
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
 * @date 2020/4/18 15:56
 */
public class TestListCategoryByIdAndName {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", 3);
        params.put("name", "cat");

        List<Category> cs = session.selectList("listCategoryByIdAndName", params);
        for(Category ci: cs){
            System.out.println(ci.getName());
        }

        session.commit();
        session.close();

    }
}
