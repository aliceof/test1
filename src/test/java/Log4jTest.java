import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

public class Log4jTest {
    @Test
    public void test1(){

    Logger logger = Logger.getLogger(String.valueOf(Log4jTest.class));

    logger.info("alice");}
}
