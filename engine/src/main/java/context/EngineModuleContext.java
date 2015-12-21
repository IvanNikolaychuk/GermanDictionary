package context;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EngineModuleContext {
    private static ApplicationContext instance;

    public static ApplicationContext getContext() {
        if ( instance == null ) {
            initContext();
        }
        return instance;
    }

    private static void initContext() {
        String[] appContexts = new String[]{ "engine-spring-context.xml" };
        instance = new ClassPathXmlApplicationContext( appContexts );
    }
}
