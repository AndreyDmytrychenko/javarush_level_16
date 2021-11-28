package com.lesson19.task1903;
/*
Адаптация нескольких интерфейсов
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();
    static {
        countries.put("UA","Ukraine");
        countries.put("RU","Russia");
        countries.put("CA","Canada");
    }


    public static void main(String[] args) {
        IncomeData incomeData = new IncomeData() {
            @Override
            public String getCountryCode() {
                return "CA";
            }

            @Override
            public String getCompany() {
                return "JavaRush Ltd.";
            }

            @Override
            public String getContactFirstName() {
                return "Ivan";
            }

            @Override
            public String getContactLastName() {
                return "Ivanov";
            }

            @Override
            public int getCountryPhoneCode() {
                return 38;
            }

            @Override
            public int getPhoneNumber() {
                return 501234567;
            }
        };
        IncomeDataAdapter incomeDataAdapter = new IncomeDataAdapter(incomeData);
        System.out.println(incomeDataAdapter.getPhoneNumber());
        System.out.println(incomeDataAdapter.getCompanyName());
        System.out.println(incomeDataAdapter.getCountryName());
        System.out.println(incomeDataAdapter.getName());
    }

    public static class IncomeDataAdapter implements Contact, Customer{
        private IncomeData data;
        public IncomeDataAdapter(IncomeData data) {
            this.data = data;
        }

        @Override
        public String getCompanyName() {
            return data.getCompany();
        }

        @Override
        public String getCountryName() {
            String countryName = null;
            for (Map.Entry<String,String> values : countries.entrySet()) {
                if (values.getKey().equals(data.getCountryCode())) {
                    countryName = values.getValue();
                }
            }
            return countryName;
        }

        @Override
        public String getName() {
            return data.getContactLastName() + ", " + data.getContactFirstName();
        }

        @Override
        public String getPhoneNumber() {
            String resultTelNumber = null;

            if (String.valueOf(data.getPhoneNumber()).toCharArray().length < 11) {
                int zeroLength = 10 - String.valueOf(data.getPhoneNumber()).toCharArray().length;
                ArrayList<Character> characters = new ArrayList<>();
                char[] chars = String.valueOf(data.getPhoneNumber()).toCharArray();
                for (char ch : chars) characters.add(ch);
                for (int i = 0; i < zeroLength; i++) characters.add(0,'0');
                String newPhoneNum = "";
                for (char ch : characters) newPhoneNum += Character.toString(ch);

                String phoneCode = String.valueOf(data.getCountryPhoneCode());
                String phoneIndex = newPhoneNum.substring(0, 3);
                String phoneNum1 = newPhoneNum.substring(3, 6);
                String phoneNum2 = newPhoneNum.substring(6, 8);
                String phoneNum3 = newPhoneNum.substring(8, 10);
                resultTelNumber = String.format("+%s(%s)%s-%s-%s", phoneCode, phoneIndex, phoneNum1, phoneNum2, phoneNum3);
            }
            return resultTelNumber;
        }
    }

    public static interface IncomeData {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        int getCountryPhoneCode();      //For example: 38

        int getPhoneNumber();         //For example: 501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67
    }
}
