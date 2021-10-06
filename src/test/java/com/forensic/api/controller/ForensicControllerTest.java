package com.forensic.api.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.forensic.api.ForensicApiApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * ForensicControllerTest class.
 * 
 * @author mamallan
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ForensicControllerTest.class)
public class ForensicControllerTest extends AbstractTest {
   @Override
   @Before
   public void setUp() {
      super.setUp();
   }

   /**
	*
	Test case to get the directions
	*/
   @Test
   public void getDirections() throws Exception {
      String uri = "http://localhost:8080/api/test@abc.com/directions";
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
              .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

      int status = mvcResult.getResponse().getStatus();
      assertEquals(200, status);
      String content = mvcResult.getResponse().getContentAsString();
      assertNotNull(content);
   }

   /**
    *
    Test case to get the location
    */
   @Test
   public void getLocation() throws Exception {
      String uri = "http://localhost:8080/api/test@abc.com/location/55.55/-104.88";
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
              .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

      int status = mvcResult.getResponse().getStatus();
      assertEquals(200, status);
      String content = mvcResult.getResponse().getContentAsString();
      assertNotNull(content);
   }

}