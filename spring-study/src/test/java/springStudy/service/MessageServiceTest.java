package springStudy.service;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * MessageServiceTest
 * 
 * @author TigMonkey
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageServiceTest {

	@Autowired
	private MessageService messageService;
	
	/**
	 * 특정 키를 포함하는 entry Map 테스트
	 * 
	 * @author TigMonkey
	 */
	@Test
	public void test_getSpecificMessages() {
		Map<String, String> retMap = messageService.getSpecificMessages("protoss.building");
		System.out.println(retMap);
	}
	
}
