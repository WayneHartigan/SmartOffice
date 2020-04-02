import grpc
from concurrent import futures
import projector_pb2
import projector_pb2_grpc

class ProjectorService(projector_pb2_grpc.ProjectorService):

	def switchPower(self, request, context):
		response = projector_pb2.PowerRequest()
		response.value = response
		return response


server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))

projector_pb2_grpc.add_ProjectService_to_server(ProjectorService(), server)

server.add_insecure_port('[::]:50051')
server.start()

try:
    while True:
        time.sleep(86400)
except KeyboardInterrupt:
    server.stop(0)
