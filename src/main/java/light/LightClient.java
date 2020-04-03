package light;

import java.util.Random;
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
		
		if (response.getSwitch()) {
			System.out.println("Light power has been turned on!");
		}
		else {
			System.out.println("Light power has been turned off!");
		}

    }
	public static void changeBrightness(){

		StreamObserver<BrightnessResponse> responseObserver = new StreamObserver<BrightnessResponse>() {

			public void onNext(BrightnessResponse value) {
				int brightness = value.getBrightness();
				
				System.out.println("Brightness has been set to level " + brightness);
			}

			public void onError(Throwable t) {
				t.printStackTrace();

			}

			public void onCompleted() {
				System.out.println("Complete");

			}
		};

		StreamObserver<BrightnessRequest> requestObserver = asyncStub.changeBrightness(responseObserver);
		try {

			requestObserver.onNext(BrightnessRequest.newBuilder().setBrightness(1).build());
			requestObserver.onNext(BrightnessRequest.newBuilder().setBrightness(2).build());
			requestObserver.onNext(BrightnessRequest.newBuilder().setBrightness(3).build());
			requestObserver.onNext(BrightnessRequest.newBuilder().setBrightness(4).build());
			requestObserver.onNext(BrightnessRequest.newBuilder().setBrightness(5).build());
			
			Thread.sleep(new Random().nextInt(1000) + 500);

		} catch (RuntimeException e) {
			System.out.println("Error");
			requestObserver.onError(e);
            throw e;
		} catch (InterruptedException e) {
            e.printStackTrace();
		}
		requestObserver.onCompleted();
	}
}
