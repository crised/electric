package cl.telematic.main;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by crised on 5/15/14.
 */
public class Sleep {

    private static final Logger log = Logger.getLogger(Sleep.class.getName() );


    public static void sleep (Integer ms){
        try{
            Thread.sleep(ms);
        }catch(Exception ex){
            log.log( Level.SEVERE, ex.toString(), ex );
        }
    }
}
