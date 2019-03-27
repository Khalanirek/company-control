package com.configuration;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.entity.Project;
import com.entity.ProjectComment;
import com.entity.ProjectPhase;
import com.entity.ProjectPhaseComment;
import com.entity.ProjectTask;
import com.entity.ProjectTaskComment;
import com.entity.User;
import com.entity.UserPersonalDetails;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.repository.UserRepository;
import com.repository.impl.UserRepositoryImpl;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@EnableAspectJAutoProxy
@ComponentScan("com")
public class TestConfig {

	// Configuration Beans
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
    	Properties hibernateProperties = new Properties();
    	hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
    	hibernateProperties.put("hibernate.show_sql", "true");
    	// hibernateProperties.put("hibernate.show_sql", false);
    	// hibernateProperties.put("hibernate.generate_statistics", false);
    	// hibernateProperties.put("hibernate.hbm2ddl.auto", "update");
    	// hibernateProperties.put("hibernate.use_sql_comments", false);

		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setHibernateProperties(hibernateProperties);
		sessionFactory.setAnnotatedClasses(User.class,
										   UserPersonalDetails.class,
										   Project.class,
										   ProjectPhase.class,
										   ProjectTask.class,
										   ProjectComment.class,
										   ProjectPhaseComment.class,
										   ProjectTaskComment.class
										   );
		return sessionFactory;
	}

    @Bean
    public PlatformTransactionManager txManager() {
        return new HibernateTransactionManager(sessionFactory().getObject());
    }

    @Bean
    public DataSource dataSource() {
    	ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
			dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
			dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/pro001?useSSL=false&amp");
	        dataSource.setUser("hbstudent");
	        dataSource.setPassword("hbstudent");
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}

        return dataSource;
    }

    @Bean
	public UserRepository userRepositoryImpl() {
		return new UserRepositoryImpl(sessionFactory().getObject());
	}


}
