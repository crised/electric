package cl.telematic.data;

import java.util.Date;

/**
 * Created by crised on 5/15/14.
 */
public enum Parameter {

    VOLTAGE1("Voltaje FN 1", 1), VOLTAGE2("Voltaje FN 2", 3),
    VOLTAGE3("Voltaje FN  3", 5), VOLTAGEL12("Voltaje FF 1-2", 7),
    VOLTAGEL23("Voltaje FF 2-3", 9), VOLTAGEL31("Voltaje FF 3-1", 9),
    CURRENT1("Corriente 1", 13), CURRENT2("Corriente 2", 15),
    CURRENT3("Corriente 3", 17), ACTIVEPOWER1("Potencia Activa 1", 19),
    ACTIVEPOWER2("Potencia Activa 2", 21), ACTIVEPOWER3("Potencia Activa 3", 23),
    TOTALPOWER("Potencia Activa Total", 25), APPARENTPOWER1("Potencia Aparente 1", 27),
    APPARENTPOWER2("Potencia Aparente 2", 29), APPARENTPOWER3("Potencia Aparente 3", 31),
    TOTALAPPARENTPOWER1("Potencia Aparente Total", 33), REACTIVEPOWER1("Potencia Reactiva 1", 35),
    REACTIVEPOWER2("Potencia Reactiva 2", 37), REACTIVEPOWER3("Potencia Reactiva 3", 39),
    TOTALREACTIVEPOWER("Potencia Reactiva Total", 41), POWERFACTOR1("Factor de Potencia 1", 43);

    private String name;
    private Integer regNumber;
    private Integer value1;
    private Integer value2;
    private Date timeStamp;
    //Se toma solo la aprox del Valor (1 registro)


    Parameter(String name, Integer regNumber) {
        this.name = name;
        this.regNumber = regNumber;
        this.value1 = null;
        this.value2 = null;
        this.timeStamp = null;

    }

    public String getName() {
        return name;
    }

    public Integer getRegNumber() {
        return regNumber;
    }

    public Integer getValue1() {
        return value1;
    }

    public void setValue1(Integer value1) {
        this.value1 = value1;
    }

    public Integer getValue2() {
        return value2;
    }

    public void setValue2(Integer value2) {
        this.value2 = value2;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }
}
