package bookStoreTests;

import BookStore.Book;
import BookStore.ListOfBooks;
import BookStore.User;
import api.Get;
import api.Post;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AddListOfBooks {
    private static Book book = new Book();
    private static User user = new User();
    private ArrayList<LinkedHashMap> books;
    private String isbn;
    private String userId;
    private String token;


    @BeforeEach
    void setup() {
        Post create = new Post(user, "https://demoqa.com/Account/v1/User");
        userId = create.getResponse().getBody().jsonPath().getString("userID");
        Post getToken = new Post(user, "https://demoqa.com/Account/v1/GenerateToken");
        token = getToken.getResponse().getBody().jsonPath().getString("token");
        Post login = new Post(user, "https://demoqa.com/Account/v1/Authorized");
        Get getBooks = new Get("https://demoqa.com/BookStore/v1/Books");
        books = getBooks.getResponse().getBody().jsonPath().get("books");
    }

    /*
    Полчаем 504 ошибку (отваливаемся по таймауту)
    После добавления книги через фронт, выводится Поп-Ап для подтверждения добавления.
    Предположительно из-за того что с бэка это окно закрыть невозможно, отваливаемся по таймауту
    */

    @Test
    @DisplayName("Add list of books")
    @Order(1)
    void addListOfBooks() {

        String[] listIsbn = new String[books.size()];
        for (int i = 0; i < books.size(); i++) {
            listIsbn[i] = books.get(i).get("isbn").toString();
        }
        Post post = new Post(new ListOfBooks(userId, listIsbn), "jsonSchemas/AddListOfBooks.json",
                201,
                "https://demoqa.com/BookStore/v1/Books", token);
    }
}
