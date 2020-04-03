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
		changeInput();

	}
	
	public static void switchPower() {

		PowerRequest request = PowerRequest.newBuilder().setSwitch(false).build();

		PowerResponse response = blockingStub.switchPower(request);
		
		if (response.getSwitch()) {
			System.out.println("Projector power has been turned on!");
		}
		else {
			System.out.println("Projector power has been turned off!");
		}

    }
	
	public static void changeInput() {
		InputRequest request = InputRequest.newBuilder().setInput("HDMI").build();
		InputResponse response = blockingStub.changeInput(request);
		
		System.out.println("Input changed to " + response.getInput());
	}

}
