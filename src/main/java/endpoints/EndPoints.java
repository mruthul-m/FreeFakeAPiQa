package endpoints;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payload.Model;

public class EndPoints {

  public static Response getAllComments() {
    RestAssured.useRelaxedHTTPSValidation();
    Response response =
        RestAssured.given().headers("Content-Type", "application/json", "Accept", ContentType.JSON)
            .baseUri(Routes.BASE_URI).basePath(Routes.GET_ALL_COMMENTS).accept(ContentType.JSON)
            .when().get();

    return response;
  }

  public static Response getSingleComment(int id) {
    RestAssured.useRelaxedHTTPSValidation();
    Response response =
        RestAssured.given().headers("Content-Type", "application/json", "Accept", ContentType.JSON)
            .baseUri(Routes.BASE_URI).basePath(Routes.GET_SINGLE_COMMENT).pathParam("id", id)
            .accept(ContentType.JSON).when().get();
    return response;
  }

  public static Response postComment(Model payload) {
    RestAssured.useRelaxedHTTPSValidation();
    Response response =
        RestAssured.given().headers("Content-Type", "application/json", "Accept", ContentType.JSON)
            .baseUri(Routes.BASE_URI).basePath(Routes.POST_COMMENT).accept(ContentType.JSON)
            .body(payload).when().post();
    return response;
  }

  public static Response updateComment(Model payload, int id) {
    RestAssured.useRelaxedHTTPSValidation();
    Response response =
        RestAssured.given().headers("Content-Type", "application/json", "Accept", ContentType.JSON)
            .baseUri(Routes.BASE_URI).basePath(Routes.POST_COMMENT).pathParam("id", id)
            .accept(ContentType.JSON).body(payload).when().put();
    return response;
  }

  public static Response deleteComment(int id) {
    RestAssured.useRelaxedHTTPSValidation();
    Response response =
        RestAssured.given().headers("Content-Type", "application/json", "Accept", ContentType.JSON)
            .baseUri(Routes.BASE_URI).basePath(Routes.DELETE_COMMENT).pathParam("id", id)
            .accept(ContentType.JSON).when().delete();
    return response;
  }

}
