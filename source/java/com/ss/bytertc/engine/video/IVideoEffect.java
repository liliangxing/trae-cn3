package com.ss.bytertc.engine.video;

import com.ss.bytertc.engine.data.VirtualBackgroundSource;
import java.util.List;

/* loaded from: classes7.dex */
public abstract class IVideoEffect {
    public abstract int appendEffectNodes(List<String> effectNodes);

    public abstract int applyStickerEffect(String tickerPath);

    public abstract int disableFaceDetection();

    public abstract int disableVideoEffect();

    public abstract int disableVirtualBackground();

    public abstract int enableFaceDetection(IFaceDetectionObserver observer, int intervalMs, String faceModelPath);

    public abstract int enableVideoEffect();

    public abstract int enableVirtualBackground(String backgroundStickerRes, VirtualBackgroundSource source);

    public abstract int getGestureRegistered(EffectTouchGesture gesture);

    public abstract int getSuspendGestureRecognizer(EffectTouchGesture gesture, boolean suspend);

    public abstract long getVideoEffectHandle();

    public abstract int initCVResource(String licenseFile, String algoModelDir);

    public abstract int removeEffectNodes(List<String> effectNodes);

    public abstract int setAlgoModelResourceFinder(long finder, long deleter);

    public abstract int setColorFilter(String filterRes);

    public abstract int setColorFilterIntensity(float intensity);

    public abstract int setEffectNodes(List<String> effectNodes);

    public abstract int setVideoEffectExpressionDetect(VideoEffectExpressionConfig config);

    public abstract int setVideoEffectTouchEvent(int pointerId, float x, float y, float force, float majorRadius, EffectTouchType type, int pointerCount);

    public abstract int updateEffectNode(String effectNode, String key, float value);
}
