package jmdnsfiles;

import java.io.IOException;
import java.net.InetAddress;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

public class SmartOfficeServiceRegistration {
	
	public static void main(String[] args) throws InterruptedException {

        try {
            // Create a JmDNS instance
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

            // Register a service
            ServiceInfo light = ServiceInfo.create("_http._tcp.local.", "light", 50055, "Control the lights");
            jmdns.registerService(light);
            ServiceInfo thermostat = ServiceInfo.create("_http._tcp.local.", "thermostat", 50052, "Control the thermostat");
            jmdns.registerService(thermostat);
            ServiceInfo printer = ServiceInfo.create("_http._tcp.local.", "printer", 50053, "Control the printer");
            jmdns.registerService(printer);
            ServiceInfo projector = ServiceInfo.create("_http._tcp.local.", "projector", 50054, "Control the projector");
            jmdns.registerService(projector);

            // Wait a bit
            Thread.sleep(25000);

            // Unregister all services
            jmdns.unregisterAllServices();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
