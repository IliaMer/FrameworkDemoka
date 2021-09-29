package BookStore;

import org.apache.commons.lang3.RandomStringUtils;

public class Isbn {
    private String isbn;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public static Isbn[] generateIsbn() {
        Isbn[] isbnList = new Isbn[1];

        for (int i = 0; i < isbnList.length; i++) {
            Isbn isbn = new Isbn();
            isbn.setIsbn(RandomStringUtils.random(13, false, true));
            isbnList[i] = isbn;
        }
        return isbnList;
    }

}

