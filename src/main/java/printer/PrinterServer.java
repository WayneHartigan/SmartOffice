package printer;

import java.io.IOException;
import java.util.logging.Logger;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import printer.PowerRequest;
import printer.PowerResponse;
import printer.PrinterServiceGrpc.PrinterServiceImplBase;

public class PrinterServer extends PrinterServiceImplBase{
	
	private static final Logger logger = Logger.getLogger(PrinterServer.class.getName());
	
	public static void main(String[] args) throws IOException, InterruptedException {
		PrinterServer printerserver = new PrinterServer();
	   
		int port = 50051;
	    Server server = ServerBuilder.forPort(port)
	        .addService(printerserver)
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

}
