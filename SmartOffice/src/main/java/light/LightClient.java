package light;

import java.util.Random;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class LightClient {

	private static LightServiceGrpc.LightServiceBlockingStub blockingStub;
	private static LightServiceGrpc.LightServiceStub asyncStub;

	public static void main(String[] args) throws Exception {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50055).usePlaintext().build();

		blockingStub = LightServiceGrpc.newBlockingStub(channel);
		asyncStub = LightServiceGrpc.newStub(channel);

		switchPower();
		changeBrightness();

	}
	
	public static void switchPower() {
		// send the request
		PowerRequest request = PowerRequest.newBuilder().setSwitch(false).build();
		
		// check the response
		PowerResponse response = blockingStub.switchPower(request);
		
		// print appropriate message depending on response
		if (response.getSwitch()) {
			System.out.println("Light power has been turned on!");
		}
		else {
			System.out.println("Light power has been turned off!");
		}

    }
	public static void changeBrightness(){

		StreamObserver<BrightnessResponse> responseObserver = new StreamObserver<BrightnessResponse>() {

			@Override
			public void onNext(BrightnessResponse value) {
				// Print out response
				System.out.println("Brightness has been set to level " + value.getBrightness());
			}

			@Override
			public void onError(Throwable t) {

			}

			@Override
			public void onCompleted() {

			}
		};

		StreamObserver<BrightnessRequest> requestObserver = asyncStub.changeBrightness(responseObserver);
		try {
			// send a stream of requests
			requestObserver.onNext(BrightnessRequest.newBuilder().setBrightness(1).build());
			System.out.println("Sent");
			requestObserver.onNext(BrightnessRequest.newBuilder().setBrightness(2).build());
			System.out.println("Sent");
			requestObserver.onNext(BrightnessRequest.newBuilder().setBrightness(3).build());
			System.out.println("Sent");
			requestObserver.onNext(BrightnessRequest.newBuilder().setBrightness(4).build());
			System.out.println("Sent");
			requestObserver.onNext(BrightnessRequest.newBuilder().setBrightness(5).build());
			System.out.println("Sent");
			
			Thread.sleep(new Random().nextInt(1000) + 500);
			// catch any errors
		} catch (RuntimeException e) {
            requestObserver.onError(e);
            throw e;
            } catch (InterruptedException e) {

                e.printStackTrace();
        }
		requestObserver.onCompleted();
	}
}
