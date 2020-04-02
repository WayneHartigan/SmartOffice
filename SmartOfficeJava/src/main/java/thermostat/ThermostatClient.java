package thermostat;

import java.util.logging.Logger;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

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

		if (response.getSwitch()) {
			System.out.println("Central heating has been turned on!");
		}
		else {
			System.out.println("Central heating has been turned off!");
		}

    }
	
	public static void changeTemperature() {
		TemperatureRequest request = TemperatureRequest.newBuilder().setTemperature(15).build();

		StreamObserver<TemperatureResponse> responseObserver = new StreamObserver<TemperatureResponse>() {

			@Override
			public void onNext(TemperatureResponse value) {
				System.out.println("receiving " + value);

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}