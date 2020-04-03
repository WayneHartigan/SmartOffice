package printer;

import java.util.Random;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import printer.PrinterClient;

public class PrinterClient {
	
	
	private static PrinterServiceGrpc.PrinterServiceBlockingStub blockingStub;
	private static PrinterServiceGrpc.PrinterServiceStub asyncStub;
	
	public static void main(String[] args) throws Exception {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50053).usePlaintext().build();

		blockingStub = PrinterServiceGrpc.newBlockingStub(channel);
		asyncStub = PrinterServiceGrpc.newStub(channel);

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
				System.out.println("receiving statement to print -> " + value.getStatement());
			}

			@Override
			public void onError(Throwable t) {

			}

			@Override
			public void onCompleted() {

			}

		};

		StreamObserver<PrintRequest> requestObserver = asyncStub.printStatement(responseObserver);
		try {

			requestObserver.onNext(PrintRequest.newBuilder().setStatement("Hello").build());
			requestObserver.onNext(PrintRequest.newBuilder().setStatement("Please").build());
			requestObserver.onNext(PrintRequest.newBuilder().setStatement("Print").build());
			requestObserver.onNext(PrintRequest.newBuilder().setStatement("This").build());
			requestObserver.onNext(PrintRequest.newBuilder().setStatement("Out").build());
			
			Thread.sleep(new Random().nextInt(1000) + 500);

		} catch (RuntimeException e) {
            requestObserver.onError(e);
            throw e;
            } catch (InterruptedException e) {

                e.printStackTrace();
        }

		requestObserver.onCompleted();
	}
}
