package Test;

import com.how2java.pojo.Order;
import com.how2java.pojo.OrderItem;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author Kai
 * @date 2020/4/19 12:06
 */
public class TestManyToMany {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();

        List<Order> os = session.selectList("listOrder");
        for(Order o: os){
            System.out.println(o.getCode());
            List<OrderItem> ois = o.getOrderItems();
            for(OrderItem oi: ois){
                System.out.format("\t%s\t%f\t%d%n", oi.getProduct().getName(),oi.getProduct().getPrice(),oi.getNumber());
            }
        }
    }
}
