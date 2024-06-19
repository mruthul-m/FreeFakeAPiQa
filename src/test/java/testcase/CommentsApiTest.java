package testcase;

import static org.hamcrest.CoreMatchers.equalTo;
import java.io.File;
import org.testng.annotations.Test;
import endpoints.EndPoints;
import io.restassured.module.jsv.JsonSchemaValidator;
import payload.Model;
import utils.DataProviders;

public class CommentsApiTest {


  @Test(dataProvider = "getResponseSchema", dataProviderClass = DataProviders.class)
  public void getAllComments(File responseSchema) {
    EndPoints.getAllComments().then().log().all().assertThat().statusCode(200).assertThat()
        .body(JsonSchemaValidator.matchesJsonSchema(responseSchema));
  }

  @Test(dataProvider = "getSingleResponseSchema", dataProviderClass = DataProviders.class)
  public void getCommentsById(File responseSchema) {
    EndPoints.getSingleComment(2).then().log().all().assertThat().statusCode(200).assertThat()
        .body(JsonSchemaValidator.matchesJsonSchema(responseSchema));
  }

  @Test
  public void createNewComment() {
    Model newModel = new Model();
    newModel.setContent("New Content");
    newModel.setPost("4");
    newModel.setUser("3");

    EndPoints.postComment(newModel).then().log().all().assertThat().statusCode(201).assertThat()
        .body("content", equalTo(newModel.getContent())).assertThat()
        .body("user", equalTo("/api/users/" + newModel.getUser())).assertThat()
        .body("post", equalTo("/api/posts/" + newModel.getPost()));
  }

  @Test
  public void deleteComment() {
    EndPoints.deleteComment(3).then().log().all().assertThat().statusCode(204);
  }


}

