package com.khalanirek.configuration;

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

import com.khalanirek.aspect.LoggingAspect;
import com.khalanirek.controller.ProjectController;
import com.khalanirek.controller.UserController;
import com.khalanirek.controller.impl.ProjectControllerImpl;
import com.khalanirek.controller.impl.UserControllerImpl;
import com.khalanirek.entity.Project;
import com.khalanirek.entity.ProjectComment;
import com.khalanirek.entity.ProjectPhase;
import com.khalanirek.entity.ProjectPhaseComment;
import com.khalanirek.entity.ProjectTask;
import com.khalanirek.entity.ProjectTaskComment;
import com.khalanirek.entity.User;
import com.khalanirek.entity.UserPersonalDetails;
import com.khalanirek.repository.ProjectRepository;
import com.khalanirek.repository.UserRepository;
import com.khalanirek.repository.impl.ProjectRepositoryImpl;
import com.khalanirek.repository.impl.UserRepositoryImpl;
import com.khalanirek.service.ProjectService;
import com.khalanirek.service.UserService;
import com.khalanirek.service.impl.ProjectServiceImpl;
import com.khalanirek.service.impl.UserServiceImpl;
import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@EnableAspectJAutoProxy
@ComponentScan("com")
public class AppConfig {

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
		/*SessionFactory sessionFactory = new org.hibernate.cfg.Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(User.class)
				.addAnnotatedClass(UserPersonalDetails.class)
				.buildSessionFactory();
				*/
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
    public LoggingAspect loggingAspect() {
    	return new LoggingAspect();
    }

    // Project Beans
	@Bean
	public ProjectController projectControllerImpl() {
		return new ProjectControllerImpl(projectServiceImpl());
	}

    @Bean
	public ProjectRepository projectRepositoryImpl() {
		return new ProjectRepositoryImpl(sessionFactory().getObject());
	}

	@Bean
	public ProjectService projectServiceImpl() {
		return new ProjectServiceImpl(projectRepositoryImpl());
	}

    // User Beans
	@Bean
	public UserController userControllerImpl() {
		return new UserControllerImpl(userServiceImpl());
	}

    @Bean
	public UserRepository userRepositoryImpl() {
		return new UserRepositoryImpl(sessionFactory().getObject());
	}

	@Bean
	public UserService userServiceImpl() {
		return new UserServiceImpl(userRepositoryImpl());
	}

}
