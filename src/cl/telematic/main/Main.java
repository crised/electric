package cl.telematic.main;

import cl.telematic.comm.Communication;
import cl.telematic.data.Json;
import cl.telematic.data.Parameter;


public class Main {

    public static void main(String[] args) {

        int interval = 5000;
        int errorInterval = 4000;


        while(true){

            Sleep.sleep(interval);



            Communication comm = new Communication();

            for(Parameter par : Parameter.values()){
                Integer valueFromResponse = comm.readValues(par.getRegNumber());


                par.setValue1(valueFromResponse);
            }
            Json  json = new Json();
            json.updateJson();
            System.out.println("Good!");

        }



    }
}
