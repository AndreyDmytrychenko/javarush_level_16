package com.lesson27.task2709;

public class TransferObject {
    private int value;
    protected volatile boolean isValuePresent = false; //use this variable

    public synchronized int get()  {
        while (!isValuePresent) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
            isValuePresent = false;
            System.out.println("Got: " + value);
            notify();

        return value;
    }

    public synchronized void put(int value) {
      while (isValuePresent) {
          try {
              wait();
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
      }
          this.value = value;
          isValuePresent = true;
          System.out.println("Put: " + value);
          notify();

    }
}

