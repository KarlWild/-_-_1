package com.company;

/*
Напишите программу «Адрес человека». Есть сущность Человек, которая
связана с сущностью Адрес. Считается, что у каждого человека есть только
один адрес. Организовать массив объектов Человек (не менее 4) и по массиву:
 осуществить поиск Человека по фамилии;
 осуществить поиск человека по атрибуту адреса;
 вывести людей, родившихся между определенными датами;
 найти самого старого (молодого);
 найти людей, проживающих на одной улице.
*/
public class SearchHumanAddress {
    Human[] humans;
    public SearchHumanAddress(){
        humans = new Human[6];
        humans[0] = new Human("Петр","Иванов", 29, 12, 4, 1992, "ул. Чайковского 13");
        humans[1] = new Human("Илья","Крылов", 20, 30, 2, 2001, "ул. Чайковского 24");
        humans[2] = new Human("Екатерина","Попова", 60, 25, 7, 1960, "ул. Пушкина 154");
        humans[3] = new Human("Анна","Сашова", 21, 21, 1, 2000, "ул. Куйбышева 12");
        humans[4] = new Human("Михаил","Петров", 31, 1, 3, 1990, "ул. Георгиевская 23");
        humans[5] = new Human("Иван","Борисов", 0, 4, 8, 2020, "ул. Пушкина 45");
    }
    //демонстрирование работы каждого метода
    public void Process(){
        System.out.println("По фамилии");
        surnameSearch("Иванов");
        System.out.println("По точному адресу");
        addressSearch("ул. Чайковского 24");
        System.out.println("По промежутку дат");
        dateDurationSearch(new int[]{1,1,2000},new int[]{1,1,2300});
        System.out.println("Самый старый");
        oldestSearch();
        System.out.println("По улице");
        peopleOnTheSameAddress("ул. Чайковского");
    }

    //поиск по фамилии
    public void surnameSearch(String surname){
        Human found = new Human();
        for(Human hum : humans){
            if(hum.getSurname().equalsIgnoreCase(surname)) found = hum;
        }
        System.out.println(found.toString());
    }
    //поиск по адресу
    public void addressSearch(String address){
        Human found = new Human();
        for(Human hum : humans){
            if(hum.getAddress().toString().equalsIgnoreCase(address)) found = hum;
        }
        System.out.println(found.toString());
    }
    //поиск по промежутку дат
    public void dateDurationSearch(int[] startDate, int[] endDate){
        Human[] found = new Human[humans.length];
        int i = 0;
        for(Human hum : humans){
            if(hum.getBirthday()[2] > startDate[2] && hum.getBirthday()[2] < endDate[2]) found[i++] = hum;
            else if(hum.getBirthday()[2] == startDate[2] || hum.getBirthday()[2] == endDate[2]){
                if(hum.getBirthday()[1] > startDate[1] && hum.getBirthday()[1] < endDate[1]) found[i++] = hum;
                else if(hum.getBirthday()[1] == startDate[1] || hum.getBirthday()[1] == endDate[1]) {
                    if(hum.getBirthday()[0] >= startDate[0] && hum.getBirthday()[0] <= endDate[0]) found[i++] = hum;
                }
            }
        }
        for(Human hum : found) if(hum!=null) System.out.println(hum.toString());

    }
    //старый\молодой
    public void oldestSearch(){
        Human oldestHuman = new Human();
        int max = Integer.MIN_VALUE;
        for(Human hum : humans){
            if(hum.getAge()>max) {
                max = hum.getAge();
                oldestHuman = hum;
            }
        }
        System.out.println(oldestHuman.toString());
    }
    //на одной улице
    public void peopleOnTheSameAddress(String address){
        Human[] found = new Human[humans.length];
        Address search = new Address(address);
        int i = 0;
        for(Human hum : humans){
            String addressHum = hum.getAddress().toString().replaceAll("[0-9]","");
            addressHum = addressHum.replaceAll(" ", "");
            if(addressHum.equalsIgnoreCase(search.toString().replaceAll(" ",""))) found[i++] = hum;
        }
        for(Human hum : found) if(hum!=null) System.out.println(hum.toString());
    }
}
