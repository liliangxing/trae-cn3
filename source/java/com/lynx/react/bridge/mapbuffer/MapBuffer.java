package com.lynx.react.bridge.mapbuffer;

import com.lynx.react.bridge.mapbuffer.CompactArrayBuffer;
import java.util.List;

/* loaded from: classes6.dex */
public interface MapBuffer extends Iterable<Entry> {

    /* loaded from: classes6.dex */
    public enum DataType {
        NULL,
        BOOL,
        INT,
        LONG,
        DOUBLE,
        STRING,
        ARRAY
    }

    /* loaded from: classes6.dex */
    public interface Entry extends CompactArrayBuffer.Entry {
        boolean getBoolean();

        @Override // com.lynx.react.bridge.mapbuffer.CompactArrayBuffer.Entry
        double getDouble();

        int getKey();

        @Override // com.lynx.react.bridge.mapbuffer.CompactArrayBuffer.Entry
        long getLong();

        MapBuffer getMapBuffer();

        DataType getType();
    }

    boolean contains(int i);

    int count();

    Entry entryAt(int i);

    boolean getBoolean(int i);

    double getDouble(int i);

    int getInt(int i);

    int getKeyOffset(int i);

    long getLong(int i);

    MapBuffer getMapBuffer(int i);

    List<MapBuffer> getMapBufferList(int i);

    String getString(int i);

    DataType getType(int i);
}
