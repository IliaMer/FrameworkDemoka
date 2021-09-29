package api;

import com.github.fge.jsonschema.SchemaVersion;
import com.github.fge.jsonschema.cfg.ValidationConfiguration;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class Delete {

    public Delete(String jsonSchemaName, int statusCode, String path) {
        Response response = RestAssured.given()
                .log().all()
                .contentType("application/json")
                .delete(path);
        Assertions.assertEquals(statusCode, response.statusCode());
        response.then().body(matchesJsonSchemaInClasspath(jsonSchemaName).using(runJsonSchemaFactory()));

    }

    public Delete(String jsonSchemaName, int statusCode, String path, String token) {
        Response response = RestAssured.given()
                .log().all()
                .contentType("application/json")
                .header("Authorization", "Bearer " + token)
                .delete(path);
        Assertions.assertEquals(statusCode, response.statusCode());
        response.then().body(matchesJsonSchemaInClasspath(jsonSchemaName).using(runJsonSchemaFactory()));

    }

    private JsonSchemaFactory runJsonSchemaFactory() {
        JsonSchemaFactory jsonSchemaFactory = JsonSchemaFactory.newBuilder().setValidationConfiguration(ValidationConfiguration.newBuilder()
                .setDefaultVersion(SchemaVersion.DRAFTV4).freeze()).freeze();
        return jsonSchemaFactory;
    }
}
