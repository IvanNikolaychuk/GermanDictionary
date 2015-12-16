package context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppContext {
    private static ApplicationContext instance;

    public static ApplicationContext getAppContext() {
        if ( instance == null ) {
            initContext();
        }
        return instance;
    }

    private static void initContext() {
        String[] appContexts = new String[]{ "spring-context.xml" };
        instance = new ClassPathXmlApplicationContext( appContexts );
    }
}
