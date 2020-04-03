package projector;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: projector.proto")
public final class ProjectorServiceGrpc {

  private ProjectorServiceGrpc() {}

  public static final String SERVICE_NAME = "projector.ProjectorService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<projector.PowerRequest,
      projector.PowerResponse> getSwitchPowerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "switchPower",
      requestType = projector.PowerRequest.class,
      responseType = projector.PowerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<projector.PowerRequest,
      projector.PowerResponse> getSwitchPowerMethod() {
    io.grpc.MethodDescriptor<projector.PowerRequest, projector.PowerResponse> getSwitchPowerMethod;
    if ((getSwitchPowerMethod = ProjectorServiceGrpc.getSwitchPowerMethod) == null) {
      synchronized (ProjectorServiceGrpc.class) {
        if ((getSwitchPowerMethod = ProjectorServiceGrpc.getSwitchPowerMethod) == null) {
          ProjectorServiceGrpc.getSwitchPowerMethod = getSwitchPowerMethod = 
              io.grpc.MethodDescriptor.<projector.PowerRequest, projector.PowerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "projector.ProjectorService", "switchPower"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  projector.PowerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  projector.PowerResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ProjectorServiceMethodDescriptorSupplier("switchPower"))
                  .build();
          }
        }
     }
     return getSwitchPowerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<projector.InputRequest,
      projector.InputResponse> getChangeInputMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "changeInput",
      requestType = projector.InputRequest.class,
      responseType = projector.InputResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<projector.InputRequest,
      projector.InputResponse> getChangeInputMethod() {
    io.grpc.MethodDescriptor<projector.InputRequest, projector.InputResponse> getChangeInputMethod;
    if ((getChangeInputMethod = ProjectorServiceGrpc.getChangeInputMethod) == null) {
      synchronized (ProjectorServiceGrpc.class) {
        if ((getChangeInputMethod = ProjectorServiceGrpc.getChangeInputMethod) == null) {
          ProjectorServiceGrpc.getChangeInputMethod = getChangeInputMethod = 
              io.grpc.MethodDescriptor.<projector.InputRequest, projector.InputResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "projector.ProjectorService", "changeInput"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  projector.InputRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  projector.InputResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ProjectorServiceMethodDescriptorSupplier("changeInput"))
                  .build();
          }
        }
     }
     return getChangeInputMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ProjectorServiceStub newStub(io.grpc.Channel channel) {
    return new ProjectorServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ProjectorServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ProjectorServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ProjectorServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ProjectorServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class ProjectorServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void switchPower(projector.PowerRequest request,
        io.grpc.stub.StreamObserver<projector.PowerResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSwitchPowerMethod(), responseObserver);
    }

    /**
     */
    public void changeInput(projector.InputRequest request,
        io.grpc.stub.StreamObserver<projector.InputResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getChangeInputMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSwitchPowerMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                projector.PowerRequest,
                projector.PowerResponse>(
                  this, METHODID_SWITCH_POWER)))
          .addMethod(
            getChangeInputMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                projector.InputRequest,
                projector.InputResponse>(
                  this, METHODID_CHANGE_INPUT)))
          .build();
    }
  }

  /**
   */
  public static final class ProjectorServiceStub extends io.grpc.stub.AbstractStub<ProjectorServiceStub> {
    private ProjectorServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ProjectorServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProjectorServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ProjectorServiceStub(channel, callOptions);
    }

    /**
     */
    public void switchPower(projector.PowerRequest request,
        io.grpc.stub.StreamObserver<projector.PowerResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSwitchPowerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void changeInput(projector.InputRequest request,
        io.grpc.stub.StreamObserver<projector.InputResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getChangeInputMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ProjectorServiceBlockingStub extends io.grpc.stub.AbstractStub<ProjectorServiceBlockingStub> {
    private ProjectorServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ProjectorServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProjectorServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ProjectorServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public projector.PowerResponse switchPower(projector.PowerRequest request) {
      return blockingUnaryCall(
          getChannel(), getSwitchPowerMethod(), getCallOptions(), request);
    }

    /**
     */
    public projector.InputResponse changeInput(projector.InputRequest request) {
      return blockingUnaryCall(
          getChannel(), getChangeInputMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ProjectorServiceFutureStub extends io.grpc.stub.AbstractStub<ProjectorServiceFutureStub> {
    private ProjectorServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ProjectorServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProjectorServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ProjectorServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<projector.PowerResponse> switchPower(
        projector.PowerRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSwitchPowerMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<projector.InputResponse> changeInput(
        projector.InputRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getChangeInputMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SWITCH_POWER = 0;
  private static final int METHODID_CHANGE_INPUT = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ProjectorServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ProjectorServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SWITCH_POWER:
          serviceImpl.switchPower((projector.PowerRequest) request,
              (io.grpc.stub.StreamObserver<projector.PowerResponse>) responseObserver);
          break;
        case METHODID_CHANGE_INPUT:
          serviceImpl.changeInput((projector.InputRequest) request,
              (io.grpc.stub.StreamObserver<projector.InputResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ProjectorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ProjectorServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return projector.ProjectorServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ProjectorService");
    }
  }

  private static final class ProjectorServiceFileDescriptorSupplier
      extends ProjectorServiceBaseDescriptorSupplier {
    ProjectorServiceFileDescriptorSupplier() {}
  }

  private static final class ProjectorServiceMethodDescriptorSupplier
      extends ProjectorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ProjectorServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ProjectorServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ProjectorServiceFileDescriptorSupplier())
              .addMethod(getSwitchPowerMethod())
              .addMethod(getChangeInputMethod())
              .build();
        }
      }
    }
    return result;
  }
}
