package bookStoreTests;

import BookStore.User;
import api.Post;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserAccountTests {


    private static User user = new User();


    @Test
    @Order(1)
    void CreateUserTest() {
        Post post = new Post(user, "jsonSchemas/CreateUser.json", 201,
                "https://demoqa.com/Account/v1/User");
    }

//    @Test
//    void CreateUserChekStatusCode406Test() {
//        Post post = new Post(user, "Schemas/CreateUser.json", 406,
//                "https://demoqa.com/Account/v1/User");
//    }

    @Test
    @Order(2)
    void GenerateTokenTest() {
        Post post = new Post(user, "jsonSchemas/GenerateToken.json", 200,
                "https://demoqa.com/Account/v1/GenerateToken");
    }

    @Test
    @Order(3)
    void AuthorizationTest() {
        Post post = new Post(user, "jsonSchemas/Authorization.json", 200,
                "https://demoqa.com/Account/v1/Authorized");
    }
}
