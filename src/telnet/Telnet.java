package telnet;

import java.net.*;
import java.io.*;

public class Telnet {
    private Socket s;

    public Telnet(String host, int port) throws UnknownHostException, IOException {
        try {
            s = new Socket(host, port);
        } catch (IOException e) {
            e.printStackTrace();
            s.close();
        }
    }
    public void start() throws IOException, InterruptedException {

        InputStream in = s.getInputStream();
        OutputStream out = s.getOutputStream();

        while(true) {
            if (in.available() > 0) {
                System.out.print((char)in.read());
            }

            if (System.in.available() > 0) {
                out.write(System.in.read());
                out.flush();
            }

            Thread.sleep(10);
        }
    }
}
