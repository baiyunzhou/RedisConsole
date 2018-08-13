package com.zby.util;

import java.util.Properties;

public abstract class RedisPropertiesUtil {
	private static final String REDIS_HOST_KEY = "redis.host";
	private static final String REDIS_PORT_KEY = "redis.port";
	private static final String DEFAULT_PROPERTIES_LOCATION = "redis.properties";
	private static final String DEFAULT_HOST = "127.0.0.1";
	private static final String DEFAULT_PORT = "6379";
	private static final Properties properties;
	static {
		properties = new Properties();
		try {
			properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(DEFAULT_PROPERTIES_LOCATION));
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	public static String getHost() {
		return properties.getProperty(REDIS_HOST_KEY, DEFAULT_HOST);
	}

	public static int getPort() {
		return Integer.valueOf(properties.getProperty(REDIS_PORT_KEY, DEFAULT_PORT));
	}
}
