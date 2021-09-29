package api;

import BookStore.Book;
import com.github.fge.jsonschema.SchemaVersion;
import com.github.fge.jsonschema.cfg.ValidationConfiguration;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class Put {
    Response response;

    public Put(String jsonSchemaName, int statusCode, String path) {
        this.response = RestAssured.given()
                .log().all()
                .contentType("application/json")
                .put(path);
        Assertions.assertEquals(statusCode, response.statusCode());
        response.then().body(matchesJsonSchemaInClasspath(jsonSchemaName).using(runJsonSchemaFactory()));
    }

    public Put(String path) {
        this.response = RestAssured.given()
                .log().all()
                .contentType("application/json")
                .put(path);
    }

    public Put(Book book, String jsonSchemaName, int statusCode, String path) {
        this.response = RestAssured.given()
                .log().all()
                .contentType("application/json")
                .body(book)
                .put(path);
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
