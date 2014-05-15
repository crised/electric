package cl.telematic.comm;

import net.wimpi.modbus.Modbus;
import net.wimpi.modbus.io.ModbusTCPTransaction;
import net.wimpi.modbus.msg.ReadMultipleRegistersRequest;
import net.wimpi.modbus.msg.ReadMultipleRegistersResponse;
import net.wimpi.modbus.net.TCPMasterConnection;

import java.net.InetAddress;

public class Communication {

    TCPMasterConnection con; // the connection
    ModbusTCPTransaction trans;
    ReadMultipleRegistersRequest req;
    ReadMultipleRegistersResponse res;

    int port = Modbus.DEFAULT_PORT; // 502
    int timeOut = 10000;
    int numberOfRegisters = 1; // Approximate 16 bit values
    int unitAdress = 1;

    public Integer readValues(Integer startReg) {

        try {

            if (con == null || !con.isConnected()) getConnection();
            setReq(startReg);
            setTrans(); // Se hara una transaccion nueva para cada parametro
            res = (ReadMultipleRegistersResponse) trans.getResponse();
            killConnection();
            return res.getRegister(0).getValue();

        } catch (Exception e) {
            System.out.println("error");
            System.out.println(e.getMessage());

        }

        return null; // On Error or no Modbus Value


    }

    private void getConnection() {

        try {
            InetAddress addr = InetAddress.getByName("crised.noip.me");
            con = new TCPMasterConnection(addr);
            con.setPort(port);
            con.setTimeout(timeOut);
            con.connect();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void setReq(Integer startReg) {

        req = new ReadMultipleRegistersRequest(startReg, numberOfRegisters); // func 03 (modbus)
        req.setUnitID(unitAdress);

    }

    private void setTrans() throws Exception {
        trans = new ModbusTCPTransaction(con);
        trans.setRequest(req);
        trans.execute();
    }


    public void killConnection() {

        if (con != null) con.close();
        con = null;
        req = null;
        trans = null;


    }


}

