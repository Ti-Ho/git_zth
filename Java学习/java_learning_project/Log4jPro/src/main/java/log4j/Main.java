//3.Main
package log4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Main {
    public static void main(String args[]) throws InterruptedException{
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Print prt = (Print)context.getBean("ProxyFactory");
        prt.print();
    }
}
