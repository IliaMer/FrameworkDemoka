package bookStoreTests;

import BookStore.User;
import api.Get;
import api.Post;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GetUserProfile {
    private static User user = new User();
    private String userId;
    private String token;

    @BeforeEach
    void setup() {
        Post create = new Post(user, "https://demoqa.com/Account/v1/User");
        userId = create.getResponse().getBody().jsonPath().getString("userID");
        Post getToken = new Post(user, "https://demoqa.com/Account/v1/GenerateToken");
        token = getToken.getResponse().getBody().jsonPath().getString("token");
        Post login = new Post(user, "https://demoqa.com/Account/v1/Authorized");
    }

    @Test
    @DisplayName("Get user by userId")
    @Order(1)
    void GetUser() {
        Get get = new Get("jsonSchemas/UpdateUserBooks.json", 200,
                "https://demoqa.com/Account/v1/User/" + userId, token);
    }

    @Test
    @DisplayName("Get user error with invalid userId")
    @Order(2)
    void GetUserErrorWithInvalidUserId() {
        Get get = new Get("jsonSchemas/Errors.json", 401,
                "https://demoqa.com/Account/v1/User/" + RandomStringUtils.randomAlphabetic(20), token);
    }
}
