//2.BeforeAdvice
package log4j;
import java.lang.reflect.Method;
import org.apache.log4j.Logger;
import org.springframework.aop.MethodBeforeAdvice;
public class BeforeAdvice implements MethodBeforeAdvice {
    public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable{
        Logger log = Logger.getLogger(BeforeAdvice.class);
        log.info("方法调用前");
    }
}
