package com.bytedance.bdinstall.nu;

/* loaded from: classes3.dex */
public interface Action {
    Action addCustomParam(String str, String str2);

    void done();

    Action setAutoMode(boolean z);

    Action setNUMode(boolean z);
}
