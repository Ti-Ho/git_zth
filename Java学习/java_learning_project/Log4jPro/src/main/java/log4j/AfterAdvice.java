//AfterAdvice
package log4j;
import java.lang.reflect.Method;
import org.apache.log4j.Logger;
import org.springframework.aop.AfterReturningAdvice;
public class AfterAdvice implements AfterReturningAdvice {
    public void afterReturning(Object arg0, Method arg1, Object[] arg2, Object arg3) throws Throwable {
        Logger log = Logger.getLogger(AfterAdvice.class);
        log.info("方法调用后");
    }
}
