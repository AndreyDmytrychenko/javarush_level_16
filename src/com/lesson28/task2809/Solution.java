package com.lesson28.task2809;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Phaser;

/*
Plants vs Zombies
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        List<Character> characters = new ArrayList<>();
        characters.add(new Plant());
        characters.add(new Plant());
        characters.add(new Zombie());
        characters.add(new Zombie());
        characters.add(new Zombie());
        start(characters);
    }

    private static boolean isEveryoneReady = false;

    private static void start(List<Character> characters) throws InterruptedException {
        final Phaser phaser = new Phaser(1 + characters.size());

        for (final Character character : characters) {
            final String member = character.toString();
            System.out.println(member + " присоединился к игре");
            new Thread() {
                @Override
                public void run() {

                    System.out.println(member + " готовится играть");
                    phaser.arriveAndAwaitAdvance();// ждет когда все треды будут созданы
                    if (!isEveryoneReady) {
                        isEveryoneReady = true;
                        System.out.println("Игра началась!");
                    }
                    character.run();
                }
            }.start();
        }
        phaser.arriveAndDeregister();//начинает запускать метод ран у тасков
    }
}
/* void runTasks(List<Runnable> tasks) {
   Phaser startingGate = new Phaser(1); // "1" to register self
   // create and start threads
   for (Runnable task : tasks) {
     startingGate.register();
     new Thread(() -> {
       startingGate.arriveAndAwaitAdvance();
       task.run();
     }).start();
   }

   // deregister self to allow threads to proceed
   startingGate.arriveAndDeregister();
 }*/