package com.bytedance.bmf_mods_api;

import android.content.Context;
import java.util.Map;

/* loaded from: classes3.dex */
public interface NoiseLiveAPI {
    void DownloadModel(Context context, Map<String, String> map);

    void Free();

    boolean Init(int i);

    boolean Init(int i, int i2);

    float Process(int i, int i2, int i3);

    void SetCallback(NoiseLiveCallbackAPI noiseLiveCallbackAPI);
}
