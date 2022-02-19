package service.service_json

object JsonServiceGrpc {
  val METHOD_UNARY: _root_.io.grpc.MethodDescriptor[service.service_json.JsonReq1, service.service_json.JsonResp1] =
    _root_.io.grpc.MethodDescriptor.newBuilder()
      .setType(_root_.io.grpc.MethodDescriptor.MethodType.UNARY)
      .setFullMethodName(_root_.io.grpc.MethodDescriptor.generateFullMethodName("service.JsonService", "unary"))
      .setSampledToLocalTracing(true)
      .setRequestMarshaller(_root_.scalapb.grpc.Marshaller.forMessage[service.service_json.JsonReq1])
      .setResponseMarshaller(_root_.scalapb.grpc.Marshaller.forMessage[service.service_json.JsonResp1])
      .setSchemaDescriptor(_root_.scalapb.grpc.ConcreteProtoMethodDescriptorSupplier.fromMethodDescriptor(service.service_json.ServiceJsonProto.javaDescriptor.getServices().get(0).getMethods().get(0)))
      .build()
  
  val METHOD_SERVER_STREAMING: _root_.io.grpc.MethodDescriptor[service.service_json.JsonReq2, service.service_json.JsonResp2] =
    _root_.io.grpc.MethodDescriptor.newBuilder()
      .setType(_root_.io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
      .setFullMethodName(_root_.io.grpc.MethodDescriptor.generateFullMethodName("service.JsonService", "serverStreaming"))
      .setSampledToLocalTracing(true)
      .setRequestMarshaller(_root_.scalapb.grpc.Marshaller.forMessage[service.service_json.JsonReq2])
      .setResponseMarshaller(_root_.scalapb.grpc.Marshaller.forMessage[service.service_json.JsonResp2])
      .setSchemaDescriptor(_root_.scalapb.grpc.ConcreteProtoMethodDescriptorSupplier.fromMethodDescriptor(service.service_json.ServiceJsonProto.javaDescriptor.getServices().get(0).getMethods().get(1)))
      .build()
  
  val SERVICE: _root_.io.grpc.ServiceDescriptor =
    _root_.io.grpc.ServiceDescriptor.newBuilder("service.JsonService")
      .setSchemaDescriptor(new _root_.scalapb.grpc.ConcreteProtoFileDescriptorSupplier(service.service_json.ServiceJsonProto.javaDescriptor))
      .addMethod(METHOD_UNARY)
      .addMethod(METHOD_SERVER_STREAMING)
      .build()
  
  trait JsonService extends _root_.scalapb.grpc.AbstractService {
    override def serviceCompanion = JsonService
    def unary(request: service.service_json.JsonReq1): scala.concurrent.Future[service.service_json.JsonResp1]
    def serverStreaming(request: service.service_json.JsonReq2, responseObserver: _root_.io.grpc.stub.StreamObserver[service.service_json.JsonResp2]): _root_.scala.Unit
  }
  
  object JsonService extends _root_.scalapb.grpc.ServiceCompanion[JsonService] {
    implicit def serviceCompanion: _root_.scalapb.grpc.ServiceCompanion[JsonService] = this
    def javaDescriptor: _root_.com.google.protobuf.Descriptors.ServiceDescriptor = service.service_json.ServiceJsonProto.javaDescriptor.getServices().get(0)
    def scalaDescriptor: _root_.scalapb.descriptors.ServiceDescriptor = service.service_json.ServiceJsonProto.scalaDescriptor.services(0)
    def bindService(serviceImpl: JsonService, executionContext: scala.concurrent.ExecutionContext): _root_.io.grpc.ServerServiceDefinition =
      _root_.io.grpc.ServerServiceDefinition.builder(SERVICE)
      .addMethod(
        METHOD_UNARY,
        _root_.io.grpc.stub.ServerCalls.asyncUnaryCall(new _root_.io.grpc.stub.ServerCalls.UnaryMethod[service.service_json.JsonReq1, service.service_json.JsonResp1] {
          override def invoke(request: service.service_json.JsonReq1, observer: _root_.io.grpc.stub.StreamObserver[service.service_json.JsonResp1]): _root_.scala.Unit =
            serviceImpl.unary(request).onComplete(scalapb.grpc.Grpc.completeObserver(observer))(
              executionContext)
        }))
      .addMethod(
        METHOD_SERVER_STREAMING,
        _root_.io.grpc.stub.ServerCalls.asyncServerStreamingCall(new _root_.io.grpc.stub.ServerCalls.ServerStreamingMethod[service.service_json.JsonReq2, service.service_json.JsonResp2] {
          override def invoke(request: service.service_json.JsonReq2, observer: _root_.io.grpc.stub.StreamObserver[service.service_json.JsonResp2]): _root_.scala.Unit =
            serviceImpl.serverStreaming(request, observer)
        }))
      .build()
  }
  
  trait JsonServiceBlockingClient {
    def serviceCompanion = JsonService
    def unary(request: service.service_json.JsonReq1): service.service_json.JsonResp1
    def serverStreaming(request: service.service_json.JsonReq2): scala.collection.Iterator[service.service_json.JsonResp2]
  }
  
  class JsonServiceBlockingStub(channel: _root_.io.grpc.Channel, options: _root_.io.grpc.CallOptions = _root_.io.grpc.CallOptions.DEFAULT) extends _root_.io.grpc.stub.AbstractStub[JsonServiceBlockingStub](channel, options) with JsonServiceBlockingClient {
    override def unary(request: service.service_json.JsonReq1): service.service_json.JsonResp1 = {
      _root_.scalapb.grpc.ClientCalls.blockingUnaryCall(channel, METHOD_UNARY, options, request)
    }
    
    override def serverStreaming(request: service.service_json.JsonReq2): scala.collection.Iterator[service.service_json.JsonResp2] = {
      _root_.scalapb.grpc.ClientCalls.blockingServerStreamingCall(channel, METHOD_SERVER_STREAMING, options, request)
    }
    
    override def build(channel: _root_.io.grpc.Channel, options: _root_.io.grpc.CallOptions): JsonServiceBlockingStub = new JsonServiceBlockingStub(channel, options)
  }
  
  class JsonServiceStub(channel: _root_.io.grpc.Channel, options: _root_.io.grpc.CallOptions = _root_.io.grpc.CallOptions.DEFAULT) extends _root_.io.grpc.stub.AbstractStub[JsonServiceStub](channel, options) with JsonService {
    override def unary(request: service.service_json.JsonReq1): scala.concurrent.Future[service.service_json.JsonResp1] = {
      _root_.scalapb.grpc.ClientCalls.asyncUnaryCall(channel, METHOD_UNARY, options, request)
    }
    
    override def serverStreaming(request: service.service_json.JsonReq2, responseObserver: _root_.io.grpc.stub.StreamObserver[service.service_json.JsonResp2]): _root_.scala.Unit = {
      _root_.scalapb.grpc.ClientCalls.asyncServerStreamingCall(channel, METHOD_SERVER_STREAMING, options, request, responseObserver)
    }
    
    override def build(channel: _root_.io.grpc.Channel, options: _root_.io.grpc.CallOptions): JsonServiceStub = new JsonServiceStub(channel, options)
  }
  
  def bindService(serviceImpl: JsonService, executionContext: scala.concurrent.ExecutionContext): _root_.io.grpc.ServerServiceDefinition = JsonService.bindService(serviceImpl, executionContext)
  
  def blockingStub(channel: _root_.io.grpc.Channel): JsonServiceBlockingStub = new JsonServiceBlockingStub(channel)
  
  def stub(channel: _root_.io.grpc.Channel): JsonServiceStub = new JsonServiceStub(channel)
  
  def javaDescriptor: _root_.com.google.protobuf.Descriptors.ServiceDescriptor = service.service_json.ServiceJsonProto.javaDescriptor.getServices().get(0)
  
}