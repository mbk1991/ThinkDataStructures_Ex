package ex01_list_interface;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class ListClientExampleTest {
	//Unit테스트를 이용하여 ListClientExample의 getList로 생성한 list객체가 LinkedList.class 타입인지 확인하고 있다.
	//
	@Test
	public void testListClientExample() {
		ListClientExample lce = new ListClientExample();
		@SuppressWarnings("rawtypes")
		List list = lce.getList();
//		assertThat(list, instanceOf(LinkedList.class));
		//이게 더 추천하는 메소드가 아닐까?
		assertEquals(list, instanceOf(LinkedList.class));
	}

}
