package com.lynx.animax.p034ui;

import com.lynx.animax.base.VisibilityState;
import com.lynx.animax.base.bridge.JavaOnlyMap;
import com.lynx.animax.composition.AnimaXComposition;
import com.lynx.animax.drawable.AnimaXSurfaceDrawable;
import com.lynx.animax.listener.IAnimationListener;
import com.lynx.animax.property.AnimaXKeyPath;
import com.lynx.animax.property.AnimaXKeyPathListCallback;
import com.lynx.animax.property.AnimaXPropertyCallback;
import com.lynx.animax.property.AnimaXValueCallback;
import com.lynx.animax.property.AnimaXValueParam;
import com.lynx.animax.property.LayerPropertyType;
import com.lynx.animax.property.ResourcePropertyType;
import com.lynx.animax.util.AnimaXMetricsCallback;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public interface IAnimaXPlayer {
    void addAnimationListener(IAnimationListener iAnimationListener);

    void addLayerPropertyCallback(LayerPropertyType layerPropertyType, AnimaXKeyPath animaXKeyPath, AnimaXValueCallback animaXValueCallback, AnimaXPropertyCallback animaXPropertyCallback);

    void cancel();

    void createAnimaXSurface(AnimaXSurfaceDrawable animaXSurfaceDrawable);

    void enableSoftwareRender(boolean z);

    void enterBackground();

    void enterForeground();

    AnimaXContext getAnimaXContext();

    AnimaXComposition getComposition();

    double getCurrentFrame();

    double getDurationMs();

    void getKeysForKeyPath(AnimaXKeyPath animaXKeyPath, AnimaXKeyPathListCallback animaXKeyPathListCallback);

    void getMetricsAsync(AnimaXMetricsCallback animaXMetricsCallback);

    boolean isAnimating();

    void markPlatformSurfaceAsInvalid(boolean z);

    void onHide(VisibilityState visibilityState);

    void onShow(VisibilityState visibilityState);

    void onTap(float f, float f2);

    void pause();

    void play();

    void playSegment(int i, int i2);

    void release();

    void reload();

    void removeAnimationListener(IAnimationListener iAnimationListener);

    void removeLayerPropertyCallback(LayerPropertyType layerPropertyType, AnimaXKeyPath animaXKeyPath, AnimaXPropertyCallback animaXPropertyCallback);

    void resume();

    void seek(int i);

    void setAntiAliasing(boolean z);

    void setAutoPlay(boolean z);

    void setAutoReverse(boolean z);

    void setComposition(AnimaXComposition animaXComposition);

    void setDynamicResource(boolean z);

    void setEndFrame(int i);

    void setFpsEventInterval(long j);

    void setImageFolder(String str);

    void setJson(String str);

    void setKeepLastFrame(boolean z);

    void setLoop(boolean z);

    void setLoopCount(int i);

    void setMaxFrameRate(double d);

    void setObjectFit(ObjectFit objectFit);

    void setObjectPosition(ObjectPosition objectPosition);

    void setProgress(float f);

    void setResourceProperty(ResourcePropertyType resourcePropertyType, String str, AnimaXValueParam animaXValueParam, AnimaXPropertyCallback animaXPropertyCallback);

    void setSpeed(float f);

    void setSrc(String str);

    void setSrcPolyfill(JavaOnlyMap javaOnlyMap);

    void setStartFrame(int i);

    void stop();

    void subscribeUpdateEvent(int i);

    void subscribeUpdateEvents(int[] iArr, boolean z);

    void unsubscribeUpdateEvent(int i);

    void updateAnimaXSurface(AnimaXSurfaceDrawable animaXSurfaceDrawable);

    void updateLayerProperty(LayerPropertyType layerPropertyType, AnimaXKeyPath animaXKeyPath, AnimaXValueParam animaXValueParam, AnimaXPropertyCallback animaXPropertyCallback);

    void updateVisibilityState(boolean z, VisibilityState visibilityState);
}
