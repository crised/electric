package cl.telematic.main;

import cl.telematic.comm.Communication;
import cl.telematic.data.Json;
import cl.telematic.data.Parameter;


public class Main {

    public static void main(String[] args) {

        while(true){

            try{
                Thread.sleep(5000);
            }catch(Exception e){
                System.out.println("Thread Error");
            }

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
