package com.lynx.animax.composition;

/* loaded from: classes6.dex */
public class AnimaXCompositionNativeCallback {
    private final AnimaXCompositionListener mListener;

    public AnimaXCompositionNativeCallback(AnimaXCompositionListener animaXCompositionListener) {
        this.mListener = animaXCompositionListener;
    }

    void onCompositionCallback(AnimaXComposition animaXComposition, String str) {
        AnimaXCompositionListener animaXCompositionListener = this.mListener;
        if (animaXCompositionListener == null) {
            return;
        }
        if (animaXComposition != null) {
            animaXCompositionListener.onCompositionReady(animaXComposition);
        } else if (str != null) {
            animaXCompositionListener.onCompositionFailed(str);
        } else {
            animaXCompositionListener.onCompositionFailed("Unknown error");
        }
    }
}
