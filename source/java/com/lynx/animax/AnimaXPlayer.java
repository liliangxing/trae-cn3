package com.lynx.animax;

import android.content.Context;
import com.lynx.animax.ability.BaseAbility;
import com.lynx.animax.ability.Event;
import com.lynx.animax.base.AnimaXError;
import com.lynx.animax.base.CleanupReference;
import com.lynx.animax.base.VisibilityState;
import com.lynx.animax.base.bridge.JavaOnlyMap;
import com.lynx.animax.base.bridge.ReadableMap;
import com.lynx.animax.composition.AnimaXComposition;
import com.lynx.animax.drawable.AnimaXSurfaceDrawable;
import com.lynx.animax.listener.IAnimationListener;
import com.lynx.animax.loader.AnimaXResourceLoaderHolder;
import com.lynx.animax.p034ui.AnimaXContext;
import com.lynx.animax.p034ui.IAnimaXPlayer;
import com.lynx.animax.p034ui.ObjectFit;
import com.lynx.animax.p034ui.ObjectPosition;
import com.lynx.animax.property.AnimaXKeyPath;
import com.lynx.animax.property.AnimaXKeyPathListCallback;
import com.lynx.animax.property.AnimaXPropertyCallback;
import com.lynx.animax.property.AnimaXValueCallback;
import com.lynx.animax.property.AnimaXValueParam;
import com.lynx.animax.property.LayerPropertyType;
import com.lynx.animax.property.ResourcePropertyType;
import com.lynx.animax.service.IAnimaXResourceFactoryService;
import com.lynx.animax.util.AnimaX;
import com.lynx.animax.util.AnimaXLog;
import com.lynx.animax.util.AnimaXMetricsCallback;
import com.lynx.animax.util.DeviceUtil;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class AnimaXPlayer implements IAnimaXPlayer {
    private static final String TAG = "AnimaXPlayer";
    private final BaseAbility mAbility;
    private AnimaXComposition mAnimaXComposition;
    private final AnimaXContext mAnimaXContext;
    private volatile long mPtr;
    private AnimaXResourceLoaderHolder mResourceLoaderHolder;
    private boolean mAutoPlay = false;
    private boolean mHasDestroyed = false;
    private boolean mEnableAntiAliasing = false;
    private boolean mEnableSoftwareRender = false;
    private boolean mIsPlatformSurfaceInitiallyInvalid = false;
    private CleanupReference mCleanUpReference = null;
    private int mVisibilityFlag = 0;

    private native void nativeAddLayerPropertyCallback(long j, int i, AnimaXKeyPath animaXKeyPath, AnimaXValueCallback animaXValueCallback, AnimaXPropertyCallback animaXPropertyCallback);

    private native void nativeCancel(long j);

    private native long nativeCreate(float f, BaseAbility baseAbility, long j, boolean z, boolean z2);

    private native void nativeCreateAnimaXSurface(long j, AnimaXSurfaceDrawable animaXSurfaceDrawable);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeDestroy(long j);

    private native double nativeGetCurrentFrame(long j);

    private native double nativeGetDurationMs(long j);

    private native ReadableMap nativeGetEventTrackingMap(long j);

    private native void nativeGetKeysForKeyPath(long j, AnimaXKeyPath animaXKeyPath, AnimaXKeyPathListCallback animaXKeyPathListCallback);

    private native void nativeGetMetricsAsync(long j, AnimaXMetricsCallback animaXMetricsCallback);

    private native boolean nativeIsAnimating(long j);

    private native void nativeOnHide(long j, long j2);

    private native void nativeOnShow(long j, long j2);

    private native void nativeOnTap(long j, float f, float f2);

    private native void nativePause(long j);

    private native void nativePlay(long j);

    private native void nativePlaySegment(long j, int i, int i2);

    private native void nativeReload(long j);

    private native void nativeResume(long j);

    private native void nativeSeek(long j, int i);

    private native void nativeSetAutoPlay(long j, boolean z);

    private native void nativeSetAutoReverse(long j, boolean z);

    private native void nativeSetComposition(long j, long j2);

    private native void nativeSetDynamicResource(long j, boolean z);

    private native void nativeSetEndFrame(long j, int i);

    private native void nativeSetFpsEventInterval(long j, long j2);

    private native void nativeSetImageFolder(long j, String str);

    private native void nativeSetJson(long j, String str);

    private native void nativeSetKeepLastFrame(long j, boolean z);

    private native void nativeSetLoop(long j, boolean z);

    private native void nativeSetLoopCount(long j, int i);

    private native void nativeSetMaxFrameRate(long j, double d);

    private native void nativeSetObjectFit(long j, int i);

    private native void nativeSetObjectPosition(long j, int i);

    private native void nativeSetProgress(long j, float f);

    private native void nativeSetResourceProperty(long j, int i, String str, AnimaXValueParam animaXValueParam, AnimaXPropertyCallback animaXPropertyCallback);

    private native void nativeSetSpeed(long j, float f);

    private native void nativeSetSrc(long j, String str);

    private native void nativeSetSrcPolyfill(long j, JavaOnlyMap javaOnlyMap);

    private native void nativeSetStartFrame(long j, int i);

    private native void nativeStop(long j);

    private native void nativeSubscribeUpdateEvent(long j, int i);

    private native void nativeSubscribeUpdateEvents(long j, int[] iArr, boolean z);

    private native void nativeUnsubscribeUpdateEvent(long j, int i);

    private native void nativeUpdateAnimaXSurface(long j, AnimaXSurfaceDrawable animaXSurfaceDrawable);

    private native void nativeUpdateLayerProperty(long j, int i, AnimaXKeyPath animaXKeyPath, AnimaXValueParam animaXValueParam, AnimaXPropertyCallback animaXPropertyCallback);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class CleanupOnUiThread implements Runnable {
        private long mNativePtr;

        public CleanupOnUiThread(long j) {
            this.mNativePtr = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mNativePtr == 0) {
                return;
            }
            AnimaXLog.m2541i(AnimaXPlayer.TAG, "Call nativeDestroy.");
            AnimaXPlayer.nativeDestroy(this.mNativePtr);
            this.mNativePtr = 0L;
        }
    }

    public AnimaXPlayer(AnimaXContext animaXContext) {
        AnimaXLog.m2541i(TAG, "create AnimaXPlayer: " + this);
        this.mAnimaXContext = animaXContext;
        BaseAbility ability = animaXContext.getAbility();
        this.mAbility = ability;
        ability.initAnimaXPlayer(this);
        init();
    }

    private boolean init() {
        if (!DeviceUtil.checkCapability(this.mAbility)) {
            this.mAbility.sendEventOnUI(Event.ERROR.ordinal(), AnimaXError.createBlockErrorParam());
            return false;
        }
        Context context = this.mAnimaXContext.getContext();
        if (context == null) {
            AnimaXLog.m2540e(TAG, "init fail, context is null");
            return false;
        }
        if (!AnimaX.inst().hasInitialized()) {
            AnimaX.inst().forceInit();
        }
        if (!AnimaX.inst().hasInitialized()) {
            AnimaXLog.m2540e(TAG, "init fail, AnimaX.inst().forceInit() fail");
            this.mAbility.sendEventOnUI(Event.ERROR.ordinal(), AnimaXError.createThreadInitErrorParam());
            return false;
        }
        AnimaX.inst().setAppContextIfUnset(context.getApplicationContext());
        float f = context.getResources().getDisplayMetrics().density;
        DeviceUtil.initDeviceLowDensity(f);
        AnimaXResourceLoaderHolder animaXResourceLoaderHolder = new AnimaXResourceLoaderHolder((IAnimaXResourceFactoryService) this.mAbility.getService(IAnimaXResourceFactoryService.class));
        this.mResourceLoaderHolder = animaXResourceLoaderHolder;
        this.mPtr = nativeCreate(f, this.mAbility, animaXResourceLoaderHolder.getNativePtr(), this.mAnimaXContext.multiThreadAccelerate().booleanValue(), DeviceUtil.needSkipCountDownEvent(this.mAbility));
        this.mCleanUpReference = new CleanupReference(this, new CleanupOnUiThread(this.mPtr), true);
        if (!hasInitialized()) {
            AnimaXLog.m2540e(TAG, "init fail");
            return false;
        }
        setUpInitialProperties();
        return true;
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    public AnimaXContext getAnimaXContext() {
        return this.mAnimaXContext;
    }

    private void setUpInitialProperties() {
        Context context = this.mAnimaXContext.getContext();
        if (context == null) {
            return;
        }
        if (DeviceUtil.needLimitFrameRate()) {
            AnimaXLog.m2541i(TAG, "Limit frame rate to 30.");
            setMaxFrameRate(30.0d);
        }
        if (DeviceUtil.useSoftwareRender(context, this.mAbility)) {
            AnimaXLog.m2541i(TAG, "useSoftwareRender");
            enableSoftwareRender(true);
        }
    }

    private void updateSurfaceProperties(AnimaXSurfaceDrawable animaXSurfaceDrawable) {
        if (animaXSurfaceDrawable != null) {
            animaXSurfaceDrawable.setEnableAntiAliasing(this.mEnableAntiAliasing);
            animaXSurfaceDrawable.setEnableSoftwareRender(this.mEnableSoftwareRender);
            animaXSurfaceDrawable.setEnableAutoDestroyEGLContext(DeviceUtil.needAutoDestroyEGLContext());
            animaXSurfaceDrawable.setPlatformSurfaceInitiallyInvalid(this.mIsPlatformSurfaceInitiallyInvalid);
        }
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    public void enableSoftwareRender(boolean z) {
        this.mEnableSoftwareRender = z;
    }

    private boolean hasInitialized() {
        return this.mPtr != 0;
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    public void release() {
        if (checkNativeReady()) {
            this.mAbility.release();
            this.mCleanUpReference.cleanupNow();
            AnimaXResourceLoaderHolder animaXResourceLoaderHolder = this.mResourceLoaderHolder;
            if (animaXResourceLoaderHolder != null) {
                animaXResourceLoaderHolder.release();
                this.mResourceLoaderHolder = null;
            }
            this.mHasDestroyed = true;
            this.mPtr = 0L;
            AnimaXLog.m2541i(TAG, "AnimaXPlayer destroyed");
        }
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    public void createAnimaXSurface(AnimaXSurfaceDrawable animaXSurfaceDrawable) {
        if (checkNativeReady()) {
            updateSurfaceProperties(animaXSurfaceDrawable);
            nativeCreateAnimaXSurface(this.mPtr, animaXSurfaceDrawable);
        }
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    public void updateAnimaXSurface(AnimaXSurfaceDrawable animaXSurfaceDrawable) {
        if (checkNativeReady()) {
            updateSurfaceProperties(animaXSurfaceDrawable);
            nativeUpdateAnimaXSurface(this.mPtr, animaXSurfaceDrawable);
        }
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    public void markPlatformSurfaceAsInvalid(boolean z) {
        this.mIsPlatformSurfaceInitiallyInvalid = z;
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    public void setAutoPlay(boolean z) {
        if (checkNativeReady()) {
            nativeSetAutoPlay(this.mPtr, z);
            this.mAutoPlay = z;
        }
    }

    public boolean isAutoPlay() {
        return this.mAutoPlay;
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    public void setSpeed(float f) {
        if (checkNativeReady()) {
            nativeSetSpeed(this.mPtr, f);
        }
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    public void setProgress(float f) {
        if (checkNativeReady()) {
            nativeSetProgress(this.mPtr, f);
        }
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    public void setKeepLastFrame(boolean z) {
        if (checkNativeReady()) {
            nativeSetKeepLastFrame(this.mPtr, z);
        }
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    public void setJson(String str) {
        if (checkNativeReady()) {
            nativeSetJson(this.mPtr, str);
            this.mAbility.getMonitorDelegate().updateUrl("json");
        }
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    public void setLoop(boolean z) {
        if (checkNativeReady()) {
            nativeSetLoop(this.mPtr, z);
        }
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    public void setLoopCount(int i) {
        if (checkNativeReady()) {
            nativeSetLoopCount(this.mPtr, i);
        }
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    public void setFpsEventInterval(long j) {
        if (checkNativeReady()) {
            nativeSetFpsEventInterval(this.mPtr, j);
        }
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    public void setDynamicResource(boolean z) {
        if (checkNativeReady()) {
            nativeSetDynamicResource(this.mPtr, z);
        }
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    public void setSrc(String str) {
        if (checkNativeReady()) {
            nativeSetSrc(this.mPtr, str);
            this.mAbility.getMonitorDelegate().updateUrl(str);
        }
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    public void setComposition(AnimaXComposition animaXComposition) {
        this.mAnimaXComposition = animaXComposition;
        if (checkNativeReady()) {
            nativeSetComposition(this.mPtr, animaXComposition.getNativePtr());
        }
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    public AnimaXComposition getComposition() {
        return this.mAnimaXComposition;
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    public void setImageFolder(String str) {
        if (str == null || str.isEmpty() || !checkNativeReady()) {
            return;
        }
        nativeSetImageFolder(this.mPtr, str);
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    public void setStartFrame(int i) {
        if (checkNativeReady()) {
            nativeSetStartFrame(this.mPtr, i);
        }
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    public void setEndFrame(int i) {
        if (checkNativeReady()) {
            nativeSetEndFrame(this.mPtr, i);
        }
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    public void setAutoReverse(boolean z) {
        if (checkNativeReady()) {
            nativeSetAutoReverse(this.mPtr, z);
        }
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    public void setMaxFrameRate(double d) {
        if (checkNativeReady()) {
            nativeSetMaxFrameRate(this.mPtr, d);
        }
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    public void setAntiAliasing(boolean z) {
        this.mEnableAntiAliasing = z;
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    public void play() {
        if (checkNativeReady()) {
            this.mAbility.getMonitorDelegate().onPlay();
            nativePlay(this.mPtr);
        }
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    public void pause() {
        if (checkNativeReady()) {
            nativePause(this.mPtr);
        }
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    public void resume() {
        if (checkNativeReady()) {
            this.mAbility.getMonitorDelegate().onResume();
            nativeResume(this.mPtr);
        }
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    public void stop() {
        if (checkNativeReady()) {
            nativeStop(this.mPtr);
        }
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    public double getDurationMs() {
        if (checkNativeReady()) {
            return nativeGetDurationMs(this.mPtr);
        }
        return 0.0d;
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    public boolean isAnimating() {
        if (checkNativeReady()) {
            return nativeIsAnimating(this.mPtr);
        }
        return false;
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    public void seek(int i) {
        if (checkNativeReady()) {
            nativeSeek(this.mPtr, i);
        }
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    public double getCurrentFrame() {
        if (checkNativeReady()) {
            return nativeGetCurrentFrame(this.mPtr);
        }
        return 0.0d;
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    public void playSegment(int i, int i2) {
        if (checkNativeReady()) {
            this.mAbility.getMonitorDelegate().onPlaySegment();
            nativePlaySegment(this.mPtr, i, i2);
        }
    }

    private boolean checkNativeReady() {
        if (this.mHasDestroyed) {
            return false;
        }
        boolean hasInitialized = hasInitialized();
        if (!hasInitialized) {
            AnimaXLog.m2540e(TAG, "checkNativeReady failed, ptr is 0");
        }
        return hasInitialized;
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    public void onShow(VisibilityState visibilityState) {
        if (checkNativeReady()) {
            nativeOnShow(this.mPtr, visibilityState.getValue());
        }
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    public void onHide(VisibilityState visibilityState) {
        if (checkNativeReady()) {
            nativeOnHide(this.mPtr, visibilityState.getValue());
        }
    }

    private boolean updateVisibilityFlagIfChanged(boolean z, VisibilityState visibilityState) {
        if (z == ((this.mVisibilityFlag & visibilityState.getValue()) == 0)) {
            return false;
        }
        this.mVisibilityFlag ^= visibilityState.getValue();
        return true;
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    public void updateVisibilityState(boolean z, VisibilityState visibilityState) {
        if (updateVisibilityFlagIfChanged(z, visibilityState)) {
            if (z) {
                onShow(visibilityState);
            } else {
                onHide(visibilityState);
            }
        }
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    public void enterForeground() {
        updateVisibilityState(true, VisibilityState.BACKGROUND);
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    public void enterBackground() {
        updateVisibilityState(false, VisibilityState.BACKGROUND);
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    public void cancel() {
        if (checkNativeReady()) {
            nativeCancel(this.mPtr);
        }
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    public void setObjectFit(ObjectFit objectFit) {
        if (checkNativeReady()) {
            nativeSetObjectFit(this.mPtr, objectFit.ordinal());
        }
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    public void setObjectPosition(ObjectPosition objectPosition) {
        if (checkNativeReady()) {
            nativeSetObjectPosition(this.mPtr, objectPosition.ordinal());
        }
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    public void setSrcPolyfill(JavaOnlyMap javaOnlyMap) {
        if (checkNativeReady()) {
            nativeSetSrcPolyfill(this.mPtr, javaOnlyMap);
        }
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    public void subscribeUpdateEvent(int i) {
        if (checkNativeReady()) {
            nativeSubscribeUpdateEvent(this.mPtr, i);
        }
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    public void unsubscribeUpdateEvent(int i) {
        if (checkNativeReady()) {
            nativeUnsubscribeUpdateEvent(this.mPtr, i);
        }
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    public void subscribeUpdateEvents(int[] iArr, boolean z) {
        if (checkNativeReady()) {
            nativeSubscribeUpdateEvents(this.mPtr, iArr, z);
        }
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    public void addAnimationListener(IAnimationListener iAnimationListener) {
        this.mAbility.addAnimationListener(iAnimationListener);
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    public void removeAnimationListener(IAnimationListener iAnimationListener) {
        this.mAbility.removeAnimationListener(iAnimationListener);
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    public void onTap(float f, float f2) {
        if (checkNativeReady()) {
            nativeOnTap(this.mPtr, f, f2);
        }
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    public void reload() {
        if (checkNativeReady()) {
            nativeReload(this.mPtr);
        }
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    public void updateLayerProperty(LayerPropertyType layerPropertyType, AnimaXKeyPath animaXKeyPath, AnimaXValueParam animaXValueParam, AnimaXPropertyCallback animaXPropertyCallback) {
        if (checkNativeReady()) {
            nativeUpdateLayerProperty(this.mPtr, layerPropertyType.getValue(), animaXKeyPath, animaXValueParam, animaXPropertyCallback);
        }
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    public void addLayerPropertyCallback(LayerPropertyType layerPropertyType, AnimaXKeyPath animaXKeyPath, AnimaXValueCallback animaXValueCallback, AnimaXPropertyCallback animaXPropertyCallback) {
        if (checkNativeReady()) {
            nativeAddLayerPropertyCallback(this.mPtr, layerPropertyType.getValue(), animaXKeyPath, animaXValueCallback, animaXPropertyCallback);
        }
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    public void removeLayerPropertyCallback(LayerPropertyType layerPropertyType, AnimaXKeyPath animaXKeyPath, AnimaXPropertyCallback animaXPropertyCallback) {
        if (checkNativeReady()) {
            nativeAddLayerPropertyCallback(this.mPtr, layerPropertyType.getValue(), animaXKeyPath, null, animaXPropertyCallback);
        }
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    public void setResourceProperty(ResourcePropertyType resourcePropertyType, String str, AnimaXValueParam animaXValueParam, AnimaXPropertyCallback animaXPropertyCallback) {
        if (checkNativeReady()) {
            nativeSetResourceProperty(this.mPtr, resourcePropertyType.getValue(), str, animaXValueParam, animaXPropertyCallback);
        }
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    public void getKeysForKeyPath(AnimaXKeyPath animaXKeyPath, AnimaXKeyPathListCallback animaXKeyPathListCallback) {
        if (checkNativeReady()) {
            nativeGetKeysForKeyPath(this.mPtr, animaXKeyPath, animaXKeyPathListCallback);
        }
    }

    @Override // com.lynx.animax.p034ui.IAnimaXPlayer
    public void getMetricsAsync(AnimaXMetricsCallback animaXMetricsCallback) {
        if (checkNativeReady()) {
            nativeGetMetricsAsync(this.mPtr, animaXMetricsCallback);
        }
    }
}
