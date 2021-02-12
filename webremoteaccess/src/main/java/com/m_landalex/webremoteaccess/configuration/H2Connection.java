package com.m_landalex.webremoteaccess.configuration;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import com.m_landalex.webremoteaccess.exception.H2DatabaseNotCreated;

@EnableJpaRepositories(basePackages = "com.m_landalex.webremoteaccess.persistence")
@ComponentScan(basePackages = "com.m_landalex.webremoteaccess")
@PropertySource("classpath:application.properties")
@Configuration
public class H2Connection {

	private static final Logger logger = LoggerFactory.getLogger(H2Connection.class);
	
	@Value("${h2.hibernate.dialect}") private String hibernate_dialect;
	@Value("${hibernate.show_sql}") private String show_sql;
	@Value("${hibernate.use_sql_comments}") private String use_sql_comments;
	@Value("${hibernate.max_fetch_depth}") private String max_fetch_depth;
	@Value("${hibernate.jdbc.batch_size}") private String batch_size;
	@Value("${hibernate.jdbc.fetch_size}") private String fetch_size;
	@Value("${hibernate.hbm2ddl.auto}") private String hbm2ddl_auto;
	
	@Bean
	public DataSource dataSource() throws H2DatabaseNotCreated {
		try {
			return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).setName("H2 Database").build();
		} catch (Exception e) {
			logger.error("No database are created");
			throw new H2DatabaseNotCreated("Instantion of database is failed");
		}
	}
	
	public Properties getProperties() {
		Properties properties = new Properties();
		properties.setProperty("h2.hibernate.dialect", hibernate_dialect);
		properties.setProperty("hibernate.show_sql", show_sql);
		properties.setProperty("hibernate.use_sql_comments", use_sql_comments);
		properties.setProperty("hibernate.max_fetch_depth", max_fetch_depth);
		properties.setProperty("hibernate.jdbc.batch_size", batch_size);
		properties.setProperty("hibernate.jdbc.fetch_size", fetch_size);
		properties.setProperty("hibernate.hbm2ddl.auto", hbm2ddl_auto);
		return properties;
	}
	
	@Bean
	public EntityManagerFactory entityManagerFactory() throws H2DatabaseNotCreated {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource());
		entityManagerFactoryBean.setPackagesToScan("com.m_landalex.webremoteaccess.domain");
		entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		entityManagerFactoryBean.setJpaProperties(getProperties());
		entityManagerFactoryBean.afterPropertiesSet();
		return entityManagerFactoryBean.getObject();
	}
	
}
