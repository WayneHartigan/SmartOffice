package projector;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class ProjectorClient {
	
	private static ProjectorServiceGrpc.ProjectorServiceBlockingStub blockingStub;
	private static ProjectorServiceGrpc.ProjectorServiceStub asyncStub;

	public static void main(String[] args) throws Exception {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();

		blockingStub = ProjectorServiceGrpc.newBlockingStub(channel);
		asyncStub = ProjectorServiceGrpc.newStub(channel);

		switchPower();

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

}
