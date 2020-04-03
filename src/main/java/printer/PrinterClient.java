package printer;

import java.util.logging.Logger;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import light.BrightnessRequest;
import light.BrightnessResponse;
import printer.PrinterClient;

public class PrinterClient {
	
	private static  Logger logger = Logger.getLogger(PrinterClient.class.getName());
	
	private static PrinterServiceGrpc.PrinterServiceBlockingStub blockingStub;
	private static PrinterServiceGrpc.PrinterServiceStub asyncStub;
	private static PrinterServiceGrpc.PrinterServiceFutureStub futureStub;
	
	public static void main(String[] args) throws Exception {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();

		blockingStub = PrinterServiceGrpc.newBlockingStub(channel);
		asyncStub = PrinterServiceGrpc.newStub(channel);
		futureStub =  PrinterServiceGrpc.newFutureStub(channel);

		switchPower();
		printStatement();

	}
	
	public static void switchPower() {

		PowerRequest request = PowerRequest.newBuilder().setSwitch(false).build();

		PowerResponse response = blockingStub.switchPower(request);

        System.out.println(response.getSwitch());

    }
	
	public static void printStatement(){

		StreamObserver<PrintResponse> responseObserver = new StreamObserver<PrintResponse>() {

			@Override
			public void onNext(PrintResponse value) {
				System.out.println("receiving brightness: " + value.getStatement());
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onCompleted() {
				// TODO Auto-generated method stub

			}

		};

		StreamObserver<PrintRequest> requestObserver = asyncStub.printStatement(responseObserver);
		try {

			requestObserver.onNext(PrintRequest.newBuilder().setStatement("Hello").build());
			requestObserver.onNext(PrintRequest.newBuilder().setStatement("Please").build());
			requestObserver.onNext(PrintRequest.newBuilder().setStatement("Print").build());
			requestObserver.onNext(PrintRequest.newBuilder().setStatement("This").build());
			requestObserver.onNext(PrintRequest.newBuilder().setStatement("Out").build());


		} catch (RuntimeException e) {
			System.out.println("Error");
		}

		// Mark the end of requests
		requestObserver.onCompleted();
	}

}
