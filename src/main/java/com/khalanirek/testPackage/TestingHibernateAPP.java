package com.khalanirek.testPackage;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.khalanirek.entity.Project;
import com.khalanirek.entity.User;
import com.khalanirek.entity.UserPersonalDetails;

public class TestingHibernateAPP {

	public static void main(String[] args) {

		// Create context
		//AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		/* Project project = new Project();
		project.setName("TEST");
		project.setDescription("TEST");
		User theUser = new User();
		theUser.setUserId(10);
		project.setOwner(theUser);
		project.setCreator(theUser);
		*/
		SessionFactory sessionFactory = new org.hibernate.cfg.Configuration()
		.configure("hibernate.cfg.xml")
		.addAnnotatedClass(User.class)
		.addAnnotatedClass(UserPersonalDetails.class)
		.addAnnotatedClass(Project.class)
		.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		// session.save(project);
		Project theProject = session.get(Project.class, 2);
		session.getTransaction().commit();
		System.out.println(theProject);
		/*ProjectController projectController = context.getBean("projectControllerImpl", ProjectController.class);;
		project = projectController.addProject(project);
		System.out.println(projectController.getProject(project.getProjectId()));
		project.setName("UPDATE");
		System.out.println(projectController.updateProject(project));
		*/
		/*
		// Create a User object
		System.out.println("Creating a User object");
		User user = new User();
		user.setRole("Adminek");
		user.setUserPersonalDetails(new UserPersonalDetails("Piotr", "Adminek"));

		/// Create UserController
		UserController userController = context.getBean("userControllerImpl", UserController.class);

		int savedUserId = userController.addUser(user).getUserId();
		user = userController.getUser(savedUserId);
		userController.deleteUser(savedUserId);
		List<User> userList = userController.getUsers();
		*/
	}
}
