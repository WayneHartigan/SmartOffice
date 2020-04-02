package thermostat;

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
    comments = "Source: thermostat.proto")
public final class ThermostatServiceGrpc {

  private ThermostatServiceGrpc() {}

  public static final String SERVICE_NAME = "thermostat.ThermostatService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<thermostat.PowerRequest,
      thermostat.PowerResponse> getSwitchPowerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "switchPower",
      requestType = thermostat.PowerRequest.class,
      responseType = thermostat.PowerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<thermostat.PowerRequest,
      thermostat.PowerResponse> getSwitchPowerMethod() {
    io.grpc.MethodDescriptor<thermostat.PowerRequest, thermostat.PowerResponse> getSwitchPowerMethod;
    if ((getSwitchPowerMethod = ThermostatServiceGrpc.getSwitchPowerMethod) == null) {
      synchronized (ThermostatServiceGrpc.class) {
        if ((getSwitchPowerMethod = ThermostatServiceGrpc.getSwitchPowerMethod) == null) {
          ThermostatServiceGrpc.getSwitchPowerMethod = getSwitchPowerMethod = 
              io.grpc.MethodDescriptor.<thermostat.PowerRequest, thermostat.PowerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "thermostat.ThermostatService", "switchPower"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  thermostat.PowerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  thermostat.PowerResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ThermostatServiceMethodDescriptorSupplier("switchPower"))
                  .build();
          }
        }
     }
     return getSwitchPowerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<thermostat.TemperatureRequest,
      thermostat.TemperatureResponse> getChangeTemperatureMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "changeTemperature",
      requestType = thermostat.TemperatureRequest.class,
      responseType = thermostat.TemperatureResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<thermostat.TemperatureRequest,
      thermostat.TemperatureResponse> getChangeTemperatureMethod() {
    io.grpc.MethodDescriptor<thermostat.TemperatureRequest, thermostat.TemperatureResponse> getChangeTemperatureMethod;
    if ((getChangeTemperatureMethod = ThermostatServiceGrpc.getChangeTemperatureMethod) == null) {
      synchronized (ThermostatServiceGrpc.class) {
        if ((getChangeTemperatureMethod = ThermostatServiceGrpc.getChangeTemperatureMethod) == null) {
          ThermostatServiceGrpc.getChangeTemperatureMethod = getChangeTemperatureMethod = 
              io.grpc.MethodDescriptor.<thermostat.TemperatureRequest, thermostat.TemperatureResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "thermostat.ThermostatService", "changeTemperature"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  thermostat.TemperatureRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  thermostat.TemperatureResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ThermostatServiceMethodDescriptorSupplier("changeTemperature"))
                  .build();
          }
        }
     }
     return getChangeTemperatureMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ThermostatServiceStub newStub(io.grpc.Channel channel) {
    return new ThermostatServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ThermostatServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ThermostatServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ThermostatServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ThermostatServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class ThermostatServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void switchPower(thermostat.PowerRequest request,
        io.grpc.stub.StreamObserver<thermostat.PowerResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSwitchPowerMethod(), responseObserver);
    }

    /**
     */
    public void changeTemperature(thermostat.TemperatureRequest request,
        io.grpc.stub.StreamObserver<thermostat.TemperatureResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getChangeTemperatureMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSwitchPowerMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                thermostat.PowerRequest,
                thermostat.PowerResponse>(
                  this, METHODID_SWITCH_POWER)))
          .addMethod(
            getChangeTemperatureMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                thermostat.TemperatureRequest,
                thermostat.TemperatureResponse>(
                  this, METHODID_CHANGE_TEMPERATURE)))
          .build();
    }
  }

  /**
   */
  public static final class ThermostatServiceStub extends io.grpc.stub.AbstractStub<ThermostatServiceStub> {
    private ThermostatServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ThermostatServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ThermostatServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ThermostatServiceStub(channel, callOptions);
    }

    /**
     */
    public void switchPower(thermostat.PowerRequest request,
        io.grpc.stub.StreamObserver<thermostat.PowerResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSwitchPowerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void changeTemperature(thermostat.TemperatureRequest request,
        io.grpc.stub.StreamObserver<thermostat.TemperatureResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getChangeTemperatureMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ThermostatServiceBlockingStub extends io.grpc.stub.AbstractStub<ThermostatServiceBlockingStub> {
    private ThermostatServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ThermostatServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ThermostatServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ThermostatServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public thermostat.PowerResponse switchPower(thermostat.PowerRequest request) {
      return blockingUnaryCall(
          getChannel(), getSwitchPowerMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<thermostat.TemperatureResponse> changeTemperature(
        thermostat.TemperatureRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getChangeTemperatureMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ThermostatServiceFutureStub extends io.grpc.stub.AbstractStub<ThermostatServiceFutureStub> {
    private ThermostatServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ThermostatServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ThermostatServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ThermostatServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<thermostat.PowerResponse> switchPower(
        thermostat.PowerRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSwitchPowerMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SWITCH_POWER = 0;
  private static final int METHODID_CHANGE_TEMPERATURE = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ThermostatServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ThermostatServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SWITCH_POWER:
          serviceImpl.switchPower((thermostat.PowerRequest) request,
              (io.grpc.stub.StreamObserver<thermostat.PowerResponse>) responseObserver);
          break;
        case METHODID_CHANGE_TEMPERATURE:
          serviceImpl.changeTemperature((thermostat.TemperatureRequest) request,
              (io.grpc.stub.StreamObserver<thermostat.TemperatureResponse>) responseObserver);
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

  private static abstract class ThermostatServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ThermostatServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return thermostat.ThermostatServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ThermostatService");
    }
  }

  private static final class ThermostatServiceFileDescriptorSupplier
      extends ThermostatServiceBaseDescriptorSupplier {
    ThermostatServiceFileDescriptorSupplier() {}
  }

  private static final class ThermostatServiceMethodDescriptorSupplier
      extends ThermostatServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ThermostatServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ThermostatServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ThermostatServiceFileDescriptorSupplier())
              .addMethod(getSwitchPowerMethod())
              .addMethod(getChangeTemperatureMethod())
              .build();
        }
      }
    }
    return result;
  }
}
