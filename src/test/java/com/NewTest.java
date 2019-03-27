package com;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import com.configuration.TestConfig;

@ExtendWith(MockitoExtension.class)
@ContextConfiguration(classes = {TestConfig.class})
@WebAppConfiguration
class NewTest {

	@Autowired
	private SessionFactory sessionFactory;

	@Mock
	List mockedList;

	@Mock
	List mockedList2;

	@Test
	void testMocedList() {
		when(mockedList.get(0)).thenReturn("Maja");
		when(mockedList.size()).thenReturn(100);
		mockedList.clear();
		mockedList.add("one");
		verify(mockedList).add("one");
		System.out.println(mockedList.get(0));
		System.out.println(mockedList.size());
		verify(mockedList, atLeast(1)).clear();
		verify(mockedList, atMost(2)).clear();
		verify(mockedList, never()).iterator();
		InOrder inOrder = inOrder(mockedList);
		inOrder.verify(mockedList).add("one");
		inOrder.verify(mockedList).size();
		verifyZeroInteractions(mockedList, mockedList2);
		when(mockedList.get(2)).thenReturn("one", "two").thenThrow(new ArrayIndexOutOfBoundsException());
		System.out.println(mockedList.get(2));
		System.out.println(mockedList.get(2));

		mockedList.indexOf("Capture");
		ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);

		verify(mockedList).indexOf(argument.capture());
		assertEquals("Capture", argument.getValue());
		Mockito.mockingDetails(mockedList).isSpy();
	}

}
