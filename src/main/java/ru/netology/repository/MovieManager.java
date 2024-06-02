package ru.netology.repository;

public class MovieManager {

    /* Менеджер выполняет следующие операции:

 1. Добавление нового фильма.
 2. Вывод всех фильмов в порядке добавления.
 3. Вывод (максимальный лимит) последних добавленных фильмов в обратном от добавления порядке.
 4. По умолчанию выводится последние 5 добавленных фильма.
 5. При создании менеджера можно указать другой лимит.
 6. У менеджера 2 конструктора:
 — без параметров (выставляет лимит менеджера в 5);
 — с параметром (берёт значение лимита для менеджера из параметра конструктора). */

    // Конструкторы менеджера.
    private int limit; // Лимит добавленных фильмов.

    public MovieManager() {
        this.limit = 5;
    }

    public MovieManager(int limit) {
        this.limit = limit;
    }

    // Поле для хранения набора фильмов.
    private String[] movies = new String[0];

    // Метод добавления фильма.
    // Создаём массив tmp с длиной movies.length + 1.
    // Копируем массив movies в tmp.
    // Добавляем новый фильм movie в массив tmp.
    // Записываем массив movies в новый массив tmp.

    public void addNewMovie(String movie) {
        String[] tmp = new String[movies.length + 1];
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }
        tmp[tmp.length - 1] = movie;
        movies = tmp;
    }

    // Метод показа всех фильмов.
    public String[] showAllMovies() {
        return movies; // Возвращаем массив movies со всеми фильмами.
    }

    // Метод показа последних добавленных фильмов.

    public String[] showLastAddedMovies() {
        int arrayLength; // Длина массива с лимитом.

        // Если фильмов добавлено меньше лимита, длина массива равна количеству фильмов.
        // Иначе длина массива равна установленному лимиту — 5.

        if (movies.length < limit) {
            arrayLength = movies.length;
        } else {
            arrayLength = limit;
        }
        String [] tmp = new String[arrayLength]; // Массив ответа с лимитом.
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = movies[movies.length - 1 - i]; // Заполняем массив tmp последними добавленными фильмами.
        }
        return tmp;
    }
}