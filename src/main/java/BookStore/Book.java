package BookStore;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Book implements Serializable {
        private String isbn;
        private String title;
        private String subTitle;
        private String author;
        private LocalDateTime publish_date;
        private String publisher;
        private int pages;
        private String description;
        private String website;
        private String userId;

        public Book(String isbn, String title, String subTitle, String author, LocalDateTime publish_date,
                    String publisher, int pages, String description, String website, String userId) {
                this.isbn = isbn;
                this.title = title;
                this.subTitle = subTitle;
                this.author = author;
                this.publish_date = publish_date;
                this.publisher = publisher;
                this.pages = pages;
                this.description = description;
                this.website = website;
                this.userId = userId;
        }

        public Book() {
        }
}
