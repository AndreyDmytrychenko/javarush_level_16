package com.lesson24.task2406;



/*
Наследование от внутреннего класса
*/

import java.math.BigDecimal;

public class Solution {
        public class Building {

            public class Hall {
                private BigDecimal square;

                public Hall(BigDecimal square) {
                    this.square = square;
                }


            }

            public class Apartments {
            }
        }
        public class Apt3Bedroom extends Building.Apartments {

            Apt3Bedroom(Building building) {
                building.super();
            }
        }
         public class BigHall extends Building.Hall {
            BigHall(Building building, BigDecimal decimal) {
                building.super(decimal);
            }
         }

        public static void main(String[] args) {

        }
    }
