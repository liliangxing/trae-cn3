package com.lynx.tasm.p001ui.image.fresco;

import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.backend.AnimationBackendDelegate;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class LoopCountModifyingBackend extends AnimationBackendDelegate {
    private int mLoopCount;

    public LoopCountModifyingBackend(AnimationBackend animationBackend, int i) {
        super(animationBackend);
        this.mLoopCount = i;
    }

    public int getLoopCount() {
        return this.mLoopCount;
    }
}
