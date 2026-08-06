package com.lynx.tasm.behavior;

import com.lynx.react.bridge.Dynamic;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.mapbuffer.MapBuffer;
import com.lynx.react.bridge.mapbuffer.ReadableMapBufferWrapper;

/* loaded from: classes7.dex */
public class StylesDiffMap {
    public final ReadableMap mBackingMap;
    private MapBuffer mBackingStyles;

    public StylesDiffMap(ReadableMap readableMap) {
        this.mBackingStyles = null;
        this.mBackingMap = readableMap;
    }

    public StylesDiffMap(ReadableMap readableMap, MapBuffer mapBuffer) {
        this.mBackingMap = readableMap;
        this.mBackingStyles = mapBuffer;
    }

    public boolean hasKey(String str) {
        return this.mBackingMap.hasKey(str);
    }

    public boolean hasKey(int i) {
        MapBuffer mapBuffer = this.mBackingStyles;
        if (mapBuffer != null) {
            return mapBuffer.contains(i);
        }
        return false;
    }

    public boolean isEmpty() {
        MapBuffer mapBuffer;
        ReadableMap readableMap = this.mBackingMap;
        return (readableMap == null || readableMap.size() == 0) && ((mapBuffer = this.mBackingStyles) == null || mapBuffer.count() == 0);
    }

    public boolean isNull(String str) {
        return this.mBackingMap.isNull(str);
    }

    public boolean getBoolean(String str, boolean z) {
        return this.mBackingMap.isNull(str) ? z : this.mBackingMap.getBoolean(str);
    }

    public double getDouble(String str, double d) {
        return this.mBackingMap.isNull(str) ? d : this.mBackingMap.getDouble(str);
    }

    public float getFloat(String str, float f) {
        return this.mBackingMap.isNull(str) ? f : (float) this.mBackingMap.getDouble(str);
    }

    public int getInt(String str, int i) {
        return this.mBackingMap.isNull(str) ? i : this.mBackingMap.getInt(str);
    }

    public String getString(String str) {
        return this.mBackingMap.getString(str);
    }

    public ReadableArray getArray(String str) {
        return this.mBackingMap.getArray(str);
    }

    public ReadableArray getArray(int i) {
        if (this.mBackingStyles != null) {
            return new ReadableMapBufferWrapper(this.mBackingStyles.getMapBuffer(i));
        }
        return null;
    }

    public ReadableMap getMap(String str) {
        return this.mBackingMap.getMap(str);
    }

    public Dynamic getDynamic(String str) {
        return this.mBackingMap.getDynamic(str);
    }

    public MapBuffer getStyleMap() {
        return this.mBackingStyles;
    }

    public String toString() {
        return "{ " + getClass().getSimpleName() + ": " + this.mBackingMap.toString() + " }";
    }
}
