package com.bytedance.bmf_mods_api;

/* loaded from: classes3.dex */
public interface VideoBrightAPI {
    void Free();

    int GetStatus();

    boolean Init(int i, int i2, int i3, int i4);

    int Process(int i, int i2, int i3, int i4, long j);

    void SetCallback(VideoBrightCallbackAPI videoBrightCallbackAPI);
}
