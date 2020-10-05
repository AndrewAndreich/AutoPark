package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class View {
    String k = null;
    public void PrintMenu() {
        System.out.println("a) Добавление автобуса из парка в список выехавших на маршрут");
        System.out.println("b) исключение автобуса из списка выехавших на маршрут и возвращение его в парк");
        System.out.println("c) Просмотр содержимого любого списка");
        System.out.println("d) добавление маршрута");
        System.out.println("e) добавление автобуса");
        System.out.println("f) достаточность автобусов на заданном маршруте");
        System.out.println("g) поиск по фамилии водителя, соответствующего ему автобуса и маршрута");
        System.out.println("h) определение затрат бензина на всех маршрутах и отдельно для каждого");
    }
    public void PrintL() {
        System.out.print("1) Список автобусов в парке,  " );
        System.out.print("2) Список автобусов на маршруте,  ");
        System.out.println("3) Список маршрутов");
    }
    public static void PrintListBus(ArrayList<Bus> h) {
        int j = 0;
        for(Bus i: h) {
            System.out.print("Номер автобуса: " + h.get(j).getNumberAuto()+", ");
            System.out.print("Расход бензина: " + h.get(j).getGasolineConsumption()+", ");
            System.out.print("Фамилия водителя: " + h.get(j).getSurname()+", ");
            System.out.print("Имя: " + h.get(j).getName()+", ");
            System.out.print("Номер маршрута: " + h.get(j).getRouteNumber()+"\n");
            j++;
        }
    }

    public static void PrintListRoute(ArrayList<Route> m) {
        int j = 0;
        for(Route i: m) {
            System.out.print("Номер маршрута: " + m.get(j).getNumber()+", ");
            System.out.print("Автобусов на маршруте: " + m.get(j).getBusAmount()+", ");
            System.out.print("Протяженность маршрута: " + m.get(j).getLengthRoute()+"\n");
            j++;
        }
    }
}
