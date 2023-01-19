import telnet.Telnet;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    static Logger logger = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {

        try {
            if (args.length < 2) {
                logger.log(Level.INFO, "Program arguments not defined: Hostname and port number");
                System.exit(-1);
            }
            String host = args[0];
            int port = Integer.parseInt(args[1]);

            logger.log(Level.INFO, "Start");

            //"localhost" 1180
            Telnet v = new Telnet(host, port);
            v.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}