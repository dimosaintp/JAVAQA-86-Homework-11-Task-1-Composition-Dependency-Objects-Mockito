package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MovieManagerTest {
    MovieManager manager = new MovieManager();

    @Test // Добавление 0 фильмов.
    public void shouldAddNullMovies() {

        String[] expected = {};
        String[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test // Добавление 1 нового фильма.
    public void shouldAddOneMovie() {
        manager.addNewMovie("Бладшот");

        String[] expected = {"Бладшот"};
        String[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test // Добавление нескольких новых фильмов.
    public void shouldAddSeveralMovies() {

        manager.addNewMovie("Вперёд");
        manager.addNewMovie("Отель Белград");
        manager.addNewMovie("Джентльмены");
        manager.addNewMovie("Человек невидимка");
        manager.addNewMovie("Тролли. Мировой тур");

        String[] expected = {"Вперёд", "Отель Белград", "Джентльмены", "Человек невидимка", "Тролли. Мировой тур"};
        String[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test // Показ последних добавленных фильмов, если добавлено больше лимита.
    public void shouldShowLastAddMoviesAddedMoreLimit() {
        manager.addNewMovie("Вперёд");
        manager.addNewMovie("Отель Белград");
        manager.addNewMovie("Джентльмены");
        manager.addNewMovie("Человек невидимка");
        manager.addNewMovie("Тролли. Мировой тур");
        manager.addNewMovie("Номер один");

        String[] expected = {"Номер один", "Тролли. Мировой тур", "Человек невидимка", "Джентльмены", "Отель Белград"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test // Показ последних добавленных фильмов, если добавлено меньше лимита.
    public void shouldShowLastAddMoviesAddedLessLimit() {

        manager.addNewMovie("Человек невидимка");

        String[] expected = {"Человек невидимка"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test // Показ последних добавленных фильмов, если добавлено равное лимиту.
    public void shouldShowLastAddMoviesAddedEqualLimit() {

        manager.addNewMovie("Вперёд");
        manager.addNewMovie("Отель Белград");
        manager.addNewMovie("Джентльмены");
        manager.addNewMovie("Человек невидимка");
        manager.addNewMovie("Тролли. Мировой тур");

        String[] expected = {"Тролли. Мировой тур", "Человек невидимка", "Джентльмены", "Отель Белград", "Вперёд"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test // Показ последних добавленных фильмов, если передаём свой лимит.
    public void shouldShowLastAddMoviesAnotherLimit() {
        int limit = 3;
        MovieManager manager = new MovieManager(limit);
        manager.addNewMovie("Вперёд");
        manager.addNewMovie("Отель Белград");
        manager.addNewMovie("Джентльмены");
        manager.addNewMovie("Человек невидимка");
        manager.addNewMovie("Тролли. Мировой тур");

        String[] expected = {"Тролли. Мировой тур", "Человек невидимка", "Джентльмены"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }
}