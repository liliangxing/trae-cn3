package com.lynx.animax.listener;

/* loaded from: classes6.dex */
public interface IAnimationListener {
    void onCancel(AnimaXParam animaXParam);

    void onComplete(AnimaXParam animaXParam);

    void onCompositionReady(AnimaXParam animaXParam);

    void onError(AnimaXErrorParam animaXErrorParam);

    void onFPS(AnimaXFPSParam animaXFPSParam);

    void onFirstFrame(AnimaXParam animaXParam);

    void onReady(AnimaXParam animaXParam);

    void onRepeat(AnimaXParam animaXParam);

    void onStart(AnimaXParam animaXParam);

    void onTapLayers(AnimaXTapParam animaXTapParam);

    void onUpdate(AnimaXParam animaXParam);

    void onWarning(AnimaXErrorParam animaXErrorParam);
}
