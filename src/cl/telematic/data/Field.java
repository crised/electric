package cl.telematic.data;

import java.util.Date;

/**
 * Created by crised on 5/20/14.
 */
public class Field {

    private final String name;
    private final Integer regNumber;
    private Integer value1;
    private Integer value2;
    private Date timeStamp;

    public Field(String name, Integer regNumber) {
        this.name = name;
        this.regNumber = regNumber;
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
