package jmdns;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

public class OfficeServer {
	
	public static void main(String[] args) throws IOException {
        JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

        // Register a service
        ServiceInfo light = ServiceInfo.create("_light._tcp.local.", "light", 50051, "Control the lights");
        jmdns.registerService(light);
        ServiceInfo thermometer = ServiceInfo.create("_thermometer._tcp.local.", "thermometer", 50052, "Control the thermometer");
        jmdns.registerService(thermometer);
        ServiceInfo printer = ServiceInfo.create("_printer._tcp.local.", "thermometer", 50053, "Control the printer");
        jmdns.registerService(printer);
        ServiceInfo projector = ServiceInfo.create("_projector._tcp.local.", "projector", 50054, "Control the projector");
        jmdns.registerService(projector);

       
        ServerSocket listener = new ServerSocket(9090);
        try {
            while (true) {
                Socket socket = listener.accept();
                try {
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    out.println(new Date().toString());
                } finally {
                    socket.close();
                }
            }
        } finally {
            listener.close();
        }
    }

}
