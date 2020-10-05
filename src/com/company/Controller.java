package com.company;

import java.util.ArrayList;
import java.util.Scanner;

import static com.company.Model.*;

public class Controller {
    private Model model;
    Controller(Model model){
        this.model = model;
    }
    //List<String> list;
    public static void AddRoute(ArrayList<Route> m) {
        try {
            Route route1 = new Route();
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter the route number: ");
            route1.setNumber(scan.nextLine());
            System.out.println("Enter the length route: ");
            route1.setLengthRoute(scan.nextLine());
            System.out.println("Enter the bus amount");
            route1.setBusAmount(scan.nextLine());
            m.add(m.size(), route1);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void AddBus(ArrayList<Bus> h) {
        try {
            Bus bus1 = new Bus();
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter the route number: ");
            bus1.setRouteNumber(scan.nextLine());
            System.out.println("Enter the name");
            bus1.setName(scan.nextLine());
            System.out.println("Enter surName");
            bus1.setSurname(scan.nextLine());
            System.out.println("Enter gasoline consumption: ");
            bus1.setGasolineConsumption(scan.nextLine());
            System.out.println("Enter auto number: ");
            bus1.setNumberAuto(scan.nextLine());
            h.add(h.size(), bus1);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void Menu() {
        Model model = new Model();
        View view = new View();
        String k;
        int h;
        view.PrintMenu();
        System.out.println("Enter the relevant item");
        try {
            Scanner scan = new Scanner(System.in);
            k = scan.nextLine();
            switch (k) {
                case "a":
                    System.out.println("Enter the index: ");
                    model.AddTo(listBus, scan.nextInt(), list);
                    break;
                case "b":
                    System.out.println("Enter the index: ");
                    model.RemoveTo(listBus, list, scan.nextInt());
                    break;
                case "c":
                    view.PrintL();
                    System.out.println("Choose the list: ");
                    h = scan.nextInt();
                    switch(h) {
                        case 1:
                            view.PrintListBus(listBus);
                            break;
                        case 2:
                            view.PrintListBus(list);
                            break;
                        case 3:
                            view.PrintListRoute(listRoute);
                            break;
                        default:
                            break;
                    }
                    break;
                case "d":
                    AddBus(listBus);
                    break;
                case "e":
                    AddRoute(listRoute);
                    break;
                case "f":
                    System.out.println("Enter the number of route");
                    if(model.EnoughBusOnAmount(list, scan.nextLine(), ListRoute()))
                        System.out.println("Enough bus on amount");
                    else
                        System.out.println("Not enough!");
                    break;
                case "g":
                    int number = -1;
                    System.out.println("Enter surname of driver");
                    String surName = scan.nextLine();
                    int j = Search(listBus, surName);
                    if(j!=-1){
                        ArrayList<Bus> bList = new ArrayList<>();
                        number = model.StringToInt(listBus.get(j).getRouteNumber());
                        bList.add(listBus.get(j));
                        view.PrintListBus(bList);
                    }
                    else {
                        j = Search(list, surName);
                        if(j!=-1){
                            ArrayList<Bus> bList = new ArrayList<>();
                            number = model.StringToInt(list.get(j).getRouteNumber());
                            bList.add(list.get(j));
                            view.PrintListBus(bList);
                        }
                        else {
                            System.out.println("This driver is not exist!");
                            break;
                        }
                    }
                    int i = SearchRoute(listRoute, number);
                    if(i!=-1){
                        ArrayList<Route> rList = new ArrayList<>();
                        rList.add(listRoute.get(i));
                        view.PrintListRoute(rList);
                    }
                    else
                        System.out.println("This route is not exist!");
                    break;

                default:
                    break;
            }
        } catch(Exception e) {
            e.printStackTrace();
            Menu();
        }
        Menu();
    }
}
