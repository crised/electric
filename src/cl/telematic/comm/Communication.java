package cl.telematic.comm;

import net.wimpi.modbus.Modbus;
import net.wimpi.modbus.io.ModbusTCPTransaction;
import net.wimpi.modbus.msg.ReadMultipleRegistersRequest;
import net.wimpi.modbus.msg.ReadMultipleRegistersResponse;
import net.wimpi.modbus.net.TCPMasterConnection;

import java.net.InetAddress;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Communication {

    private static final Logger log = Logger.getLogger(Communication.class.getName());


    private TCPMasterConnection con; // the connection
    private ModbusTCPTransaction trans;
    private ReadMultipleRegistersRequest req;
    private ReadMultipleRegistersResponse res;

    private int port = Modbus.DEFAULT_PORT; // 502
    private int timeOut = 10000;
    private int numberOfRegisters = 1; // Approximate 16 bit values
    private int unitAdress = 1;

    public Integer readValues(Integer startReg) {

        try {

            if (con == null || !con.isConnected()) getConnection();
            setReq(startReg);
            setTrans(); // Se hara una transaccion nueva para cada parametro
            res = (ReadMultipleRegistersResponse) trans.getResponse();
            return res.getRegister(0).getValue();

        } catch (Exception ex) {
            log.log(Level.SEVERE, ex.toString(), ex);
            log.log(Level.FINE, "comm error");


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
            con = null;
            log.log(Level.INFO, "Imposible establecer conexion");
        }
    }

    private void setReq(Integer startReg) {

        req = new ReadMultipleRegistersRequest(startReg, numberOfRegisters); // func 03 (modbus)
        req.setUnitID(unitAdress);

    }

    private void setTrans() {

        try {
            trans = new ModbusTCPTransaction(con);
            trans.setRequest(req);
            trans.execute();
        } catch (Throwable tr) {
            log.log(Level.INFO, tr.toString(), "Fallo la trans");

        }
    }





}

