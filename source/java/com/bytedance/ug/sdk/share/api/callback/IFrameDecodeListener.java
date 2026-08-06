package com.bytedance.ug.sdk.share.api.callback;

import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public interface IFrameDecodeListener {
    boolean processFrame(ByteBuffer byteBuffer, int i, int i2);
}
