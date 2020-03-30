package light;

import java.util.logging.Logger;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class LightClient {
	private static  Logger logger = Logger.getLogger(LightClient.class.getName());

	private static LightServiceGrpc.LightServiceBlockingStub blockingStub;
	private static LightServiceGrpc.LightServiceStub asyncStub;
	private static LightServiceGrpc.LightServiceFutureStub futureStub;

	public static void main(String[] args) throws Exception {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();

		blockingStub = LightServiceGrpc.newBlockingStub(channel);
		asyncStub = LightServiceGrpc.newStub(channel);
		futureStub =  LightServiceGrpc.newFutureStub(channel);

		switchPower();
		changeBrightness();

	}
	
	public static void switchPower() {

		PowerRequest request = PowerRequest.newBuilder().setSwitch(false).build();

		PowerResponse response = blockingStub.switchPower(request);

        System.out.println(response.getSwitch());

    }
	public static void changeBrightness(){

		StreamObserver<BrightnessResponse> responseObserver = new StreamObserver<BrightnessResponse>() {

			@Override
			public void onNext(BrightnessResponse value) {
				System.out.println("receiving brightness: " + value.getBrightness());


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

		StreamObserver<BrightnessRequest> requestObserver = asyncStub.changeBrightness(responseObserver);
		try {

			requestObserver.onNext(BrightnessRequest.newBuilder().setBrightness(1).build());
			requestObserver.onNext(BrightnessRequest.newBuilder().setBrightness(2).build());
			requestObserver.onNext(BrightnessRequest.newBuilder().setBrightness(3).build());
			requestObserver.onNext(BrightnessRequest.newBuilder().setBrightness(4).build());
			requestObserver.onNext(BrightnessRequest.newBuilder().setBrightness(5).build());


		} catch (RuntimeException e) {
			System.out.println("Error");
		}

		// Mark the end of requests
		requestObserver.onCompleted();
	}
}
