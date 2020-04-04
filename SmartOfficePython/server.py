import grpc
from concurrent import futures
import time

import projector_pb2
import projector_pb2_grpc

class ProjectorServicer(projector_pb2_grpc.ProjectorServicer):

    def ChangeInput(self, request, context):
		print("Request to change input to " + request.input)
		response = projector_pb2.Input()
		response.input = ("Input has been changed to " + request.input)
		return response

server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))

projector_pb2_grpc.add_ProjectorServicer_to_server(
        ProjectorServicer(), server)

print('Starting server. Listening on port 50054.')
server.add_insecure_port('[::]:50054')
server.start()

try:
    while True:
        time.sleep(86400)
except KeyboardInterrupt:
    server.stop(0)
