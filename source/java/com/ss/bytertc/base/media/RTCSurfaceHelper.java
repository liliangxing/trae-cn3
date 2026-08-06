package com.ss.bytertc.base.media;

import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes7.dex */
public class RTCSurfaceHelper {
    Long mSurfaceHelperHandle;
    ConcurrentHashMap<String, Object> mSurfaceCallbackMap = new ConcurrentHashMap<>();
    ConcurrentHashMap<String, Object> mViewMap = new ConcurrentHashMap<>();
    final Object mSurfaceCallbackMapLock = new Object();

    public static native void nativeSetRenderTarget(long nativeSurfaceHelperHandle, Surface renderTarget, String key, boolean needCallback);

    public static boolean checkIsOnMainThread() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    public RTCSurfaceHelper(long nativeHandle) {
        this.mSurfaceHelperHandle = 0L;
        this.mSurfaceHelperHandle = Long.valueOf(nativeHandle);
    }

    void registerRenderTargetView(View renderTargetView, String key) {
        synchronized (this.mSurfaceCallbackMapLock) {
            boolean z = false;
            if (this.mSurfaceCallbackMap.containsKey(key)) {
                unRegisterRenderTargetView(key, false);
            }
            if (!this.mViewMap.containsKey(key) || this.mViewMap.get(key) != renderTargetView) {
                z = true;
            }
            Object registerSurfaceCallback = registerSurfaceCallback(renderTargetView, key, z);
            if (registerSurfaceCallback != null) {
                this.mSurfaceCallbackMap.put(key, registerSurfaceCallback);
            }
            this.mViewMap.put(key, renderTargetView);
        }
    }

    void unRegisterRenderTargetView(String key, boolean reset) {
        synchronized (this.mSurfaceCallbackMapLock) {
            if (this.mSurfaceCallbackMap.containsKey(key)) {
                unRegisterSurfaceCallback(this.mSurfaceCallbackMap.get(key));
                this.mSurfaceCallbackMap.remove(key);
            }
            if (reset && this.mViewMap.containsKey(key)) {
                this.mViewMap.remove(key);
            }
        }
    }

    void destroy() {
        synchronized (this.mSurfaceCallbackMapLock) {
            Iterator<Object> it = this.mSurfaceCallbackMap.values().iterator();
            while (it.hasNext()) {
                unRegisterSurfaceCallback(it.next());
            }
            this.mSurfaceCallbackMap.clear();
            this.mViewMap.clear();
        }
    }

    private Object registerSurfaceCallback(Object renderTargetView, String key, boolean needCallback) {
        if (renderTargetView instanceof SurfaceView) {
            SurfaceView surfaceView = (SurfaceView) renderTargetView;
            RTCSurfaceViewListener rTCSurfaceViewListener = new RTCSurfaceViewListener(surfaceView, this.mSurfaceHelperHandle.longValue(), key, needCallback);
            surfaceView.getHolder().addCallback(rTCSurfaceViewListener);
            return rTCSurfaceViewListener;
        }
        if (!(renderTargetView instanceof TextureView)) {
            return null;
        }
        TextureView textureView = (TextureView) renderTargetView;
        RTCSurfaceTextureListener rTCSurfaceTextureListener = new RTCSurfaceTextureListener(textureView, this.mSurfaceHelperHandle.longValue(), key, needCallback);
        textureView.setSurfaceTextureListener(rTCSurfaceTextureListener);
        return rTCSurfaceTextureListener;
    }

    private void unRegisterSurfaceCallback(Object surfaceListener) {
        if (surfaceListener instanceof RTCSurfaceTextureListener) {
            ((RTCSurfaceTextureListener) surfaceListener).resetCallback();
        } else if (surfaceListener instanceof RTCSurfaceViewListener) {
            ((RTCSurfaceViewListener) surfaceListener).resetCallback();
        }
    }
}
