package printer;

import java.util.logging.Logger;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
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

	}
	
	public static void switchPower() {

		PowerRequest request = PowerRequest.newBuilder().setSwitch(false).build();

		PowerResponse response = blockingStub.switchPower(request);

        System.out.println(response.getSwitch());

    }

}
