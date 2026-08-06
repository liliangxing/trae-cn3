package com.lynx.animax.composition;

import com.lynx.animax.loader.AnimaXResourceLoaderHolder;
import com.lynx.animax.service.ServiceScope;
import com.lynx.animax.util.AnimaX;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class AnimaXCompositionFactory {
    private static final String TAG = "AnimaXCompositionFactory";
    private static AnimaXCompositionFactory sInstance;
    private final Map<ServiceScope, AnimaXResourceLoaderHolder> mLoaderMap = new ConcurrentHashMap();

    private native void nativeCreate(String str, long j);

    private native void nativeLoadJson(String str, String str2, float f, AnimaXCompositionNativeCallback animaXCompositionNativeCallback);

    private native void nativeLoadUri(String str, String str2, float f, AnimaXCompositionNativeCallback animaXCompositionNativeCallback);

    private native void nativeRelease();

    private AnimaXCompositionFactory() {
    }

    public static AnimaXCompositionFactory inst() {
        if (sInstance == null) {
            synchronized (AnimaXCompositionFactory.class) {
                if (sInstance == null) {
                    sInstance = new AnimaXCompositionFactory();
                }
            }
        }
        return sInstance;
    }

    public void loadJson(ServiceScope serviceScope, String str, AnimaXCompositionListener animaXCompositionListener) {
        ensureLoader(serviceScope);
        try {
            nativeLoadJson(serviceScope.toString(), str, AnimaX.inst().getDensity(), new AnimaXCompositionNativeCallback(animaXCompositionListener));
        } catch (Exception e) {
            animaXCompositionListener.onCompositionFailed("loadJson fail, message:" + e.getMessage());
        }
    }

    public void loadJson(String str, AnimaXCompositionListener animaXCompositionListener) {
        loadJson(ServiceScope.DEFAULT, str, animaXCompositionListener);
    }

    public void loadUri(ServiceScope serviceScope, String str, AnimaXCompositionListener animaXCompositionListener) {
        ensureLoader(serviceScope);
        try {
            nativeLoadUri(serviceScope.toString(), str, AnimaX.inst().getDensity(), new AnimaXCompositionNativeCallback(animaXCompositionListener));
        } catch (Exception e) {
            animaXCompositionListener.onCompositionFailed("loadUri fail, message:" + e.getMessage());
        }
    }

    public void loadUri(String str, AnimaXCompositionListener animaXCompositionListener) {
        loadUri(ServiceScope.DEFAULT, str, animaXCompositionListener);
    }

    public void release() {
        Iterator<Map.Entry<ServiceScope, AnimaXResourceLoaderHolder>> it = this.mLoaderMap.entrySet().iterator();
        while (it.hasNext()) {
            AnimaXResourceLoaderHolder value = it.next().getValue();
            if (value != null) {
                value.release();
            }
        }
        this.mLoaderMap.clear();
        nativeRelease();
    }

    private void ensureLoader(ServiceScope serviceScope) {
        if (this.mLoaderMap.get(serviceScope) == null) {
            AnimaXResourceLoaderHolder animaXResourceLoaderHolder = new AnimaXResourceLoaderHolder(serviceScope);
            nativeCreate(serviceScope.toString(), animaXResourceLoaderHolder.getNativePtr());
            this.mLoaderMap.put(serviceScope, animaXResourceLoaderHolder);
        }
    }
}
