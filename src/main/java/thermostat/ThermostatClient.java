package thermostat;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class ThermostatClient {

	private static ThermostatServiceGrpc.ThermostatServiceBlockingStub blockingStub;
	private static ThermostatServiceGrpc.ThermostatServiceStub asyncStub;

	public static void main(String[] args) throws Exception {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();

		blockingStub = ThermostatServiceGrpc.newBlockingStub(channel);
		asyncStub = ThermostatServiceGrpc.newStub(channel);

		switchPower();
		changeTemperature();

	}
	
	public static void switchPower() {

		PowerRequest request = PowerRequest.newBuilder().setSwitch(false).build();

		PowerResponse response = blockingStub.switchPower(request);

		if (response.getSwitch()) {
			System.out.println("Thermostat power has been turned on!");
		}
		else {
			System.out.println("Thermostat power has been turned off!");
		}

    }
	
	public static void changeTemperature() {
		TemperatureRequest request = TemperatureRequest.newBuilder().setTemperature(15).build();
		System.out.println("Requesting to set temperature to -> " + request + " degrees celcius");

		StreamObserver<TemperatureResponse> responseObserver = new StreamObserver<TemperatureResponse>() {

			@Override
			public void onNext(TemperatureResponse value) {
				System.out.println("Temperature has been changed to -> " + value + " degrees celcius");

			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();

			}

			@Override
			public void onCompleted() {
				System.out.println("on completed ");
			}

		};

		asyncStub.changeTemperature(request, responseObserver);


		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}