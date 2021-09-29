package api;

import BookStore.Book;
import com.github.fge.jsonschema.SchemaVersion;
import com.github.fge.jsonschema.cfg.ValidationConfiguration;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class Get {
    Response response;

    public Get(String jsonSchemaName, int statusCode, String path) {
        this.response = RestAssured.given()
                .log().all()
                .contentType("application/json")
                .get(path);
        Assertions.assertEquals(statusCode, response.statusCode());
        response.then().body(matchesJsonSchemaInClasspath(jsonSchemaName).using(runJsonSchemaFactory()));
    }

    public Get(String jsonSchemaName, int statusCode, String path, String token) {
        this.response = RestAssured.given()
                .log().all()
                .contentType("application/json")
                .header("Authorization", "Bearer " + token)
                .get(path);
        Assertions.assertEquals(statusCode, response.statusCode());
        response.then().body(matchesJsonSchemaInClasspath(jsonSchemaName).using(runJsonSchemaFactory()));
    }

    public Get(String path) {
        this.response = RestAssured.given()
                .log().all()
                .contentType("application/json")
                .get(path);
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
