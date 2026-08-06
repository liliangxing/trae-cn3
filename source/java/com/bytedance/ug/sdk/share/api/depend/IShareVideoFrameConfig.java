package com.bytedance.ug.sdk.share.api.depend;

import com.bytedance.ug.sdk.share.api.callback.IFrameDecodeListener;
import com.bytedance.ug.sdk.share.api.entity.VideoOptions;

/* loaded from: classes4.dex */
public interface IShareVideoFrameConfig {
    void getVideoFrame(String str, VideoOptions videoOptions, IFrameDecodeListener iFrameDecodeListener);
}
