package jmdnsfiles;

import java.io.IOException;
import java.net.InetAddress;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

public class SmartOfficeServiceRegistration {
	
	public static void main(String[] args) throws InterruptedException {

        try {
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

            ServiceInfo serviceInfo = ServiceInfo.create("_http._tcp.local.", "example", 8000, "path=index.html");
            jmdns.registerService(serviceInfo);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
