package webapp;

import static org.junit.Assert.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.AfterClass;
import org.junit.Test;

public class CommonsLogginTest {
	static Log log = LogFactory.getLog(CommonsLogginTest.class);
	
	@Test
	public void test() {
		log.trace("My Trace...");
		log.debug("My Debug...");
		log.info("My Info...");
		log.warn("My Warn....");
		log.error("My Error...");
		log.fatal("My Fatal....");
	}

}
