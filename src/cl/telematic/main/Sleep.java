package cl.telematic.main;

/**
 * Created by crised on 5/15/14.
 */
public class Sleep {

    public static void sleep (Integer ms){
        try{
            Thread.sleep(5000);
        }catch(Exception e){
            System.out.println("Thread Error");
        }
    }
}
