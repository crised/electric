package cl.telematic.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by crised on 5/20/14.
 */
public class Factory {

    static public final List<Field> fields = new ArrayList<Field>();

    public Factory() {

        fields.add(new Field("Voltaje FN 1", 1));
        fields.add(new Field("Voltaje FN 2", 3));

    }
}
