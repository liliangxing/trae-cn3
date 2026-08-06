package com.bytedance.bmf_mods_api;

import com.google.gson.JsonObject;

/* loaded from: classes3.dex */
public interface ColorHistAPI {
    void Free();

    JsonObject GetResult();

    int Init(int i, int i2, int i3, int i4, int i5);

    int ProcessOesTexture(int i, int i2, int i3, float[] fArr, long j);

    int ProcessTexture(int i, int i2, int i3, long j);

    int ResetStatus();
}
