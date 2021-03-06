// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: api.proto

package com.wwttr.api;

/**
 * Protobuf enum {@code api.Code}
 */
public enum Code
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>UNSPECIFIED = 0;</code>
   */
  UNSPECIFIED(0),
  /**
   * <code>OK = 1;</code>
   */
  OK(1),
  /**
   * <code>INVALID_ARGUMENT = 2;</code>
   */
  INVALID_ARGUMENT(2),
  /**
   * <code>INTERNAL = 3;</code>
   */
  INTERNAL(3),
  /**
   * <code>UNAVAILABLE = 4;</code>
   */
  UNAVAILABLE(4),
  /**
   * <code>NOT_FOUND = 5;</code>
   */
  NOT_FOUND(5),
  /**
   * <code>ACCESS_DENIED = 6;</code>
   */
  ACCESS_DENIED(6),
  /**
   * <code>PING = 7;</code>
   */
  PING(7),
  /**
   * <code>FAILED_PRECONDITION = 8;</code>
   */
  FAILED_PRECONDITION(8),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>UNSPECIFIED = 0;</code>
   */
  public static final int UNSPECIFIED_VALUE = 0;
  /**
   * <code>OK = 1;</code>
   */
  public static final int OK_VALUE = 1;
  /**
   * <code>INVALID_ARGUMENT = 2;</code>
   */
  public static final int INVALID_ARGUMENT_VALUE = 2;
  /**
   * <code>INTERNAL = 3;</code>
   */
  public static final int INTERNAL_VALUE = 3;
  /**
   * <code>UNAVAILABLE = 4;</code>
   */
  public static final int UNAVAILABLE_VALUE = 4;
  /**
   * <code>NOT_FOUND = 5;</code>
   */
  public static final int NOT_FOUND_VALUE = 5;
  /**
   * <code>ACCESS_DENIED = 6;</code>
   */
  public static final int ACCESS_DENIED_VALUE = 6;
  /**
   * <code>PING = 7;</code>
   */
  public static final int PING_VALUE = 7;
  /**
   * <code>FAILED_PRECONDITION = 8;</code>
   */
  public static final int FAILED_PRECONDITION_VALUE = 8;


  public final int getNumber() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalArgumentException(
          "Can't get the number of an unknown enum value.");
    }
    return value;
  }

  /**
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @java.lang.Deprecated
  public static Code valueOf(int value) {
    return forNumber(value);
  }

  public static Code forNumber(int value) {
    switch (value) {
      case 0: return UNSPECIFIED;
      case 1: return OK;
      case 2: return INVALID_ARGUMENT;
      case 3: return INTERNAL;
      case 4: return UNAVAILABLE;
      case 5: return NOT_FOUND;
      case 6: return ACCESS_DENIED;
      case 7: return PING;
      case 8: return FAILED_PRECONDITION;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<Code>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      Code> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<Code>() {
          public Code findValueByNumber(int number) {
            return Code.forNumber(number);
          }
        };

  public final com.google.protobuf.Descriptors.EnumValueDescriptor
      getValueDescriptor() {
    return getDescriptor().getValues().get(ordinal());
  }
  public final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptorForType() {
    return getDescriptor();
  }
  public static final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptor() {
    return com.wwttr.api.Api.getDescriptor().getEnumTypes().get(0);
  }

  private static final Code[] VALUES = values();

  public static Code valueOf(
      com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
    if (desc.getType() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "EnumValueDescriptor is not for this type.");
    }
    if (desc.getIndex() == -1) {
      return UNRECOGNIZED;
    }
    return VALUES[desc.getIndex()];
  }

  private final int value;

  private Code(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:api.Code)
}

