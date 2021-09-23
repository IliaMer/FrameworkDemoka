package api;

import com.github.fge.jsonschema.SchemaVersion;
import com.github.fge.jsonschema.cfg.ValidationConfiguration;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class Get {
    String jsonSchemaName;
    int statusCode;
    String path;

    public Get(String jsonSchemaName, int statusCode, String path) {
        Response response = RestAssured.given()
                .log().all()
                .contentType("application/json")
                .get(path);
        System.out.println(response);
        response.then().body(matchesJsonSchemaInClasspath(jsonSchemaName).using(runJsonSchemaFactory()));
        Assertions.assertEquals(200, response.statusCode());
    }


    private JsonSchemaFactory runJsonSchemaFactory() {
        JsonSchemaFactory jsonSchemaFactory = JsonSchemaFactory.newBuilder().setValidationConfiguration(ValidationConfiguration.newBuilder()
                .setDefaultVersion(SchemaVersion.DRAFTV4).freeze()).freeze();
        return jsonSchemaFactory;
    }
}
