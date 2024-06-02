package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MovieManagerTest {
    MovieManager manager = new MovieManager();

    @Test // Добавление 0 фильмов.
    public void shouldAddNullMovies() {

        String[] expected = {};
        String[] actual = manager.ShowAllMovies();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test // Добавление 1 нового фильма.
    public void shouldAddOneMovie() {
        manager.AddNewMovie("Бладшот");

        String[] expected = {"Бладшот"};
        String[] actual = manager.ShowAllMovies();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test // Добавление нескольких новых фильмов.
    public void shouldAddSeveralMovies() {

        manager.AddNewMovie("Вперёд");
        manager.AddNewMovie("Отель Белград");
        manager.AddNewMovie("Джентльмены");
        manager.AddNewMovie("Человек невидимка");
        manager.AddNewMovie("Тролли. Мировой тур");

        String[] expected = {"Вперёд", "Отель Белград", "Джентльмены", "Человек невидимка", "Тролли. Мировой тур"};
        String[] actual = manager.ShowAllMovies();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test // Показ последних добавленных фильмов, если добавлено больше лимита.
    public void shouldShowTheLastAddMoviesIfAddedMoreThanLimit() {
        manager.AddNewMovie("Вперёд");
        manager.AddNewMovie("Отель Белград");
        manager.AddNewMovie("Джентльмены");
        manager.AddNewMovie("Человек невидимка");
        manager.AddNewMovie("Тролли. Мировой тур");
        manager.AddNewMovie("Номер один");

        String [] expected = {"Номер один", "Тролли. Мировой тур", "Человек невидимка", "Джентльмены", "Отель Белград"};
        String[] actual = manager.ShowTheLastAddedMovie();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test // Показ последних добавленных фильмов, если добавлено меньше лимита.
    public void shouldShowTheLastAddMoviesIfAddedLessThanLimit() {

        manager.AddNewMovie("Человек невидимка");

        String [] expected = {"Человек невидимка"};
        String[] actual = manager.ShowTheLastAddedMovie();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test // Показ последних добавленных фильмов, если добавлено равное лимиту.
    public void shouldShowTheLastAddMoviesIfAddedEqualToTheLimit() {

        manager.AddNewMovie("Вперёд");
        manager.AddNewMovie("Отель Белград");
        manager.AddNewMovie("Джентльмены");
        manager.AddNewMovie("Человек невидимка");
        manager.AddNewMovie("Тролли. Мировой тур");

        String [] expected = {"Тролли. Мировой тур", "Человек невидимка", "Джентльмены", "Отель Белград", "Вперёд"};
        String[] actual = manager.ShowTheLastAddedMovie();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test // Показ последних добавленных фильмов, если передаём свой лимит.
    public void test () {
        int limit = 3;
        MovieManager manager = new MovieManager(limit);
        manager.AddNewMovie("Вперёд");
        manager.AddNewMovie("Отель Белград");
        manager.AddNewMovie("Джентльмены");
        manager.AddNewMovie("Человек невидимка");
        manager.AddNewMovie("Тролли. Мировой тур");

        String [] expected = {"Тролли. Мировой тур", "Человек невидимка", "Джентльмены"};
        String[] actual = manager.ShowTheLastAddedMovie();
        Assertions.assertArrayEquals(expected, actual);
    }
}