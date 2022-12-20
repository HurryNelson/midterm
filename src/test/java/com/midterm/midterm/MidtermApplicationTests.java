// package com.midterm.midterm;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertTrue;

// import java.net.URL;

// import org.junit.jupiter.api.BeforeAll;
// import org.junit.jupiter.api.Test;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.boot.test.web.client.TestRestTemplate;
// import org.springframework.http.HttpMethod;
// import org.springframework.http.ResponseEntity;
// import com.fasterxml.jackson.databind.*;
// import com.midterm.midterm.Food.Food;
// import org.apache.http.HttpEntity;
// import org.apache.http.client.methods.CloseableHttpResponse;
// import org.apache.http.client.methods.HttpGet;
// import org.apache.http.client.methods.HttpPost;
// import org.apache.http.entity.ContentType;
// import org.apache.http.entity.StringEntity;
// import org.apache.http.impl.client.*;
// import org.apache.http.util.EntityUtils;

// @SpringBootTest
// class MidtermApplicationTests {
// 	// private static int port = 8080;
// 	// private static URL base;
// 	// private TestRestTemplate template;

// 	// @BeforeAll
// 	// public static void setUp() throws Exception {
// 	// 	base = new URL("http://localhost:" + port + "/");
// 	// }

// 	// //test GET
// 	// @Disabled
// 	//  void testGet() throws Exception {
// 	// 	template = new TestRestTemplate();
// 	// 	this.base = new URL(this.base.toString() + "food?orderNum=1");
// 	// 	ResponseEntity<String> response = template.getForEntity(base.toString(), String.class);
// 	// 	String body = response.getBody();

// 	// 	ObjectMapper mapper = new ObjectMapper();
// 	// 	Food[] foodJson = mapper.readValue(body, Food[].class);

// 	// 	String resultText = foodJson[0].getFoodName();

// 	// 	assertEquals("BLT", resultText);
// 	// }

// 	// //test GET all
// 	// @Disabled
// 	// void testGetAll() throws Exception {
// 	// 	template = new TestRestTemplate();
// 	// 	this.base = new URL(this.base.toString() + "food?orderNum=0");
// 	// 	ResponseEntity<String> response = template.getForEntity(base.toString(), String.class);
// 	// 	String body = response.getBody();

// 	// 	ObjectMapper mapper = new ObjectMapper();
// 	// 	Food[] foodJson = mapper.readValue(body, Food[].class);

// 	// 	String resultText = foodJson[0].getFoodName();
// 	// 	String resultText2 = foodJson[1].getFoodName();

// 	// 	assertTrue(resultText.contains("BLT"), "BLT was not returned:" + resultText);
// 	// 	assertTrue(resultText2.contains("Chicken"), "Chicken was not returned:" + resultText2);
// 	// }

// 	// //test GET error
// 	// @Disabled
// 	// void testGetError() throws Exception {
// 	// 	template = new TestRestTemplate();
// 	// 	this.base = new URL(this.base.toString() + "food?orderNum=3");
// 	// 	ResponseEntity<String> response = template.getForEntity(base.toString(), String.class);
// 	// 	String body = response.getBody();

// 	// 	ObjectMapper mapper = new ObjectMapper();
// 	// 	Food[] foodJson = mapper.readValue(body, Food[].class);

// 	// 	String resultText = foodJson[0].getFoodName();

// 	// 	assertEquals("No food here", resultText);
// 	// }

// 	// //test POST
// 	// @Disabled
// 	// void testPost() throws Exception {
// 	// 	template = new TestRestTemplate();
// 	// 	this.base = new URL(this.base.toString() + "food?orderNum=4&foodName=hotDog&calories=115&fat=0.6&carbs=37");
// 	// 	ResponseEntity<String> response = template.postForEntity(base.toString(), String.class, String.class, String.class);
// 	// 	String body = response.getBody();

// 	// 	template = new TestRestTemplate();
// 	// 	this.base = new URL(this.base.toString() + "food?orderNum=4");
// 	// 	response = template.getForEntity(base.toString(), String.class);
// 	// 	body = response.getBody();

// 	// 	ObjectMapper mapper = new ObjectMapper();
// 	// 	Food[] foodJson = mapper.readValue(body, Food[].class);

// 	// 	String resultText = foodJson[0].getFoodName();		

// 	// 	assertEquals("hotDog", resultText);
// 	// }

