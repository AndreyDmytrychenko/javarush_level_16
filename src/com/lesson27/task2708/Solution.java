package com.lesson27.task2708;

import java.util.Set;

/*
Убираем deadLock используя открытые вызовы
*/

public class Solution {
    public static void main(String[] args) {
        final long deadline = System.currentTimeMillis() + 5000; //waiting for 5 sec ..к текущему времени прибавили 5с..

        final RealEstate realEstate = new RealEstate();
        Set<Apartment> allApartments = realEstate.getAllApartments();

        final Apartment[] apartments = allApartments.toArray(new Apartment[allApartments.size()]); // создали масив апартоментов

        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10; i++) {
                        realEstate.revalidate(); // удаление всех эл из актив апарт, рандомный
                        // выбор добавлениее или нет в активн апарт объекта
                    }
                }
            }, "RealEstateThread" + i).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < apartments.length; i++) {
                        apartments[i].revalidate(true); // в актив апартоменты добавлен объект
                    }
                }
            }, "ApartmentThread" + i).start();
        }

        Thread deamonThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (System.currentTimeMillis() < deadline)
                    try {
                        Thread.sleep(2);
                    } catch (InterruptedException ignored) {
                    }
                System.out.println("Deadlock occurred");
            }
        });
        deamonThread.setDaemon(true);
        deamonThread.start();
    }
}

