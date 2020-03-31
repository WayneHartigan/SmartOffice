package thermostat;

import java.util.logging.Logger;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import light.BrightnessRequest;
import light.BrightnessResponse;

public class ThermostatClient {
	private static  Logger logger = Logger.getLogger(ThermostatClient.class.getName());

	private static ThermostatServiceGrpc.ThermostatServiceBlockingStub blockingStub;
	private static ThermostatServiceGrpc.ThermostatServiceStub asyncStub;
	private static ThermostatServiceGrpc.ThermostatServiceFutureStub futureStub;

	public static void main(String[] args) throws Exception {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();

		blockingStub = ThermostatServiceGrpc.newBlockingStub(channel);
		asyncStub = ThermostatServiceGrpc.newStub(channel);
		futureStub =  ThermostatServiceGrpc.newFutureStub(channel);

		switchPower();
		changeTemperature();

	}
	
	public static void switchPower() {

		PowerRequest request = PowerRequest.newBuilder().setSwitch(false).build();

		PowerResponse response = blockingStub.switchPower(request);

        System.out.println(response.getSwitch());

    }
	
	public static void changeTemperature(){

		StreamObserver<TemperatureResponse> responseObserver = new StreamObserver<TemperatureResponse>() {

			@Override
			public void onNext(TemperatureResponse value) {
				System.out.println("receiving brightness: " + value.getTemperature());
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

		StreamObserver<TemperatureRequest> requestObserver = asyncStub.changeTemperature(responseObserver);
		try {

			requestObserver.onNext(TemperatureRequest.newBuilder().setTemperature(5).build());
			requestObserver.onNext(TemperatureRequest.newBuilder().setTemperature(10).build());
			requestObserver.onNext(TemperatureRequest.newBuilder().setTemperature(15).build());
			requestObserver.onNext(TemperatureRequest.newBuilder().setTemperature(20).build());
			requestObserver.onNext(TemperatureRequest.newBuilder().setTemperature(25).build());


		} catch (RuntimeException e) {
			System.out.println("Error");
		}

		// Mark the end of requests
		requestObserver.onCompleted();
	}
}
