package com.company;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Model {

    static List<String> listForBus;
    static List<String> listForRoute;
    static ArrayList<Bus> list = new ArrayList<>();
    static ArrayList<Bus> listBus = new ArrayList<>();
    static ArrayList<Route> listRoute = new ArrayList<>();
    public static List<String> ReadBus(){
        //list1.add("adfg");
        try {
            Path path = Path.of("C:\\Users\\Andrey\\IdeaProjects\\AutoPark\\src\\com\\company\\busList");
            listForBus = Files.readAllLines(path);
            return listForBus;
        } catch (Exception e){
            e.printStackTrace();
        }
        return listForBus;
        //for(String str: list)
        //System.out.println(str);
    }
    public static List<String> ReadRoute(){
        try {
            Path path = Path.of("C:\\Users\\Andrey\\IdeaProjects\\AutoPark\\src\\com\\company\\routeList");
            listForRoute = Files.readAllLines(path);
            return listForRoute;
        } catch(Exception e){
            e.printStackTrace();
        }
        return listForRoute;
    }
    public static void main(String[] args) {
        // write your code here
        //Controller r = new Controller(new Model());
        View v = new View();
        Model r = new Model();
        Controller c = new Controller(r);

        ListBus();
        ListRoute();
        //v.PrintMenu();
        c.Menu();
        //Model h = new Model();
        //Bus h[]= new Bus[5];
        //Bus bus1 =
        //System.out.println(r.Read());
        //PrintListBus(h);
        //System.out.println();
        /*ArrayList<Bus> list1 = AddTo(h, 1);
        PrintListBus(list1);
        System.out.println();
        PrintListBus(h);
        System.out.println();
        RemoveTo(h, list1, 0);
        PrintListBus(h);*/
        //AddBus(h);
        //PrintListBus(h);
        //System.out.println();
        //v.PrintListRoute(listRoute);
       // System.out.println();
        //c.AddRoute(listRoute);
        //v.PrintListRoute(listRoute);
    }

    public static ArrayList ListBus() {
        int k =0; int j=0;
        for(String i: ReadBus())
        {
            //k++;
            if(i.equals("*")) {
                k=0;
                j++;
                listBus.add(new Bus());
                //System.out.println(i);
            }
            else {
                switch(k) {
                    case 0:
                        listBus.get(j-1).setNumberAuto(i);
                        System.out.println(listBus.get(j-1).getNumberAuto());
                        break;
                    case 1:
                        listBus.get(j-1).setGasolineConsumption(i);
                        break;
                    case 2:
                        listBus.get(j-1).setSurname(i);
                        break;
                    case 3:
                        listBus.get(j-1).setName(i);
                        break;
                    case 4:
                        listBus.get(j-1).setRouteNumber(i);
                        break;
                    default:
                        break;
                }
                k++;
                //continue;
            }

        }
        return listBus;
    }
    public static ArrayList ListRoute() {
        int k = 0; int j = 0;
        //System.out.println(h.get(1).getNumberAuto());
        for(String i: ReadRoute())
        {
            if(i.equals("*")){
                k=0;
                j++;
                listRoute.add(new Route());
                //r.ReadRoute().remove(i);
                //System.out.println();
            }
            else{
                switch(k){
                    case 0:
                        listRoute.get(j-1).setLengthRoute(i);
                        break;
                    case 1:
                        listRoute.get(j-1).setBusAmount(i);
                        break;
                    case 2:
                        listRoute.get(j-1).setNumber(i);
                        break;
                    default:
                        break;

                }
                k++;
                //System.out.println(i);
            }
        }
        return listRoute;
    }
    public static ArrayList AddTo(ArrayList<Bus> h, int i, ArrayList<Bus> list) {
        //ArrayList<Bus> list = new ArrayList<>();
        list.add(h.get(i));
        h.remove(i);
        return list;
    }
    public static List RemoveTo(ArrayList<Bus> h, List <Bus> list, int i) {
        h.add(list.get(i));
        list.remove(i);
        return list;
    }

    public static int StringToInt(String i){
        try{
            int j = Integer.parseInt(i.trim());
            return j;
        } catch(NumberFormatException nfe){
            System.out.println("NumberFormatException: " + nfe.getMessage());
            return -1;
        }
    }
    public static boolean EnoughBusOnAmount(ArrayList<Bus> list, String i, ArrayList<Route> m) {
        int k = 0;
        for(int j = 0; j<m.size(); j++){
            if((m.get(j).getNumber()).equals(i)) {
                for(int q = 0; q<list.size(); q++){
                    if(list.get(q).getRouteNumber().equals(i))
                        k++;
                }
                if(StringToInt(m.get(j).getBusAmount())>k)
                    return false;
                else
                    return true;
            }
            else
                return false;

        }
        return false;
    }

    public static int Search(ArrayList<Bus> list, String i) {
        for(int j = 0; j<list.size(); j++){
            if(list.get(j).getSurname().equals(i))
                return j;
        }
        return -1;
    }

    public static int SearchRoute(ArrayList<Route> list, int number) {
        for(int j = 0; j<list.size(); j++){
            if(StringToInt(list.get(j).getNumber())==number)
                return j;
        }
        return -1;
    }

}

