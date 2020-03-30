package light;

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
    comments = "Source: light.proto")
public final class LightServiceGrpc {

  private LightServiceGrpc() {}

  public static final String SERVICE_NAME = "light.LightService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<light.PowerRequest,
      light.PowerResponse> getSwitchPowerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "switchPower",
      requestType = light.PowerRequest.class,
      responseType = light.PowerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<light.PowerRequest,
      light.PowerResponse> getSwitchPowerMethod() {
    io.grpc.MethodDescriptor<light.PowerRequest, light.PowerResponse> getSwitchPowerMethod;
    if ((getSwitchPowerMethod = LightServiceGrpc.getSwitchPowerMethod) == null) {
      synchronized (LightServiceGrpc.class) {
        if ((getSwitchPowerMethod = LightServiceGrpc.getSwitchPowerMethod) == null) {
          LightServiceGrpc.getSwitchPowerMethod = getSwitchPowerMethod = 
              io.grpc.MethodDescriptor.<light.PowerRequest, light.PowerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "light.LightService", "switchPower"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  light.PowerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  light.PowerResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LightServiceMethodDescriptorSupplier("switchPower"))
                  .build();
          }
        }
     }
     return getSwitchPowerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<light.BrightnessRequest,
      light.BrightnessResponse> getChangeBrightnessMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "changeBrightness",
      requestType = light.BrightnessRequest.class,
      responseType = light.BrightnessResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<light.BrightnessRequest,
      light.BrightnessResponse> getChangeBrightnessMethod() {
    io.grpc.MethodDescriptor<light.BrightnessRequest, light.BrightnessResponse> getChangeBrightnessMethod;
    if ((getChangeBrightnessMethod = LightServiceGrpc.getChangeBrightnessMethod) == null) {
      synchronized (LightServiceGrpc.class) {
        if ((getChangeBrightnessMethod = LightServiceGrpc.getChangeBrightnessMethod) == null) {
          LightServiceGrpc.getChangeBrightnessMethod = getChangeBrightnessMethod = 
              io.grpc.MethodDescriptor.<light.BrightnessRequest, light.BrightnessResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "light.LightService", "changeBrightness"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  light.BrightnessRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  light.BrightnessResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LightServiceMethodDescriptorSupplier("changeBrightness"))
                  .build();
          }
        }
     }
     return getChangeBrightnessMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static LightServiceStub newStub(io.grpc.Channel channel) {
    return new LightServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LightServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new LightServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static LightServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new LightServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class LightServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void switchPower(light.PowerRequest request,
        io.grpc.stub.StreamObserver<light.PowerResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSwitchPowerMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<light.BrightnessRequest> changeBrightness(
        io.grpc.stub.StreamObserver<light.BrightnessResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getChangeBrightnessMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSwitchPowerMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                light.PowerRequest,
                light.PowerResponse>(
                  this, METHODID_SWITCH_POWER)))
          .addMethod(
            getChangeBrightnessMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                light.BrightnessRequest,
                light.BrightnessResponse>(
                  this, METHODID_CHANGE_BRIGHTNESS)))
          .build();
    }
  }

  /**
   */
  public static final class LightServiceStub extends io.grpc.stub.AbstractStub<LightServiceStub> {
    private LightServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LightServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LightServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LightServiceStub(channel, callOptions);
    }

    /**
     */
    public void switchPower(light.PowerRequest request,
        io.grpc.stub.StreamObserver<light.PowerResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSwitchPowerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<light.BrightnessRequest> changeBrightness(
        io.grpc.stub.StreamObserver<light.BrightnessResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getChangeBrightnessMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class LightServiceBlockingStub extends io.grpc.stub.AbstractStub<LightServiceBlockingStub> {
    private LightServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LightServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LightServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LightServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public light.PowerResponse switchPower(light.PowerRequest request) {
      return blockingUnaryCall(
          getChannel(), getSwitchPowerMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class LightServiceFutureStub extends io.grpc.stub.AbstractStub<LightServiceFutureStub> {
    private LightServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LightServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LightServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LightServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<light.PowerResponse> switchPower(
        light.PowerRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSwitchPowerMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SWITCH_POWER = 0;
  private static final int METHODID_CHANGE_BRIGHTNESS = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final LightServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(LightServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SWITCH_POWER:
          serviceImpl.switchPower((light.PowerRequest) request,
              (io.grpc.stub.StreamObserver<light.PowerResponse>) responseObserver);
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
        case METHODID_CHANGE_BRIGHTNESS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.changeBrightness(
              (io.grpc.stub.StreamObserver<light.BrightnessResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class LightServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LightServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return light.LightServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("LightService");
    }
  }

  private static final class LightServiceFileDescriptorSupplier
      extends LightServiceBaseDescriptorSupplier {
    LightServiceFileDescriptorSupplier() {}
  }

  private static final class LightServiceMethodDescriptorSupplier
      extends LightServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    LightServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (LightServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new LightServiceFileDescriptorSupplier())
              .addMethod(getSwitchPowerMethod())
              .addMethod(getChangeBrightnessMethod())
              .build();
        }
      }
    }
    return result;
  }
}
