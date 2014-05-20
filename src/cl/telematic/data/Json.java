package cl.telematic.data;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

import java.io.File;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by crised on 5/15/14.
 */
public class Json {

    private static final Logger log = Logger.getLogger(Json.class.getName());
    private ObjectMapper mapper;

    public Json() {

        mapper = new ObjectMapper();
        mapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);
    }

    public void updateJson() {


        try {

            for (Field field : Factory.getFields()) {
                mapper.writerWithDefaultPrettyPrinter().writeValueAsString(field);
            }
            File file = new File("/home/crised/IdeaProjects/slave/parameter.json");
            mapper.write


        } catch (Exception ex) {
            log.log(Level.SEVERE, ex.toString(), ex);
            log.log(Level.FINE, "comm error");
        }


    }

    /*Map<String, Integer> parameters = new LinkedHashMap<String, Integer>();
            for (Parameter par : Parameter.values()) {
                parameters.put(par.getName(), par.getValue1());
                            mapper.writeValue(file, Parameter.values());

            }*/


}
