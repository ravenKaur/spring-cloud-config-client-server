package org.springframework.cloud.logging;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Collections;

import org.junit.After;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.logging.LogLevel;
import org.springframework.boot.logging.LoggingSystem;
import org.springframework.boot.test.EnvironmentTestUtils;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.cloud.context.environment.EnvironmentChangeEvent;

public class LoggingTests {

	private Logging rebinder = new Logging();
	private Logger logger = LoggerFactory.getLogger("org.springframework.web");
	
	@After
	public void reset() {
		LoggingSystem.get(getClass().getClassLoader()).setLogLevel("org.springframework.web", LogLevel.INFO);
	}

	@Test
	public void logLevelsChanged() {
		assertFalse(logger.isTraceEnabled());
		StandardEnvironment environment = new StandardEnvironment();
		EnvironmentTestUtils.addEnvironment(environment, "logging.level.org.springframework.web=TRACE");
		rebinder.setEnvironment(environment);
		rebinder.onApplicationEvent(new EnvironmentChangeEvent(Collections.singleton("logging.level.org.springframework.web")));
		assertTrue(logger.isTraceEnabled());
	}

}
