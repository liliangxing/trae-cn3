package com.bytedance.ug.sdk.share.api.depend;

import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public interface IShareVideoWmConfig {
    String decodeWaterMarkWithPath(String str);

    String decodeWatermarkWithFrame(ByteBuffer byteBuffer, int i, int i2);
}
