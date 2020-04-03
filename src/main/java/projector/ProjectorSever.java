package projector;

import java.io.IOException;
import java.util.logging.Logger;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import projector.ProjectorServiceGrpc.ProjectorServiceImplBase;

public class ProjectorSever extends ProjectorServiceImplBase{
	
	private static final Logger logger = Logger.getLogger(ProjectorSever.class.getName());
	
	public static void main(String[] args) throws IOException, InterruptedException{
		ProjectorSever projectorserver = new ProjectorSever();
		
		int port = 50051;
		Server server = ServerBuilder.forPort(port)
				.addService(projectorserver)
				.build()
				.start();
		
		logger.info("Server started, listening on " + port);
		
		server.awaitTermination();
		}
	
	public void switchPower(PowerRequest request, StreamObserver<PowerResponse> responseObserver) {
        System.out.println("Receiving request...");

        System.out.println("Projector power");

        Boolean power = request.getSwitch(); 
        
        PowerResponse response = PowerResponse.newBuilder().setSwitch(power).build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();

	}
	
	public void changeInput(InputRequest request, StreamObserver<InputResponse> responseObserver) {
        System.out.println("Receiving request...");

        System.out.println("Projector power");

        String input = request.getInput(); 
        
        InputResponse response = InputResponse.newBuilder().setInput("Now printing message -> " + input).build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();

	}

}
