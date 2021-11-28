package com.lesson25.task2513.NewPack;
import java.util.ArrayList;
import java.util.List;
public class Program {


    public static void main(String[] args) {

        List<Person> persons = new ArrayList<>();

        persons.add(new Person("Вася", 9));
        persons.add(new Person("Петяяяя", 19));
        persons.add(new Person("Боря", 34));
        persons.add(new Person("Соffgcccccня", 11));
        persons.add(new Person("Оля", 14));
        persons.add(new Person("cccccГон", 49));
        persons.add(new Person("Толик", 1));


                 persons
                .stream()
                         .filter( p -> p.getAge() == persons.get(0).getAge())
                .sorted( (p1,p2) -> Integer.compare(p1.getAge(), p2.getAge()))

                .forEach( System.out::println );


    }
}
