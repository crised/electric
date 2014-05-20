package cl.telematic.main;

import cl.telematic.comm.Communication;
import cl.telematic.data.Json;
import cl.telematic.data.Parameter;

import java.util.Date;
import java.util.logging.*;

public class Main {

    public static void main(String[] args) {

        int interval = 0;
        int betweenRegisters = 0;
        int errorInterval = 5000;


        Communication comm = new Communication();
        Json json = new Json();

        final Logger log = Logger.getLogger(Main.class.getName());
        try {
            Handler fh = new FileHandler("/home/crised/IdeaProjects/slave/log.txt");
            log.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
            // Request that every detail gets logged.
            log.setLevel(Level.ALL);
            // Log a simple INFO message.
        } catch (Exception ex) {
            System.out.println("logger");
        }


        while (true) {

            Sleep.sleep(interval);

            for (Parameter par : Parameter.values()) {
                Integer valueFromResponse = comm.readValues(par.getRegNumber());
                Sleep.sleep(betweenRegisters);
                //one more try
                if (valueFromResponse == null) {
                    log.log(Level.FINE, "Got null :(");
                    Sleep.sleep(errorInterval);
                    valueFromResponse = comm.readValues(par.getRegNumber());
                }
                par.setValue1(valueFromResponse);
                par.setTimeStamp(new Date());
                json.updateJson();

            }
        }
    }
}
