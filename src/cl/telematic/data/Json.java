package cl.telematic.data;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by crised on 5/15/14.
 */
public class Json {


    public void updateJson() {

        ObjectMapper mapper = new ObjectMapper();


        try {

            File file = new File("/home/crised/IdeaProjects/slave/parameter.json");
            Map<String,Integer> parameters = new HashMap<String, Integer>();
            for(Parameter par : Parameter.values()){
                parameters.put(par.getName(),par.getValue1());
            }
            mapper.writeValue(file, parameters);



        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Json...");

    }


}
