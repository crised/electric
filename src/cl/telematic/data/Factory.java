package cl.telematic.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by crised on 5/20/14.
 */
public final class Factory {

    static public final List<Field> fields = new ArrayList<Field>();;

    public Factory() {

        fields.add(new Field("Voltaje FN 1", 1));
        fields.add(new Field("Voltaje FN 2", 3));
        fields.add(new Field("Voltaje FN  3", 5));
        fields.add(new Field("Voltaje FF 1-2", 7));
        fields.add(new Field("Voltaje FF 2-3", 9));
        fields.add(new Field("Voltaje FF 3-1", 11));
        fields.add(new Field("Corriente 1", 13));
        fields.add(new Field("Corriente 2", 15));
        fields.add(new Field("Corriente 3", 17));
        fields.add(new Field("Potencia Activa 1", 19));
        fields.add(new Field("Potencia Activa 2", 21));
        fields.add(new Field("Potencia Activa 3", 23));
        fields.add(new Field("Potencia Activa Total", 25));
        fields.add(new Field("Potencia Aparente 1", 27));
        fields.add(new Field("Potencia Aparente 2", 29));
        fields.add(new Field("Potencia Aparente 3", 31));
        fields.add(new Field("Potencia Aparente Total", 33));
        fields.add(new Field("Potencia Reactiva 1", 35));
        fields.add(new Field("Potencia Reactiva 2", 37));
        fields.add(new Field("Potencia Reactiva 3", 39));
        fields.add(new Field("Potencia Reactiva Total", 41));
        fields.add(new Field("Factor de Potencia 1", 43));
        fields.add(new Field("Potencia Reactiva 3", 39));

    }

}
