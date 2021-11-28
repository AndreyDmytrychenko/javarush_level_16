package com.lesson20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
Читаем и пишем в файл: JavaRush
*/

public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("c:\\Users\\Андрей\\Desktop\\файл.txt", null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут

            User user = new User();
            user.setFirstName("Ril");
            user.setLastName("Rail");
            user.setBirthDate(new Date(1508944516168L));
            user.setMale(true);
            user.setCountry(User.Country.OTHER);

//            User user1 = new User();
//            user1.setFirstName("Vasa1");
//            user1.setLastName("Peta1");
//            user1.setBirthDate(new Date(1508944516163L));
//            user1.setMale(true);
//            user1.setCountry(User.Country.RUSSIA);
//
//            User user3 = new User();
//            user3.setFirstName("Solo");
//            user3.setLastName("Han");
//            user3.setBirthDate(new Date(1508944516169L));
//            user3.setMale(true);
//            user3.setCountry(User.Country.UKRAINE);
//
              javaRush.users.add(user);
//            javaRush.users.add(user1);
//            javaRush.users.add(user3);
//             инициализация закончена
            javaRush.save(outputStream);
            outputStream.flush();
            System.out.println(javaRush);

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            System.out.println(loadedObject);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(javaRush.equals(loadedObject));
            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
//implement this method - реализуйте этот метод
            PrintWriter pr = new PrintWriter(outputStream);
            if (users != null) {
                for (User u : users) {
                    pr.println(u.getFirstName());
                    pr.println(u.getLastName());
                    pr.println(u.getBirthDate().getTime());
                    pr.println(u.isMale());
                    pr.println(u.getCountry());
                    pr.flush();
                }
            }
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            while (reader.ready()) {
                User user = new User();
                user.setFirstName(reader.readLine());
                user.setLastName(reader.readLine());
                user.setBirthDate(new Date(Long.parseLong(reader.readLine())));
                user.setMale(Boolean.parseBoolean(reader.readLine()));
                user.setCountry(User.Country.valueOf(reader.readLine()));


                users.add(user);
            }
            reader.close();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }

        @Override
        public String toString() {
            for (int i = 0; i < users.size(); i++) {

                return users.get(i).getFirstName() +" "+  users.get(i).getLastName() +" "+  users.get(i).getBirthDate()
                        +" "+ users.get(i).isMale() +" "+ users.get(i).getCountry();
            }
            return null;
        }
    }
}

