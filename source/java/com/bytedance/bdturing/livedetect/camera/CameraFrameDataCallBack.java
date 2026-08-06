package com.bytedance.bdturing.livedetect.camera;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public interface CameraFrameDataCallBack {
    void onCameraException(int i, Exception exc);

    void onFrameData(ImageDataWrapper imageDataWrapper, JSONObject jSONObject);
}
