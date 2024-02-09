/*
    Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
    Создать множество ноутбуков.
    Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки,
    отвечающие фильтру. Критерии фильтрации можно хранить в Map.
    Например:
    “Введите цифру, соответствующую необходимому критерию:
        1 - ОЗУ
        2 - Объем ЖД
        3 - Операционная система
        4 - Цвет …
        5 - поиск
    Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно
    также в Map.
    Отфильтровать ноутбуки из первоначального множества и вывести проходящие по условиям.

    Частые ошибки:
    1. Заставляете пользователя вводить все существующие критерии фильтрации
    2. Невозможно использовать более одного критерия фильтрации одновременно
    3. При выборке выводятся ноутбуки, которые удовлетворяют только одному фильтру, а не всем введенным пользователем
    4. Работа выполнена только для каких то конкретных ноутбуков, и если поменять характеристики ноутбуков
    или добавить еще ноутбук, то программа начинает работать некорректно
    */

import com.sun.jdi.Value;

import java.security.Key;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // Вносим базу компьютеров:
        Computers comp1 = new Computers();
        comp1.ozu = 8;
        comp1.disk = 256;
        comp1.os = "Windows 11";
        comp1.color = "красный";

        Computers comp2 = new Computers();
        comp2.ozu = 2;
        comp2.disk = 512;
        comp2.os = "Windows 8";
        comp2.color = "черный";

        Computers comp3 = new Computers();
        comp3.ozu = 4;
        comp3.disk = 128;
        comp3.os = "Windows 8";
        comp3.color = "черный";

        Computers comp4 = new Computers();
        comp4.ozu = 16;
        comp4.disk = 512;
        comp4.os = "Windows 11";
        comp4.color = "синий";

        Computers comp5 = new Computers();
        comp5.ozu = 8;
        comp5.disk = 1024;
        comp5.os = "Windows 11";
        comp5.color = "красный";

        Computers comp6 = new Computers();
        comp6.ozu = 16;
        comp6.disk = 512;
        comp6.os = "Windows 8";
        comp6.color = "синий";

        Set<Computers> computers = new HashSet<>();
        computers.add(comp1);
        computers.add(comp2);
        computers.add(comp3);
        computers.add(comp4);
        computers.add(comp5);
        computers.add(comp6);

        // Спрашиваем пользователя параметры поиска:

        Scanner scanner = new Scanner(System.in);
        Map<Integer,String> chois = new HashMap<>(4);
        chois.put(1, "Введите минимальное значение Оперативной памяти в Гб:");
        chois.put(2, "Введите минимальный объем Жесткого диска в Гб:");
        chois.put(3, "Выберите номер Операционной системы: 1 - Windows 8,   2 - Windows 11");
        chois.put(4, "Выберите номер цвета: 1 - красный, 2 - синий, 3 - черный ");

        Map<Integer,Integer> polzovatel = new HashMap<>();
        int a = 0;
        while(a!=5){
            System.out.println("Введите цифру, соответствующую необходимому критерию:\n" +
                    "        1 - ОЗУ\n" +
                    "        2 - Объем ЖД\n" +
                    "        3 - Операционная система\n" +
                    "        4 - Цвет …\n" +
                    "        5 - поиск\n");
            a = Integer.parseInt(scanner.nextLine());
            switch (a){
                case 1:
                    System.out.println(chois.get(a));
                    polzovatel.put(a, Integer.parseInt(scanner.nextLine()));
                    break;
                case 2:
                    System.out.println(chois.get(a));
                    polzovatel.put(a, Integer.parseInt(scanner.nextLine()));
                    break;
                case 3:
                    System.out.println(chois.get(a));
                    polzovatel.put(a, Integer.parseInt(scanner.nextLine()));
                    break;
                case 4:
                    System.out.println(chois.get(a));
                    polzovatel.put(a, Integer.parseInt(scanner.nextLine()));
                    break;


            }
        }

        // Выводим результаты поиска:
        System.out.println("По вашим введенным параметрам :");
        printVvod(polzovatel);
        System.out.println("Подходят следующие компьютеры:");

        // Наполняем выбор пользователя нулями где не был указан выбор параметра
        Map<Integer,Integer> poisk = new HashMap<>();
        poisk = polzovatel;
        for (int i = 1; i < 5; i++) {
            poisk.putIfAbsent(i, 0);
        }
        // Выводим итог используя метод:

        if (filter(computers,poisk).size() == 0){
            System.out.println("к сожалению в наличие нет подходящих компьютеров((");
        } else {
            printSet(filter(computers, poisk));

        }


    }

    // Метод для поиска нужного ПК:
    static Set<Computers> filter(Set<Computers> computers, Map<Integer, Integer> set1) {
        Set<Computers> itogo = new HashSet<>();

        for (Computers compp : computers) {
            int i = 0;
            int j = 0;
            int count = 0;
            switch (compp.os) {
                case "Windows 8":
                    i = 1;
                    break;
                case "Windows 11":
                    i = 2;
            }
            switch (compp.color) {
                case "красный":
                    j = 1;
                    break;
                case "синий":
                    j = 2;
                    break;
                case "черный":
                    j = 3;
                    break;
            }
            int k = 1;
            while (k != 5) {
                if (set1.get(k) != 0) {
                    if (compp.ozu > set1.get(k)) {
                        count++;
                    }
                } else {
                    count++;
                }
                k++;
                if (set1.get(k) != 0) {
                    if (compp.disk > set1.get(k)) {
                        count++;
                    }
                } else {
                    count++;
                }
                k++;
                if (set1.get(k) != 0) {
                    if (i == set1.get(k)) {
                        count++;
                    }
                } else {
                    count++;
                }
                k++;
                if (set1.get(k) != 0) {
                    if (j == set1.get(k)) {
                        count++;
                    }
                } else {
                    count++;
                }
                k++;

            }
            if (count == 4){
                itogo.add(compp);
            }

        }
        return itogo;
    }



    static void printSet(Set<Computers> set) {
        for (Computers comp : set) {
            System.out.println(comp);
        }

    }

    static void printVvod(Map<Integer, Integer> vvod) {
//        Set<Integer> key = (Set<Integer>) new HashMap<>();
//        key = vvod.keySet();
//        Stream<Integer> sorted = key.stream().sorted();
        for (var i : vvod.keySet()){
            switch (i){
                case 1:
                    System.out.println("ОЗУ = " + vvod.get(i));
                    break;
                case 2:
                    System.out.println("Объем ЖД = " + vvod.get(i));
                    break;
                case 3:
                    if(vvod.get(i) == 1){
                        System.out.println("Операционная система - Windows 8");
                    }
                    if(vvod.get(i) ==2) {
                        System.out.println("Операционная система - Windows 11");
                    }
                    break;
                case 4:
                    if(vvod.get(i) == 1){
                        System.out.println("Цвет - красный");
                    } 
                    if (vvod.get(i) == 2) {
                        System.out.println("Цвет - синий");
                    }
                    if (vvod.get(i) == 3) {
                        System.out.println("Цвет - черный");
                    }
                    break;
            }

        }

        }
    }


