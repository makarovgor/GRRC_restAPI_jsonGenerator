// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!
//
// Protofile syntax: PROTO3

package service.service_json

@SerialVersionUID(0L)
final case class JsonResp1(
    json: _root_.scala.Option[_root_.scala.Predef.String] = _root_.scala.None,
    unknownFields: _root_.scalapb.UnknownFieldSet = _root_.scalapb.UnknownFieldSet.empty
    ) extends scalapb.GeneratedMessage with scalapb.lenses.Updatable[JsonResp1] {
    @transient
    private[this] var __serializedSizeMemoized: _root_.scala.Int = 0
    private[this] def __computeSerializedSize(): _root_.scala.Int = {
      var __size = 0
      if (json.isDefined) {
        val __value = json.get
        __size += _root_.com.google.protobuf.CodedOutputStream.computeStringSize(1, __value)
      };
      __size += unknownFields.serializedSize
      __size
    }
    override def serializedSize: _root_.scala.Int = {
      var __size = __serializedSizeMemoized
      if (__size == 0) {
        __size = __computeSerializedSize() + 1
        __serializedSizeMemoized = __size
      }
      __size - 1
      
    }
    def writeTo(`_output__`: _root_.com.google.protobuf.CodedOutputStream): _root_.scala.Unit = {
      json.foreach { __v =>
        val __m = __v
        _output__.writeString(1, __m)
      };
      unknownFields.writeTo(_output__)
    }
    def getJson: _root_.scala.Predef.String = json.getOrElse("")
    def clearJson: JsonResp1 = copy(json = _root_.scala.None)
    def withJson(__v: _root_.scala.Predef.String): JsonResp1 = copy(json = Option(__v))
    def withUnknownFields(__v: _root_.scalapb.UnknownFieldSet) = copy(unknownFields = __v)
    def discardUnknownFields = copy(unknownFields = _root_.scalapb.UnknownFieldSet.empty)
    def getFieldByNumber(__fieldNumber: _root_.scala.Int): _root_.scala.Any = {
      (__fieldNumber: @_root_.scala.unchecked) match {
        case 1 => json.orNull
      }
    }
    def getField(__field: _root_.scalapb.descriptors.FieldDescriptor): _root_.scalapb.descriptors.PValue = {
      _root_.scala.Predef.require(__field.containingMessage eq companion.scalaDescriptor)
      (__field.number: @_root_.scala.unchecked) match {
        case 1 => json.map(_root_.scalapb.descriptors.PString(_)).getOrElse(_root_.scalapb.descriptors.PEmpty)
      }
    }
    def toProtoString: _root_.scala.Predef.String = _root_.scalapb.TextFormat.printToUnicodeString(this)
    def companion: service.service_json.JsonResp1.type = service.service_json.JsonResp1
    // @@protoc_insertion_point(GeneratedMessage[service.JsonResp1])
}

object JsonResp1 extends scalapb.GeneratedMessageCompanion[service.service_json.JsonResp1] {
  implicit def messageCompanion: scalapb.GeneratedMessageCompanion[service.service_json.JsonResp1] = this
  def parseFrom(`_input__`: _root_.com.google.protobuf.CodedInputStream): service.service_json.JsonResp1 = {
    var __json: _root_.scala.Option[_root_.scala.Predef.String] = _root_.scala.None
    var `_unknownFields__`: _root_.scalapb.UnknownFieldSet.Builder = null
    var _done__ = false
    while (!_done__) {
      val _tag__ = _input__.readTag()
      _tag__ match {
        case 0 => _done__ = true
        case 10 =>
          __json = Option(_input__.readStringRequireUtf8())
        case tag =>
          if (_unknownFields__ == null) {
            _unknownFields__ = new _root_.scalapb.UnknownFieldSet.Builder()
          }
          _unknownFields__.parseField(tag, _input__)
      }
    }
    service.service_json.JsonResp1(
        json = __json,
        unknownFields = if (_unknownFields__ == null) _root_.scalapb.UnknownFieldSet.empty else _unknownFields__.result()
    )
  }
  implicit def messageReads: _root_.scalapb.descriptors.Reads[service.service_json.JsonResp1] = _root_.scalapb.descriptors.Reads{
    case _root_.scalapb.descriptors.PMessage(__fieldsMap) =>
      _root_.scala.Predef.require(__fieldsMap.keys.forall(_.containingMessage eq scalaDescriptor), "FieldDescriptor does not match message type.")
      service.service_json.JsonResp1(
        json = __fieldsMap.get(scalaDescriptor.findFieldByNumber(1).get).flatMap(_.as[_root_.scala.Option[_root_.scala.Predef.String]])
      )
    case _ => throw new RuntimeException("Expected PMessage")
  }
  def javaDescriptor: _root_.com.google.protobuf.Descriptors.Descriptor = ServiceJsonProto.javaDescriptor.getMessageTypes().get(1)
  def scalaDescriptor: _root_.scalapb.descriptors.Descriptor = ServiceJsonProto.scalaDescriptor.messages(1)
  def messageCompanionForFieldNumber(__number: _root_.scala.Int): _root_.scalapb.GeneratedMessageCompanion[_] = throw new MatchError(__number)
  lazy val nestedMessagesCompanions: Seq[_root_.scalapb.GeneratedMessageCompanion[_ <: _root_.scalapb.GeneratedMessage]] = Seq.empty
  def enumCompanionForFieldNumber(__fieldNumber: _root_.scala.Int): _root_.scalapb.GeneratedEnumCompanion[_] = throw new MatchError(__fieldNumber)
  lazy val defaultInstance = service.service_json.JsonResp1(
    json = _root_.scala.None
  )
  implicit class JsonResp1Lens[UpperPB](_l: _root_.scalapb.lenses.Lens[UpperPB, service.service_json.JsonResp1]) extends _root_.scalapb.lenses.ObjectLens[UpperPB, service.service_json.JsonResp1](_l) {
    def json: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Predef.String] = field(_.getJson)((c_, f_) => c_.copy(json = Option(f_)))
    def optionalJson: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Option[_root_.scala.Predef.String]] = field(_.json)((c_, f_) => c_.copy(json = f_))
  }
  final val JSON_FIELD_NUMBER = 1
  def of(
    json: _root_.scala.Option[_root_.scala.Predef.String]
  ): _root_.service.service_json.JsonResp1 = _root_.service.service_json.JsonResp1(
    json
  )
  // @@protoc_insertion_point(GeneratedMessageCompanion[service.JsonResp1])
}
