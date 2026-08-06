package com.bytedance.vcloud.strategy;

/* loaded from: classes6.dex */
public interface IStrategyEventListener {
    void onEvent(String str, int i, int i2, String str2);

    void onEventLog(String str, String str2);

    default void strategyConfigGlobalOption(int i, int i2, Object obj) {
    }
}
