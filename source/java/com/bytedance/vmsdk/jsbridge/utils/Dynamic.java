package com.bytedance.vmsdk.jsbridge.utils;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
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

    void recycle();
}
