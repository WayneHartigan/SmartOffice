import grpc

import projector_pb2
import projector_pb2_grpc

channel = grpc.insecure_channel('localhost:50054')

stub = projector_pb2_grpc.ProjectorStub(channel)

input = projector_pb2.Input(input="HDMI")

response = stub.ChangeInput(input)


print(response.input)
