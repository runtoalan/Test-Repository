package com.forensic.api;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ForensicApiApplicationTests.class)
@EnableCaching
public class ForensicApiApplicationTests {

	public void main() {
		ForensicApiApplication.main(new String[] {});
	}

}
