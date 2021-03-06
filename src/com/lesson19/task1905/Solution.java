package com.lesson19.task1905;

import java.util.HashMap;
import java.util.Map;

/*
Закрепляем адаптер
*/

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();
        static {
            countries.put("UA","Ukraine");
            countries.put("RU","Russia");
            countries.put("CA","Canada");
        }
    public static void main(String[] args) {
        DataAdapter dataAdapter = new DataAdapter(new Customer() {
            @Override
            public String getCompanyName() {
                return "JavaRush Ltd.";
            }

            @Override
            public String getCountryName() {
                return "Ukraine";
            }
        }, new Contact() {
            @Override
            public String getName() {
                return "Ivanov, Ivan";
            }

            @Override
            public String getPhoneNumber() {
                return "+380(50)123-4567";
            }
        });
        System.out.println(dataAdapter.getCompany());
        System.out.println(dataAdapter.getContactFirstName());
        System.out.println(dataAdapter.getContactLastName());
        System.out.println(dataAdapter.getCountryCode());
        System.out.println(dataAdapter.getDialString());
    }

    public static class DataAdapter implements RowItem {
            private Customer customer;
            private Contact contact;
        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        @Override
        public String getCountryCode() {
            String code = "";
            for (Map.Entry<String,String> values : countries.entrySet()) {
                if (values.getValue().equals(customer.getCountryName())) code = values.getKey();
            }
            return code;
        }

        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {

            String[] name = contact.getName().split(", ");
            return name[1];
        }

        @Override
        public String getContactLastName() {
            String[] name = contact.getName().split(", ");
            return name[0];
        }

        @Override
        public String getDialString() {
            String str1 = "";
            String str2 = "";
            String str3 = "";
            for (String s : contact.getPhoneNumber().split("\\(")) str1 += s;
            for (String s : str1.split("\\)")) str2 += s;
            for (String s : str2.split("-")) str3 += s;

            return String.format("callto://%s", str3);
        }
    }

    public static interface RowItem {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.
        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        String getDialString();         //For example: callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67 or +3(805)0123-4567 or +380(50)123-4567 or ...
    }
}

