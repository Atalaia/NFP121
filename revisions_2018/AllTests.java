
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import java.util.Properties;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import java.util.Properties;
public class AllTests extends junit.framework.TestCase{

    static{
        Properties propsSystem = System.getProperties();
        //propsSystem.setProperty("verbose","true");
        propsSystem.setProperty("verbose","false");
    }

    public void testAll() throws Exception{
        String res = execution(martin_fowler.MartinFowlerExampleTests.class);
        execution(container.FileSystemPropsApplicationContextTest.class);
        execution(container.FactoryTest.class);
        
        execution(exemples.ExemplesTests.class);
        execution(proxy.ProxyTests.class);
        execution(strategy.StrategyTests.class);
        execution(command.CommandTests.class);
        execution(observer.ObserverCommandTests.class);
        execution(chain_of_responsability.CoRTests.class);
        execution(facade.FacadeTests.class);
        execution(state.StateTests.class);
        execution(service_locator.ServiceLocatorTests.class);
    }

    private static String execution(Class<?> classeDeTests){
        Result result = JUnitCore.runClasses(classeDeTests);
        String res = new String("");
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
            res = res + failure.toString() + "\n";
        }
        assertFalse(res, res.length()>0);
        return res;
    }
}