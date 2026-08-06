package com.bytedance.bmf_mods_api;

/* loaded from: classes3.dex */
public interface VideoSRLutDspAPI {
    void Free();

    int[] GetTextures();

    boolean Init(int i, int i2, String str);

    int Process();
}
