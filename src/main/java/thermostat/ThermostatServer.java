package thermostat;

import java.io.IOException;
import java.util.logging.Logger;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import thermostat.ThermostatServiceGrpc.ThermostatServiceImplBase;

public class ThermostatServer extends ThermostatServiceImplBase{
	
	private static final Logger logger = Logger.getLogger(ThermostatServer.class.getName());
	
	public static void main(String[] args) throws IOException, InterruptedException {
		ThermostatServer thermostatserver = new ThermostatServer();
	   
	    int port = 50052;
	    Server server = ServerBuilder.forPort(port)
	        .addService(thermostatserver)
	        .build()
	        .start();
	    
	    logger.info("Server started, listening on " + port);
	    		    
	    server.awaitTermination();
	}
	
	public void switchPower(PowerRequest request, StreamObserver<PowerResponse> responseObserver) {
        System.out.println("Receiving request for power!");

        Boolean power = request.getSwitch();
        if (power) {
        	System.out.println("Setting power to on!");
        }
        else {
        	System.out.println("Setting power to off!");
        }
        
        PowerResponse response = PowerResponse.newBuilder().setSwitch(power).build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();

	}
	
	public void changeTemperature(TemperatureRequest request, StreamObserver<TemperatureResponse> responseObserver) {		 
		 int temp = request.getTemperature();
		 System.out.println("Request to change temperature to -> " + temp + " degrees celcius");
		 System.out.println("Temperature set!");
		 responseObserver.onNext(TemperatureResponse.newBuilder().setTemperature(temp).build());
		 
		 responseObserver.onCompleted();
	}
	
}