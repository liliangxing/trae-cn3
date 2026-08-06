package com.lynx.animax.loader;

import com.lynx.animax.base.CleanupReference;
import com.lynx.animax.service.AnimaXServiceCenter;
import com.lynx.animax.service.IAnimaXResourceFactoryService;
import com.lynx.animax.service.ServiceScope;
import com.lynx.animax.util.AnimaXLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class AnimaXResourceLoaderHolder {
    private static final String TAG = "AnimaXResourceLoaderHolder";
    private final List<AnimaXLoader> mAnimaXLoaders;
    private CleanupReference mCleanUpReference;
    private long mResourceLoaderHolderPtr;

    private static native long nativeCreate();

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeDestroy(long j);

    private static native void nativeRegisterLoaderForScheme(long j, AnimaXLoader animaXLoader, int i);

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    private static class CleanupOnUiThread implements Runnable {
        private long mNativePtr;

        public CleanupOnUiThread(long j) {
            this.mNativePtr = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mNativePtr == 0) {
                return;
            }
            AnimaXLog.m2541i(AnimaXResourceLoaderHolder.TAG, "Call nativeDestroy.");
            AnimaXResourceLoaderHolder.nativeDestroy(this.mNativePtr);
            this.mNativePtr = 0L;
        }
    }

    public AnimaXResourceLoaderHolder(ServiceScope serviceScope) {
        this((IAnimaXResourceFactoryService) AnimaXServiceCenter.inst().getService(serviceScope, IAnimaXResourceFactoryService.class));
    }

    public AnimaXResourceLoaderHolder(IAnimaXResourceFactoryService iAnimaXResourceFactoryService) {
        this.mAnimaXLoaders = new ArrayList();
        this.mCleanUpReference = null;
        this.mResourceLoaderHolderPtr = nativeCreate();
        this.mCleanUpReference = new CleanupReference(this, new CleanupOnUiThread(this.mResourceLoaderHolderPtr), true);
        registerLoaderForScheme(new AnimaXAssetLoader());
        registerLoaderForScheme(new AnimaXFileLoader());
        registerLoaderForScheme(new AnimaXBase64Loader());
        registerLoadersByFactory(iAnimaXResourceFactoryService);
    }

    private void registerLoadersByFactory(IAnimaXResourceFactoryService iAnimaXResourceFactoryService) {
        if (iAnimaXResourceFactoryService == null) {
            AnimaXLog.m2540e(TAG, "resourceFactory is null");
            return;
        }
        List<IAnimaXLoader> createAnimaXLoaders = iAnimaXResourceFactoryService.createAnimaXLoaders();
        if (createAnimaXLoaders == null) {
            AnimaXLog.m2540e(TAG, "loaders is null");
            return;
        }
        Iterator<IAnimaXLoader> it = createAnimaXLoaders.iterator();
        while (it.hasNext()) {
            registerLoaderForScheme(it.next());
        }
    }

    public void release() {
        this.mAnimaXLoaders.clear();
        this.mCleanUpReference.cleanupNow();
        this.mResourceLoaderHolderPtr = 0L;
    }

    private void registerLoaderForScheme(IAnimaXLoader iAnimaXLoader) {
        AnimaXLoader create = AnimaXLoader.create(iAnimaXLoader);
        this.mAnimaXLoaders.add(create);
        nativeRegisterLoaderForScheme(this.mResourceLoaderHolderPtr, create, iAnimaXLoader.getScheme().ordinal());
    }

    public long getNativePtr() {
        return this.mResourceLoaderHolderPtr;
    }
}
