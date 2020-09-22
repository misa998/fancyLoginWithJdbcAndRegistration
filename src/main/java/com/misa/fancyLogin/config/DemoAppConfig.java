package com.misa.fancyLogin.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.misa.fancyLogin")
@PropertySource("classpath:persistence-mysql.properties")
public class DemoAppConfig {

	// set up variable to hold the properties
	@Autowired
	private Environment env;
	
	// setup a logger
	private Logger logger = Logger.getLogger(getClass().getName());
	
	// define a bean for security data source
	@Bean
	public DataSource secDataSource() {
		// create connection pool
		ComboPooledDataSource securityDataSource = new ComboPooledDataSource();
		// set jdbc driver class
		try {
			securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException e) {
			throw new RuntimeException(e);
		}
		// log the conn properties
		logger.info(">>> jdbc.url= " + env.getProperty("jdbc.url"));
		// set db conn props
		securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		securityDataSource.setUser(env.getProperty("jdbc.user"));
		securityDataSource.setPassword(env.getProperty("jdbc.password"));
		// set connection pool props
		// reading integer property from file
		securityDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
		securityDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
		securityDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
		securityDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));
		
		return securityDataSource;
	}
	
	// need a helper method
	// read env property and convert to int
	private int getIntProperty(String propName) {
		String propValue = env.getProperty(propName);
		int i = Integer.parseInt(propValue);
		return i;
	}
	
	// define a bean for ViewResolver
	@Bean
	public ViewResolver viewResolver() {
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}	
	
	
}

