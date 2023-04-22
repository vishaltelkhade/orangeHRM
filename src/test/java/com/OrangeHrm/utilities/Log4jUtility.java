package com.OrangeHrm.utilities;

import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

public class Log4jUtility {
	private static final String LOG4J_XML_PATH = "./Configuration/log4j.xml";

    public static void configureLog4j() {
        Configurator.initialize(null, LOG4J_XML_PATH);
    }

   public static Logger getLogger(Class<?> clazz) {
        return LogManager.getLogger(clazz);
    }
}

