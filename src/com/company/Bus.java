package com.company;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Bus {
    private String numberAuto;
    private String gasolineConsumption;
    private String surname;
    private String name;
    private String routeNumber;
    List<String> listBus;

    public String getNumberAuto() {
        return numberAuto;
    }

    public void setNumberAuto(String numberAuto) {
        this.numberAuto = numberAuto;
    }

    public String  getGasolineConsumption() {
        return gasolineConsumption;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRouteNumber() {
        return routeNumber;
    }

    public void setRouteNumber(String routeNumber) {
        this.routeNumber = routeNumber;
    }

    public void setGasolineConsumption(String gasolineConsumption) {
        this.gasolineConsumption = gasolineConsumption;
    }

    public Bus() {
    }

    /*public List<String> ReadBus(){
        //list1.add("adfg");
        try {
            Path path = Path.of("C:\\Users\\Andrey\\IdeaProjects\\AutoPark\\src\\com\\company\\busList");
            listBus = Files.readAllLines(path);
            return listBus;
        } catch (Exception e){
            e.printStackTrace();
        }
        return listBus;
        //for(String str: list)
        //System.out.println(str);
    }*/
}
