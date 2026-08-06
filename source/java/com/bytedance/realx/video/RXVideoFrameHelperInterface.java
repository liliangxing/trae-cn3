package com.bytedance.realx.video;

import com.bytedance.realx.base.RefCounted;

/* loaded from: classes4.dex */
public interface RXVideoFrameHelperInterface extends RefCounted {
    long getNativeHandle();

    @Override // com.bytedance.realx.base.RefCounted
    void release();

    @Override // com.bytedance.realx.base.RefCounted
    void retain();
}