// 	// //test POST error
// 	// @Disabled
// 	// void testPostError() throws Exception {
// 	// 	template = new TestRestTemplate();
// 	// 	this.base = new URL(this.base.toString() + "food?orderNum=1&foodName=hotDog&calories=115&fat=0.6&carbs=37");
// 	// 	ResponseEntity<String> response = template.postForEntity(base.toString(), String.class, String.class, String.class);
// 	// 	String body = response.getBody();

// 	// 	assertTrue(body.contains("There is already food here, cannot add a new order"), body + " was returned");	
// 	// }

// 	// //test PUT
// 	// @Disabled
// 	// void testPut() throws Exception  {
// 	// 	template = new TestRestTemplate();
// 	// 	this.base = new URL(this.base.toString() + "food?orderNum=2&sauce=BBQ");
// 	// 	ResponseEntity<String> response = template.exchange(base.toString(), HttpMethod.PUT, null, String.class);
// 	// 	String body = response.getBody();

// 	// 	template = new TestRestTemplate();
// 	// 	this.base = new URL(this.base.toString() + "food?orderNum=2");
// 	// 	response = template.getForEntity(base.toString(), String.class);
// 	// 	body = response.getBody();

// 	// 	ObjectMapper mapper = new ObjectMapper();
// 	// 	Food[] foodJson = mapper.readValue(body, Food[].class);

// 	// 	String resultText = foodJson[0].getFoodName();

// 	// 	assertTrue(resultText.contains("BBQ"), "BBQ sauce was not added to the chicken:" + resultText);
// 	// }

// 	// //test PUT errors
// 	// @Disabled
// 	// void testPutNoFoodError() throws Exception  {
// 	// 	template = new TestRestTemplate();
// 	// 	this.base = new URL(this.base.toString() + "food?orderNum=3&sauce=BBQ");
// 	// 	ResponseEntity<String> response = template.exchange(base.toString(), HttpMethod.PUT, null, String.class);
// 	// 	String body = response.getBody();

// 	// 	assertTrue(body.contains("There is no food, cannot add a sauce"), body + " was returned");
// 	// }
	
// 	// @Disabled
// 	// void testPutNoSauceError() throws Exception  {
// 	// 	template = new TestRestTemplate();
// 	// 	this.base = new URL(this.base.toString() + "food?orderNum=1&sauce=");
// 	// 	ResponseEntity<String> response = template.exchange(base.toString(), HttpMethod.PUT, null, String.class);
// 	// 	String body = response.getBody();

// 	// 	assertTrue(body.contains("There is no sauce, cannot add a sauce"), body + " was returned");
// 	// }

// 	// @Disabled
// 	// void testPutSaucedAlreadyError() throws Exception  {
// 	// 	template = new TestRestTemplate();
// 	// 	this.base = new URL(this.base.toString() + "food?orderNum=1&sauce=BBQ");
// 	// 	ResponseEntity<String> response = template.exchange(base.toString(), HttpMethod.PUT, null, String.class);
// 	// 	String body = response.getBody();

// 	// 	assertTrue(body.contains("There is already sauce on the food, cannot add a sauce"), body + " was returned");
// 	// }

// 	// //test DELETE
// 	// @Disabled
// 	// void testDelete() throws Exception {
// 	// 	template = new TestRestTemplate();
// 	// 	this.base = new URL(this.base.toString() + "food?orderNum=4");
// 	// 	template.delete(base.toString(), String.class);
// 	// 	ResponseEntity<String> response = template.getForEntity(base.toString(), String.class);
// 	// 	String body = response.getBody();

// 	// 	ObjectMapper mapper = new ObjectMapper();
// 	// 	Food[] foodJson = mapper.readValue(body, Food[].class);

// 	// 	String resultText = foodJson[0].getFoodName();

// 	// 	assertEquals("No food here", resultText);
// 	// }

// 	// //test DELETE error
// 	// @Disabled
// 	// void testDeleteError() {
// 	// 	CloseableHttpClient client = HttpClients.createDefault();
// 	// 	String expectedCode = "HTTP/1.1 404 ";
// 	// 	String actualCode = "";

// 	// 	try {
// 	// 		HttpGet request = new HttpGet("http://localhost:8080/food?orderNum=5");
// 	// 		CloseableHttpResponse response = client.execute(request);
// 	// 		actualCode = response.getStatusLine().toString();
// 	// 	} catch (Exception e) {
// 	// 		e.printStackTrace();
// 	// 	}

// 	// 	assertEquals(expectedCode, actualCode);
// 	// }
// }
