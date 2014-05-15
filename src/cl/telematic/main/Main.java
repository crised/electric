package cl.telematic.main;

import net.wimpi.modbus.Modbus;
import net.wimpi.modbus.io.ModbusTCPTransaction;
import net.wimpi.modbus.msg.*;
import net.wimpi.modbus.net.*;
import net.wimpi.modbus.procimg.*;
import java.net.InetAddress;


public class Main {

    public static void main(String[] args) {

        TCPMasterConnection con = null; // the connection
        ModbusTCPTransaction trans = null;
        ReadMultipleRegistersRequest req = null;
        ReadMultipleRegistersResponse res = null;

        int port = 502; // Modbus.DEFAULT_PORT 502
        int ref = 1; //
        int count = 1; // Number of Discrete Input to read

        try {

            InetAddress addr = InetAddress.getByName("crised.noip.me");
            con = new TCPMasterConnection(addr);
            con.setPort(port);
            con.setTimeout(10000);
            con.connect();
            req = new ReadMultipleRegistersRequest(ref, count);
            req.setUnitID(1);
            trans = new ModbusTCPTransaction(con);
            trans.setRequest(req);
            trans.execute();
            res = (ReadMultipleRegistersResponse) trans.getResponse();
            System.out.println("Voltage is: " + res.getRegister(0).getValue());
            con.close();


        } catch (Exception e) {
            System.out.println("error");
            System.out.println(e.getMessage());

        }

        System.out.println("Good!");
    }
}
