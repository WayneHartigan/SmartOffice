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
		LightServer lightserver = new LightServer();
	   
	    int port = 50051;
	    Server server = ServerBuilder.forPort(port)
	        .addService(lightserver)
	        .build()
	        .start();
	    
	    logger.info("Server started, listening on " + port);
	    		    
	    server.awaitTermination();
	}
	
	public void switchPower(PowerRequest request, StreamObserver<PowerResponse> responseObserver) {
        System.out.println("Receiving request...");

        System.out.println("Light power");

        Boolean power = request.getSwitch(); 
        
        PowerResponse response = PowerResponse.newBuilder().setSwitch(power).build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();

	}
	@Override
	public StreamObserver<BrightnessRequest> changeBrightness(final StreamObserver<BrightnessResponse> responseObserver) {
		
		
		return new StreamObserver<BrightnessRequest>() {
			
			int brightness = 0;
			
			@Override
			public void onNext(BrightnessRequest value) {
				
				System.out.println("receive -> " + value.getBrightness());
				brightness = value.getBrightness();
				
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onCompleted() {
				BrightnessResponse response = BrightnessResponse.newBuilder().setBrightness(brightness).build();
				responseObserver.onNext(response);
				responseObserver.onCompleted();
			}
			
			
		};
	}	
}
