package com.lynx.react.bridge;

/* loaded from: classes6.dex */
public interface Dynamic {
    ReadableArray asArray();

    boolean asBoolean();

    byte[] asByteArray();

    double asDouble();

    int asInt();

    long asLong();

    ReadableMap asMap();

    String asString();

    ReadableType getType();

    boolean isNull();

    @Deprecated
    void recycle();
}
