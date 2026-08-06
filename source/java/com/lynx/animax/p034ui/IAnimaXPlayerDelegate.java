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
public interface IAnimaXPlayerDelegate extends IAnimaXPlayer {
    IAnimaXPlayer getPlayer();

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    default AnimaXContext getAnimaXContext() {
        return getPlayer().getAnimaXContext();
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    default void enableSoftwareRender(boolean z) {
        getPlayer().enableSoftwareRender(z);
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    default void createAnimaXSurface(AnimaXSurfaceDrawable animaXSurfaceDrawable) {
        getPlayer().createAnimaXSurface(animaXSurfaceDrawable);
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    default void updateAnimaXSurface(AnimaXSurfaceDrawable animaXSurfaceDrawable) {
        getPlayer().updateAnimaXSurface(animaXSurfaceDrawable);
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    default void markPlatformSurfaceAsInvalid(boolean z) {
        getPlayer().markPlatformSurfaceAsInvalid(z);
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    default void setImageFolder(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        getPlayer().setImageFolder(str);
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    default void setComposition(AnimaXComposition animaXComposition) {
        getPlayer().setComposition(animaXComposition);
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    default AnimaXComposition getComposition() {
        return getPlayer().getComposition();
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    default void setJson(String str) {
        getPlayer().setJson(str);
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    default void setSrc(String str) {
        getPlayer().setSrc(str);
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    default void setSrcPolyfill(JavaOnlyMap javaOnlyMap) {
        getPlayer().setSrcPolyfill(javaOnlyMap);
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    default void setDynamicResource(boolean z) {
        getPlayer().setDynamicResource(z);
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    default void setLoop(boolean z) {
        getPlayer().setLoop(z);
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    default void setLoopCount(int i) {
        getPlayer().setLoopCount(i);
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    default void setStartFrame(int i) {
        getPlayer().setStartFrame(i);
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    default void setEndFrame(int i) {
        getPlayer().setEndFrame(i);
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    default void setProgress(float f) {
        getPlayer().setProgress(f);
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    default void setSpeed(float f) {
        getPlayer().setSpeed(f);
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    default void setAutoReverse(boolean z) {
        getPlayer().setAutoReverse(z);
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    default void setMaxFrameRate(double d) {
        getPlayer().setMaxFrameRate(d);
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    default void setAutoPlay(boolean z) {
        getPlayer().setAutoPlay(z);
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    default void setObjectFit(ObjectFit objectFit) {
        getPlayer().setObjectFit(objectFit);
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    default void setObjectPosition(ObjectPosition objectPosition) {
        getPlayer().setObjectPosition(objectPosition);
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    default void setKeepLastFrame(boolean z) {
        getPlayer().setKeepLastFrame(z);
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    default void play() {
        getPlayer().play();
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    default void pause() {
        getPlayer().pause();
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    default void resume() {
        getPlayer().resume();
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    default void stop() {
        getPlayer().stop();
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    default void seek(int i) {
        getPlayer().seek(i);
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    default void cancel() {
        getPlayer().cancel();
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    default void playSegment(int i, int i2) {
        getPlayer().playSegment(i, i2);
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    default void reload() {
        getPlayer().reload();
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    default boolean isAnimating() {
        return getPlayer().isAnimating();
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    default double getCurrentFrame() {
        return getPlayer().getCurrentFrame();
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    default double getDurationMs() {
        return getPlayer().getDurationMs();
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    default void updateVisibilityState(boolean z, VisibilityState visibilityState) {
        getPlayer().updateVisibilityState(z, visibilityState);
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    default void onShow(VisibilityState visibilityState) {
        getPlayer().onShow(visibilityState);
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    default void onHide(VisibilityState visibilityState) {
        getPlayer().onHide(visibilityState);
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    default void enterForeground() {
        getPlayer().enterForeground();
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    default void enterBackground() {
        getPlayer().enterBackground();
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    default void setFpsEventInterval(long j) {
        getPlayer().setFpsEventInterval(j);
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    default void subscribeUpdateEvent(int i) {
        getPlayer().subscribeUpdateEvent(i);
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    default void unsubscribeUpdateEvent(int i) {
        getPlayer().unsubscribeUpdateEvent(i);
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    default void subscribeUpdateEvents(int[] iArr, boolean z) {
        getPlayer().subscribeUpdateEvents(iArr, z);
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    default void addAnimationListener(IAnimationListener iAnimationListener) {
        getPlayer().addAnimationListener(iAnimationListener);
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    default void removeAnimationListener(IAnimationListener iAnimationListener) {
        getPlayer().removeAnimationListener(iAnimationListener);
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    default void onTap(float f, float f2) {
        getPlayer().onTap(f, f2);
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    default void getMetricsAsync(AnimaXMetricsCallback animaXMetricsCallback) {
        getPlayer().getMetricsAsync(animaXMetricsCallback);
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    default void setAntiAliasing(boolean z) {
        getPlayer().setAntiAliasing(z);
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    default void updateLayerProperty(LayerPropertyType layerPropertyType, AnimaXKeyPath animaXKeyPath, AnimaXValueParam animaXValueParam, AnimaXPropertyCallback animaXPropertyCallback) {
        getPlayer().updateLayerProperty(layerPropertyType, animaXKeyPath, animaXValueParam, animaXPropertyCallback);
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    default void addLayerPropertyCallback(LayerPropertyType layerPropertyType, AnimaXKeyPath animaXKeyPath, AnimaXValueCallback animaXValueCallback, AnimaXPropertyCallback animaXPropertyCallback) {
        getPlayer().addLayerPropertyCallback(layerPropertyType, animaXKeyPath, animaXValueCallback, animaXPropertyCallback);
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    default void removeLayerPropertyCallback(LayerPropertyType layerPropertyType, AnimaXKeyPath animaXKeyPath, AnimaXPropertyCallback animaXPropertyCallback) {
        getPlayer().removeLayerPropertyCallback(layerPropertyType, animaXKeyPath, animaXPropertyCallback);
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    default void setResourceProperty(ResourcePropertyType resourcePropertyType, String str, AnimaXValueParam animaXValueParam, AnimaXPropertyCallback animaXPropertyCallback) {
        getPlayer().setResourceProperty(resourcePropertyType, str, animaXValueParam, animaXPropertyCallback);
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    default void getKeysForKeyPath(AnimaXKeyPath animaXKeyPath, AnimaXKeyPathListCallback animaXKeyPathListCallback) {
        getPlayer().getKeysForKeyPath(animaXKeyPath, animaXKeyPathListCallback);
    }
}
