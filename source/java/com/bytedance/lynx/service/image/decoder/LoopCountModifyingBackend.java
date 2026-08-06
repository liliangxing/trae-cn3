package com.bytedance.lynx.service.image.decoder;

import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.backend.AnimationBackendDelegate;

/* loaded from: classes4.dex */
public class LoopCountModifyingBackend extends AnimationBackendDelegate {
    private int mLoopCount;

    public LoopCountModifyingBackend(AnimationBackend animationBackend, int i) {
        super(animationBackend);
        this.mLoopCount = i;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackendDelegate, com.facebook.fresco.animation.backend.AnimationInformation
    public int getLoopCount() {
        return this.mLoopCount;
    }
}
