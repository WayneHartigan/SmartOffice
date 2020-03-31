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
	   
	    int port = 50051;
	    Server server = ServerBuilder.forPort(port)
	        .addService(thermostatserver)
	        .build()
	        .start();
	    
	    logger.info("Server started, listening on " + port);
	    		    
	    server.awaitTermination();
	}
	
	public void switchPower(PowerRequest request, StreamObserver<PowerResponse> responseObserver) {
        System.out.println("Receiving request...");

        System.out.println("Thermostat power");

        Boolean power = request.getSwitch(); 
        
        PowerResponse response = PowerResponse.newBuilder().setSwitch(power).build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();

	}
	@Override
	public StreamObserver<TemperatureRequest> changeTemperature(final StreamObserver<TemperatureResponse> responseObserver) {
		
		return new StreamObserver<TemperatureRequest>() {
			
			int temp = 0;
			
			@Override
			public void onNext(TemperatureRequest value) {
				
				System.out.println("receive -> " + value.getTemperature());
				temp = value.getTemperature();
				
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onCompleted() {
				TemperatureResponse response = TemperatureResponse.newBuilder().setTemperature(temp).build();
				responseObserver.onNext(response);
				responseObserver.onCompleted();
			}
			
			
		};
	}
}
