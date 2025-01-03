# Домашнее задание курса [OTUS Java Developer. Basic](https://otus.ru/lessons/java-basic/)

## Работа с многопоточностью в Java

---
[![Build](https://github.com/alexey-sidorov-dev/otus-java-multithreading-part-one/workflows/Build/badge.svg)](https://github.com/alexey-sidorov-dev/otus-java-multithreading-part-one/actions)
![Language](https://img.shields.io/github/languages/top/alexey-sidorov-dev/otus-java-multithreading-part-one)
[![License](https://img.shields.io/github/license/alexey-sidorov-dev/otus-java-multithreading-part-one)](https://github.com/alexey-sidorov-dev/otus-java-multithreading-part-one/blob/master/LICENSE)

### Цель

Научиться работать с многопоточностью в Java.

### Задание

Необходимо выполнить две реализации задачи заполнения массива

Реализация №1

1. Реализовать метод, который создает double массив длиной 100_000_000 элементов;
2. Метод должен циклом for пройти по каждому элементу и посчитать его значение по формуле: _array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2)_;
3. Засечь время выполнения цикла и вывести его в консоль.

Реализация №2:

1. Сделать то же самое, что и в реализации №1, только массив должны заполнять 4 потока одновременно: первый поток заполняет первую четверть массива, второй - вторую и т.д;
2. Засечь время выполнения и и вывести его в консоль. Посмотреть, насколько быстрее выполнится работа по сравнению с одним потоком.


