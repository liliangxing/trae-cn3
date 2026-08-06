package com.lynx.react.bridge;

import com.lynx.tasm.TemplateData;
import java.nio.ByteBuffer;
import java.util.HashMap;

/* loaded from: classes6.dex */
public interface ReadableMap {
    HashMap<String, Object> asHashMap();

    ReadableArray getArray(String str);

    ReadableArray getArray(String str, ReadableArray readableArray);

    boolean getBoolean(String str);

    boolean getBoolean(String str, boolean z);

    byte[] getByteArray(String str);

    byte[] getByteArray(String str, byte[] bArr);

    ByteBuffer getByteBuffer(String str);

    ByteBuffer getByteBuffer(String str, ByteBuffer byteBuffer);

    double getDouble(String str);

    double getDouble(String str, double d);

    Dynamic getDynamic(String str);

    int getInt(String str);

    int getInt(String str, int i);

    long getLong(String str);

    long getLong(String str, long j);

    ReadableMap getMap(String str);

    ReadableMap getMap(String str, ReadableMap readableMap);

    PiperData getPiperData(String str);

    PiperData getPiperData(String str, PiperData piperData);

    String getString(String str);

    String getString(String str, String str2);

    TemplateData getTemplateData(String str);

    ReadableType getType(String str);

    boolean hasKey(String str);

    boolean isNull(String str);

    ReadableMapKeySetIterator keySetIterator();

    int size();

    @Deprecated
    HashMap<String, Object> toHashMap();
}
