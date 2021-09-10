package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {
    Repository repository = new Repository();
    Product book1 = new Book(1, "title1", 100, "Author1");
    Product book2 = new Book(2, "title2", 900, "Author2");
    Product smartphone1 = new Smartphone(3, "title5", 1500, "USA");
    Product smartphone2 = new Smartphone(4, "title6", 1900, "Russia");

   @BeforeEach
   public void setUp() {
       repository.save(book1);
       repository.save(book2);
       repository.save(smartphone1);
       repository.save(smartphone2);
   }
    @Test
    void shouldRemoveByIdIfProductWithIdExist() {
        repository.removeById(2);
        Product[] expected = new Product[]{book1, smartphone1, smartphone2};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }



    @Test
    void shouldThrowNotFoundExeptionIfProductWithIdNotExist() {
        assertThrows(NotFoundException.class, () -> {
            repository.removeById(5);
        });
    }

}