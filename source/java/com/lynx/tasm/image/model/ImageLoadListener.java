package com.lynx.tasm.image.model;

import com.lynx.tasm.image.ImageContent;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public interface ImageLoadListener {
    void onFailure(int i, Throwable th);

    void onImageMonitorInfo(JSONObject jSONObject);

    void onRequestSubmit(ImageRequestInfo imageRequestInfo);

    void onSuccess(ImageContent imageContent, ImageRequestInfo imageRequestInfo, ImageInfo imageInfo);
}
