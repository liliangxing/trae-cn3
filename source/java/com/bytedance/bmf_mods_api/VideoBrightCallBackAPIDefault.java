package com.bytedance.bmf_mods_api;

import android.util.Log;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoBrightCallbackAPI.java */
/* loaded from: classes3.dex */
public class VideoBrightCallBackAPIDefault implements VideoBrightCallbackAPI {
    @Override // com.bytedance.bmf_mods_api.VideoBrightCallbackAPI
    public void callback(int i, float f, float f2, float f3) {
        Log.d("bmf_mods", "status change:" + i + " cost time:" + f + " bright_before:" + f2 + " bright_after:" + f3);
    }
}
