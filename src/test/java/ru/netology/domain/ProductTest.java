package ru.netology.domain;

import org.junit.jupiter.api.Test;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);

    Product first = new Book(1, "Война и мир", 100, "Толстой");
    Product second = new Book(2, "Преступление и наказание", 200, "Достоевский");
    Product third = new Book(3, "Онегин", 150, "Пушкин");
    Product fourth = new Book(4, "Онегин", 120, "Пушкин");
    Product fifth = new Book(5, "Идиот", 90, "Достоевский");
    Product sixth = new Smartphone(6, "Samsung", 1000, "Samsung");
    Product seventh = new Smartphone(7, "Apple", 2000, "Apple");
    Product eighth = new Smartphone(8, "Nokia", 900, "Nokia");
    Product ninth = new Smartphone(9, "Lenovo", 800, "Lenovo");
    Product tenth = new Smartphone(10, "Vertu", 5000, "Vertu");
    Product eleventh = new Smartphone(11, "Honor", 700, "Honor");

    @Test
    void addProduct() {

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);

        Product[] expected = {first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void removeByIdProduct() {

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);

        repository.removeById(3);

        Product[] expected = {first, second, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByName() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);

        Product[] expected = {fifth};
        Product[] actual = manager.searchBy("Идиот");

        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByNameIfProductIsOut() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);

        Product[] expected = new Product[0];
        Product[] actual = manager.searchBy("Один");

        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByNameTwoProduct() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);

        Product[] expected = {third, fourth};
        Product[] actual = manager.searchBy("Онегин");

        assertArrayEquals(expected, actual);
    }

    @Test
    void removeByIdIfIdNotFound1() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);

        assertThrows(NotFoundException.class, () -> {
            repository.removeById(20);
        });
    }
}