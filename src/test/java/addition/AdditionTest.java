package addition;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class AdditionTest {

  private static final String additionURL = "http://localhost:8080/addition";
  private static JSONObject numbersJsonObject;
  private static HttpHeaders headers;
  private final ObjectMapper objectMapper = new ObjectMapper();
  private static RestTemplate restTemplate;

  @BeforeClass
  public static void runBeforeAllTests() throws JSONException {

    headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);

    restTemplate = new RestTemplate();

    numbersJsonObject = new JSONObject();
    numbersJsonObject.put("n1", "5");
    numbersJsonObject.put("n2", "3");

  }

  @Test
  public void testAddition() throws IOException {
    HttpEntity<String> request = new HttpEntity<>(numbersJsonObject.toString(), headers);
    String response = restTemplate.postForObject(additionURL, request, String.class);

    JsonNode root = objectMapper.readTree(response);
    ResultPojo resultPojo = restTemplate.postForObject(additionURL, request, ResultPojo.class);

    assertNotNull(response);
    assertNotNull(root);
    assertNotNull(root.path("result").asText());

    assertNotNull(resultPojo);
    assertNotNull(resultPojo.getResult());

  }

}
