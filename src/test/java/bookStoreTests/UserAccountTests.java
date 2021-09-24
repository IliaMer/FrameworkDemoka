package bookStoreTests;

import BookStore.UserAuthorized;
import api.Post;
import org.junit.jupiter.api.Test;

public class UserAccountTests {

    private UserAuthorized user = new UserAuthorized();

    @Test
    void CreateUserTest() {
        Post post = new Post(user, "Schemas/jsonSchemaCreateUser.json", 201,
                "https://demoqa.com/Account/v1/User");
    }

    @Test
    void GenerateTokenTest() {
        Post post = new Post(user, "Schemas/jsonSchemaGenerateToken.json", 200,
                "https://demoqa.com/Account/v1/GenerateToken");
    }

    @Test
    void AuthorizationTest() {
        Post post = new Post(user, "Schemas/jsonSchemaAuthorization.json", 200,
                "https://demoqa.com/Account/v1/Authorized");
    }
}
