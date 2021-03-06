package printer;

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
    comments = "Source: printer.proto")
public final class PrinterServiceGrpc {

  private PrinterServiceGrpc() {}

  public static final String SERVICE_NAME = "printer.PrinterService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<printer.PowerRequest,
      printer.PowerResponse> getSwitchPowerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "switchPower",
      requestType = printer.PowerRequest.class,
      responseType = printer.PowerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<printer.PowerRequest,
      printer.PowerResponse> getSwitchPowerMethod() {
    io.grpc.MethodDescriptor<printer.PowerRequest, printer.PowerResponse> getSwitchPowerMethod;
    if ((getSwitchPowerMethod = PrinterServiceGrpc.getSwitchPowerMethod) == null) {
      synchronized (PrinterServiceGrpc.class) {
        if ((getSwitchPowerMethod = PrinterServiceGrpc.getSwitchPowerMethod) == null) {
          PrinterServiceGrpc.getSwitchPowerMethod = getSwitchPowerMethod = 
              io.grpc.MethodDescriptor.<printer.PowerRequest, printer.PowerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "printer.PrinterService", "switchPower"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  printer.PowerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  printer.PowerResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new PrinterServiceMethodDescriptorSupplier("switchPower"))
                  .build();
          }
        }
     }
     return getSwitchPowerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<printer.PrintRequest,
      printer.PrintResponse> getPrintStatementMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "printStatement",
      requestType = printer.PrintRequest.class,
      responseType = printer.PrintResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<printer.PrintRequest,
      printer.PrintResponse> getPrintStatementMethod() {
    io.grpc.MethodDescriptor<printer.PrintRequest, printer.PrintResponse> getPrintStatementMethod;
    if ((getPrintStatementMethod = PrinterServiceGrpc.getPrintStatementMethod) == null) {
      synchronized (PrinterServiceGrpc.class) {
        if ((getPrintStatementMethod = PrinterServiceGrpc.getPrintStatementMethod) == null) {
          PrinterServiceGrpc.getPrintStatementMethod = getPrintStatementMethod = 
              io.grpc.MethodDescriptor.<printer.PrintRequest, printer.PrintResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "printer.PrinterService", "printStatement"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  printer.PrintRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  printer.PrintResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new PrinterServiceMethodDescriptorSupplier("printStatement"))
                  .build();
          }
        }
     }
     return getPrintStatementMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PrinterServiceStub newStub(io.grpc.Channel channel) {
    return new PrinterServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PrinterServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new PrinterServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PrinterServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new PrinterServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class PrinterServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void switchPower(printer.PowerRequest request,
        io.grpc.stub.StreamObserver<printer.PowerResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSwitchPowerMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<printer.PrintRequest> printStatement(
        io.grpc.stub.StreamObserver<printer.PrintResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getPrintStatementMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSwitchPowerMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                printer.PowerRequest,
                printer.PowerResponse>(
                  this, METHODID_SWITCH_POWER)))
          .addMethod(
            getPrintStatementMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                printer.PrintRequest,
                printer.PrintResponse>(
                  this, METHODID_PRINT_STATEMENT)))
          .build();
    }
  }

  /**
   */
  public static final class PrinterServiceStub extends io.grpc.stub.AbstractStub<PrinterServiceStub> {
    private PrinterServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PrinterServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PrinterServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PrinterServiceStub(channel, callOptions);
    }

    /**
     */
    public void switchPower(printer.PowerRequest request,
        io.grpc.stub.StreamObserver<printer.PowerResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSwitchPowerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<printer.PrintRequest> printStatement(
        io.grpc.stub.StreamObserver<printer.PrintResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getPrintStatementMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class PrinterServiceBlockingStub extends io.grpc.stub.AbstractStub<PrinterServiceBlockingStub> {
    private PrinterServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PrinterServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PrinterServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PrinterServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public printer.PowerResponse switchPower(printer.PowerRequest request) {
      return blockingUnaryCall(
          getChannel(), getSwitchPowerMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class PrinterServiceFutureStub extends io.grpc.stub.AbstractStub<PrinterServiceFutureStub> {
    private PrinterServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PrinterServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PrinterServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PrinterServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<printer.PowerResponse> switchPower(
        printer.PowerRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSwitchPowerMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SWITCH_POWER = 0;
  private static final int METHODID_PRINT_STATEMENT = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PrinterServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PrinterServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SWITCH_POWER:
          serviceImpl.switchPower((printer.PowerRequest) request,
              (io.grpc.stub.StreamObserver<printer.PowerResponse>) responseObserver);
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
        case METHODID_PRINT_STATEMENT:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.printStatement(
              (io.grpc.stub.StreamObserver<printer.PrintResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class PrinterServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PrinterServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return printer.PrinterServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PrinterService");
    }
  }

  private static final class PrinterServiceFileDescriptorSupplier
      extends PrinterServiceBaseDescriptorSupplier {
    PrinterServiceFileDescriptorSupplier() {}
  }

  private static final class PrinterServiceMethodDescriptorSupplier
      extends PrinterServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PrinterServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (PrinterServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PrinterServiceFileDescriptorSupplier())
              .addMethod(getSwitchPowerMethod())
              .addMethod(getPrintStatementMethod())
              .build();
        }
      }
    }
    return result;
  }
}
