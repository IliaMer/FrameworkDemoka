package api;

import BookStore.Book;
import BookStore.ListOfBooks;
import BookStore.User;
import com.github.fge.jsonschema.SchemaVersion;
import com.github.fge.jsonschema.cfg.ValidationConfiguration;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class Post {
    Response response;

    public Post(User user, String jsonSchemaName, int statusCode, String path) {
        this.response = RestAssured.given()
                .log().all()
                .contentType("application/json")
                .body(user)
                .post(path);
        Assertions.assertEquals(statusCode, response.statusCode());
        response.then().body(matchesJsonSchemaInClasspath(jsonSchemaName).using(runJsonSchemaFactory()));

    }

    public Post(User user, String path) {
        this.response = RestAssured.given()
                .log().all()
                .contentType("application/json")
                .body(user)
                .post(path);
    }

    public Post(ListOfBooks list, String jsonSchemaName, int statusCode, String path) {
        this.response = RestAssured.given()
                .log().all()
                .contentType("application/json")
                .body(list)
                .post(path);
        Assertions.assertEquals(statusCode, response.statusCode());
        response.then().body(matchesJsonSchemaInClasspath(jsonSchemaName).using(runJsonSchemaFactory()));

    }


    private JsonSchemaFactory runJsonSchemaFactory() {
        JsonSchemaFactory jsonSchemaFactory = JsonSchemaFactory.newBuilder().setValidationConfiguration(ValidationConfiguration.newBuilder()
                .setDefaultVersion(SchemaVersion.DRAFTV4).freeze()).freeze();
        return jsonSchemaFactory;
    }

    public Response getResponse() {
        return response;
    }
}
