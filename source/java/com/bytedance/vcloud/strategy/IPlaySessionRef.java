package com.bytedance.vcloud.strategy;

/* loaded from: classes6.dex */
public interface IPlaySessionRef {
    default void strategyConfigFloatOption(int i, int i2, float f) {
    }

    default void strategyConfigIntOption(int i, int i2, int i3) {
    }

    default void strategyConfigStringOption(int i, int i2, String str) {
    }

    default float strategyFetchFloatOption(int i, int i2, float f) {
        return f;
    }

    default int strategyFetchIntOption(int i, int i2, int i3) {
        return i3;
    }

    default String strategyFetchStringOption(int i, int i2, String str) {
        return str;
    }

    default void strategyOnEvent(int i, int i2, String str, String str2) {
    }
}
