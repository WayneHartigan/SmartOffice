package light;
import java.io.IOException;
import java.util.logging.Logger;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import light.PowerRequest;
import light.PowerResponse;
import light.LightServiceGrpc.LightServiceImplBase;
import io.grpc.stub.StreamObserver;

public class LightServer extends LightServiceImplBase{
	
	private static final Logger logger = Logger.getLogger(LightServer.class.getName());
	
	public static void main(String[] args) throws IOException, InterruptedException {
		// Create a server with the port of 50055
		LightServer lightserver = new LightServer();
	   
	    int port = 50055;
	    Server server = ServerBuilder.forPort(port)
	        .addService(lightserver)
	        .build()
	        .start();
	    
	    logger.info("Server started, listening on " + port);
	    		    
	    server.awaitTermination();
	}
	
	public void switchPower(PowerRequest request, StreamObserver<PowerResponse> responseObserver) {
		// Print a message stating the function has been invoked
        System.out.println("Receiving request for power!");
        // Get the switch variable
        Boolean power = request.getSwitch();
        if (power) {
        	System.out.println("Setting power to on!");
        }
        else {
        	System.out.println("Setting power to off!");
        }
        
        // Send a response with power value back
        PowerResponse response = PowerResponse.newBuilder().setSwitch(power).build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();

	}
	public StreamObserver<BrightnessRequest> changeBrightness(final StreamObserver<BrightnessResponse> responseObserver) {
		
		return new StreamObserver<BrightnessRequest>() {
			// Setting a variable to be used
			int brightness = 0;
			
			public void onNext(BrightnessRequest value) {
				// Print the request when receieved
				brightness = value.getBrightness();
				System.out.println("Request to turn brightness to -> " + brightness);
				
			}
			
			public void onError(Throwable t) {
				t.printStackTrace();
			}

			public void onCompleted() {
				// Send the response
				BrightnessResponse response = BrightnessResponse.newBuilder().setBrightness(brightness).build();
				responseObserver.onNext(response);
				responseObserver.onCompleted();
			}
		};
	}
}
