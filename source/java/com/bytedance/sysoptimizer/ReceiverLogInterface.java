package com.bytedance.sysoptimizer;

/* loaded from: classes5.dex */
public interface ReceiverLogInterface {
    boolean enable();

    void onRegister(String str);

    void onUnRegister(String str);
}
