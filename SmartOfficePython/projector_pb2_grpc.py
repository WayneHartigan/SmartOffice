# Generated by the gRPC Python protocol compiler plugin. DO NOT EDIT!
import grpc

import projector_pb2 as projector__pb2


class ProjectorStub(object):
  # missing associated documentation comment in .proto file
  pass

  def __init__(self, channel):
    """Constructor.

    Args:
      channel: A grpc.Channel.
    """
    self.ChangeInput = channel.unary_unary(
        '/Projector/ChangeInput',
        request_serializer=projector__pb2.Input.SerializeToString,
        response_deserializer=projector__pb2.Input.FromString,
        )


class ProjectorServicer(object):
  # missing associated documentation comment in .proto file
  pass

  def ChangeInput(self, request, context):
    # missing associated documentation comment in .proto file
    pass
    context.set_code(grpc.StatusCode.UNIMPLEMENTED)
    context.set_details('Method not implemented!')
    raise NotImplementedError('Method not implemented!')


def add_ProjectorServicer_to_server(servicer, server):
  rpc_method_handlers = {
      'ChangeInput': grpc.unary_unary_rpc_method_handler(
          servicer.ChangeInput,
          request_deserializer=projector__pb2.Input.FromString,
          response_serializer=projector__pb2.Input.SerializeToString,
      ),
  }
  generic_handler = grpc.method_handlers_generic_handler(
      'Projector', rpc_method_handlers)
  server.add_generic_rpc_handlers((generic_handler,))
