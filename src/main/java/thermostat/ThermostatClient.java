package thermostat;

import java.util.logging.Logger;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

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

	}
	
	public static void switchPower() {

		PowerRequest request = PowerRequest.newBuilder().setSwitch(false).build();

		PowerResponse response = blockingStub.switchPower(request);

        System.out.println(response.getSwitch());

    }
}
