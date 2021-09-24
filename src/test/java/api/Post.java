package api;

import BookStore.Book;
import BookStore.UserAuthorized;
import com.github.fge.jsonschema.SchemaVersion;
import com.github.fge.jsonschema.cfg.ValidationConfiguration;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class Post {
    String jsonSchemaName;
    int statusCode;
    String path;

    public Post(UserAuthorized user, String jsonSchemaName, int statusCode, String path) {
        Response response = RestAssured.given()
                .log().all()
                .contentType("application/json")
                .body(user)
                .post(path);
        response.then().body(matchesJsonSchemaInClasspath(jsonSchemaName).using(runJsonSchemaFactory()));
        Assertions.assertEquals(statusCode, response.statusCode());
    }

    public Post(Book book, String jsonSchemaName, int statusCode, String path) {
        Response response = RestAssured.given()
                .log().all()
                .contentType("application/json")
                .body(book)
                .post(path);
        response.then().body(matchesJsonSchemaInClasspath(jsonSchemaName).using(runJsonSchemaFactory()));
        Assertions.assertEquals(statusCode, response.statusCode());
    }


    private JsonSchemaFactory runJsonSchemaFactory() {
        JsonSchemaFactory jsonSchemaFactory = JsonSchemaFactory.newBuilder().setValidationConfiguration(ValidationConfiguration.newBuilder()
                .setDefaultVersion(SchemaVersion.DRAFTV4).freeze()).freeze();
        return jsonSchemaFactory;
    }
}
