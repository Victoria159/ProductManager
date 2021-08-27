package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Main;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.Repository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private Repository repo = new Repository();
    private ProductManager manager = new ProductManager(repo);

    Product book1 = new Book(1, "title1", 100, "Author1");
    Product book2 = new Book(2, "title2", 900, "Author1");
    Product book3 = new Book(3, "title3", 1000, "Author3");
    Product book4 = new Book(4, "title2", 1000, "Author4");
    Product smartphone1 = new Smartphone(5, "title5", 1500, "USA");
    Product smartphone2 = new Smartphone(6, "title6", 1500, "Russia");
    Product smartphone3 = new Smartphone(7, "title6", 1500, "USA");
    Product smartphone4 = new Smartphone(8, "title8", 1500, "China");
    Product main10 = new Main(10,"ttttt",1,"hi");

    @BeforeEach
    public void setUp() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.add(smartphone4);

    }

    @Test
    void shouldsearchByIfNoBookWithTitle() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("title15");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldsearchByIfBookWithTitleExist() {
        Product[] expected = new Product[]{book1};
        Product[] actual = manager.searchBy("title1");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldsearchByIf1BooksWithTitleExist() {
        Product[] expected = new Product[]{book2, book4};
        Product[] actual = manager.searchBy("title2");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldsearchByIfNoBookWithAuthor() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Author50");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldsearchByIf2BooksWithAuthorExist() {
        Product[] expected = new Product[]{book1, book2};
        Product[] actual = manager.searchBy("Author1");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldsearchByIfNoSmartphoneWithManufacturer() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Germany");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldsearchByIfSmartphoneWithManufacturerExist() {
        Product[] expected = new Product[]{smartphone2};
        Product[] actual = manager.searchBy("Russia");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldsearchByIfSmartphonesWithManufacturerExist1() {
        Product[] expected = new Product[]{smartphone1, smartphone3};
        Product[] actual = manager.searchBy("USA");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldsearchByIfSmartphoneWithTitleExist2() {
        Product[] expected = new Product[]{smartphone1 };
        Product[] actual = manager.searchBy("title5");
        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldsearchByIfSmartphonesWithNameExist3() {
        Product[] expected = new Product[]{smartphone2, smartphone3};
        Product[] actual = manager.searchBy("title6");
        assertArrayEquals(expected, actual);
    }
    @BeforeEach
            public void setUp2() {
        manager.add(main10);
    }
    @Test
    void shouldsearchByIfSmartphonesWithManufacturerExist4 () {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("hit");
        assertArrayEquals(expected, actual);
    }

}