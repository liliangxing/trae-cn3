package com.lynx.react.bridge.mapbuffer;

/* loaded from: classes6.dex */
public interface CompactArrayBuffer extends Iterable<Entry> {

    /* loaded from: classes6.dex */
    public interface Entry {
        double getDouble();

        int getInt();

        long getLong();

        String getString();
    }

    int count();

    double getDouble(int i);

    int getInt(int i);

    long getLong(int i);

    String getString(int i);
}
