package com.bytedance.bmf_mods_lite_api.packageHandler;

/* loaded from: classes3.dex */
public interface ParamApi {
    default String dump() {
        return "";
    }

    default int erase(long key) {
        return -1;
    }

    default long getNativePtr() {
        return 0L;
    }

    default boolean hasKey(long key) {
        return false;
    }

    default double optDouble(long key, double defaultValue) {
        return defaultValue;
    }

    default double[] optDoubleList(long key, double[] defaultValue) {
        return defaultValue;
    }

    default float optFloat(long key, float defaultValue) {
        return defaultValue;
    }

    default float[] optFloatList(long key, float[] defaultValue) {
        return defaultValue;
    }

    default int optInt(long key, int defaultValue) {
        return defaultValue;
    }

    default int[] optIntList(long key, int[] defaultValue) {
        return defaultValue;
    }

    default long optLong(long key, long defaultValue) {
        return defaultValue;
    }

    default long[] optLongList(long key, long[] defaultValue) {
        return defaultValue;
    }

    default String optString(long key, String defaultValue) {
        return "";
    }

    default void release() {
    }

    default int setDouble(long key, double value) {
        return -1;
    }

    default int setDoubleList(long key, double[] value) {
        return -1;
    }

    default int setFloat(long key, float value) {
        return -1;
    }

    default int setFloatList(long key, float[] value) {
        return -1;
    }

    default int setInt(long key, int value) {
        return -1;
    }

    default int setIntList(long key, int[] value) {
        return -1;
    }

    default int setLong(long key, long value) {
        return -1;
    }

    default int setLongList(long key, long[] value) {
        return -1;
    }

    default int setString(long key, String value) {
        return -1;
    }
}
