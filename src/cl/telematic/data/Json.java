package cl.telematic.data;

import com.sun.org.apache.bcel.internal.generic.FADD;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by crised on 5/15/14.
 */
public class Json {

    public static String jsonString;
    private static final Logger log = Logger.getLogger(Json.class.getName());
    private ObjectWriter writter;


    public Json() {

        writter = new ObjectMapper().writer();
    }

    public void updateJson() {

        try {

            jsonString = writter.writeValueAsString(Factory.fields);


        } catch (Exception ex) {
            log.log(Level.SEVERE, ex.toString(), ex);
        }
    }
}
