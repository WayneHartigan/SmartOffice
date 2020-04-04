# -*- coding: utf-8 -*-
# Generated by the protocol buffer compiler.  DO NOT EDIT!
# source: projector.proto

import sys
_b=sys.version_info[0]<3 and (lambda x:x) or (lambda x:x.encode('latin1'))
from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from google.protobuf import reflection as _reflection
from google.protobuf import symbol_database as _symbol_database
# @@protoc_insertion_point(imports)

_sym_db = _symbol_database.Default()




DESCRIPTOR = _descriptor.FileDescriptor(
  name='projector.proto',
  package='',
  syntax='proto3',
  serialized_options=None,
  serialized_pb=_b('\n\x0fprojector.proto\"\x16\n\x05Input\x12\r\n\x05input\x18\x01 \x01(\t2,\n\tProjector\x12\x1f\n\x0b\x43hangeInput\x12\x06.Input\x1a\x06.Input\"\x00\x62\x06proto3')
)




_INPUT = _descriptor.Descriptor(
  name='Input',
  full_name='Input',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='input', full_name='Input.input', index=0,
      number=1, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=_b("").decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=19,
  serialized_end=41,
)

DESCRIPTOR.message_types_by_name['Input'] = _INPUT
_sym_db.RegisterFileDescriptor(DESCRIPTOR)

Input = _reflection.GeneratedProtocolMessageType('Input', (_message.Message,), {
  'DESCRIPTOR' : _INPUT,
  '__module__' : 'projector_pb2'
  # @@protoc_insertion_point(class_scope:Input)
  })
_sym_db.RegisterMessage(Input)



_PROJECTOR = _descriptor.ServiceDescriptor(
  name='Projector',
  full_name='Projector',
  file=DESCRIPTOR,
  index=0,
  serialized_options=None,
  serialized_start=43,
  serialized_end=87,
  methods=[
  _descriptor.MethodDescriptor(
    name='ChangeInput',
    full_name='Projector.ChangeInput',
    index=0,
    containing_service=None,
    input_type=_INPUT,
    output_type=_INPUT,
    serialized_options=None,
  ),
])
_sym_db.RegisterServiceDescriptor(_PROJECTOR)

DESCRIPTOR.services_by_name['Projector'] = _PROJECTOR

# @@protoc_insertion_point(module_scope)
