package ru.otus.java.basic.multithreading;

public class App {

  public static void main(String[] args) {
    long singleThreadNanoTime = fillArraySingleThread(new double[100_000_000]);
    System.out.println(
        "Время заполнения массива в один поток: " + (String.format("%.3f",
            (double) singleThreadNanoTime / 1_000_000_000)) + " сек");

    try {
      long multiThreadNanoTime = fillArrayMultiThread(new double[100_000_000]);
      System.out.println(
          "Время заполнения массива в 4 потока: " + (String.format("%.3f",
              (double) multiThreadNanoTime / 1_000_000_000)) + " сек");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  /**
   * Заполнение массива в один поток
   *
   * @param array Заполняемый массив double
   */
  static long fillArraySingleThread(double[] array) {
    long start = System.nanoTime();
    for (int i = 0; i < array.length; i++) {
      calculateArrayElement(array, i);
    }

    return System.nanoTime() - start;
  }

  /**
   * Заполнение массива в 4 потока
   *
   * @param array Заполняемый массив double
   */
  static long fillArrayMultiThread(double[] array) throws InterruptedException {
    long start = System.nanoTime();
    int bound = array.length / 4;

    Thread t1 = new Thread(() -> {
      for (int i = 0; i < bound; i++) {
        calculateArrayElement(array, i);
      }
    });

    Thread t2 = new Thread(() -> {
      for (int i = bound; i < bound * 2; i++) {
        calculateArrayElement(array, i);
      }
    });

    Thread t3 = new Thread(() -> {
      for (int i = bound * 2; i < bound * 3; i++) {
        calculateArrayElement(array, i);
      }
    });

    Thread t4 = new Thread(() -> {
      for (int i = bound * 3; i < array.length; i++) {
        calculateArrayElement(array, i);
      }
    });

    t1.start();
    t2.start();
    t3.start();
    t4.start();
    t1.join();
    t2.join();
    t3.join();
    t4.join();

    return System.nanoTime() - start;
  }

  /**
   * Рассчитать элемент массива
   *
   * @param array Заполняемый массив
   * @param index Рассчитываемый элемент массива
   */
  static void calculateArrayElement(double[] array, int index) {
    array[index] = 1.14 * Math.cos(index) * Math.sin(index * 0.2) * Math.cos(index / 1.2);
  }
}