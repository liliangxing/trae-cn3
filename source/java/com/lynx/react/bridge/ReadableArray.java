package com.lynx.react.bridge;

import java.util.ArrayList;

/* loaded from: classes6.dex */
public interface ReadableArray {
    ArrayList<Object> asArrayList();

    ReadableArray getArray(int i);

    boolean getBoolean(int i);

    byte getByte(int i);

    byte[] getByteArray(int i);

    char getChar(int i);

    double getDouble(int i);

    Dynamic getDynamic(int i);

    int getInt(int i);

    long getLong(int i);

    ReadableMap getMap(int i);

    PiperData getPiperData(int i);

    short getShort(int i);

    String getString(int i);

    ReadableType getType(int i);

    boolean isNull(int i);

    int size();

    @Deprecated
    ArrayList<Object> toArrayList();
}
