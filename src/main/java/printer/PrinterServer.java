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
	   
		int port = 50053;
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
	
	public StreamObserver<PrintRequest> printStatement(final StreamObserver<PrintResponse> responseObserver) {
      return new StreamObserver<PrintRequest>() {
        public void onNext(PrintRequest request) {
            StringBuilder statement = new StringBuilder(); 
  
            statement.append(request.getStatement());
            System.out.println(statement);
        
            PrintResponse reply = PrintResponse.newBuilder().setStatement(statement.toString()).build();
      
            responseObserver.onNext(reply);
          }

        public void onError(Throwable t) {
          System.out.println("Error, service stopped");
        }
        public void onCompleted() {
          responseObserver.onCompleted();
        }
      };
    }
}
