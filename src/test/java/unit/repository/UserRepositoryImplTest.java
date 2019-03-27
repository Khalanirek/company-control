package unit.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import com.configuration.TestConfig;
import com.entity.User;
import com.repository.impl.UserRepositoryImpl;

@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
@ContextConfiguration(classes = {TestConfig.class})
@WebAppConfiguration
class UserRepositoryImplTest {
	@Mock
	List mockedList;

	@Mock
	SessionFactory sessionFactoryMock;

	@Mock
	Session sessionMock;

	@Mock
	Query queryMock;

	@InjectMocks
	private UserRepositoryImpl userRepositoryImpl;

	private User user;

	@BeforeEach
	public void init() {
		when(sessionFactoryMock.getCurrentSession()).thenReturn(sessionMock);
	}

	@Test
	void whenSaveUserThenSessionSaveOrUpdateOneTimeTest() {
		user = new User();
		userRepositoryImpl.saveUser(user);
		verify(sessionMock, times(1)).saveOrUpdate(user);
	}

	@Test
	void whenGetUserWithIdXThenUserWithIdXTest() {
		user = new User();
		user.setUserId(1);
		when(sessionMock.get(User.class, 1)).thenReturn(user);
		assertEquals(user.getUserId() , userRepositoryImpl.getUser(1).getUserId());
	}

	@Test
	void whenGetUsersThenOneResultFromUser() {
		List<User> usersList = new ArrayList<>();
		usersList.add(new User("TEST"));
		usersList.add(new User("TSET2"));
		when(sessionMock.createQuery("from User")).thenReturn(queryMock);
		when(queryMock.getResultList()).thenReturn(usersList);
		assertEquals(usersList, userRepositoryImpl.getUsers());
	}
	@Test
	void whenDeleteUserThenSessionDeleteOneTimeTest() {
		user = new User();
		user.setUserId(1);
		when(sessionMock.get(User.class, 1)).thenReturn(user);
		userRepositoryImpl.deleteUser(1);
		verify(sessionMock, times(1)).delete(user);
	}

}
