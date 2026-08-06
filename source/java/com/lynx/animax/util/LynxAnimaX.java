package com.lynx.animax.util;

import com.lynx.animax.UIAnimaX;
import com.lynx.animax.service.AnimaXFrescoImageService;
import com.lynx.animax.service.AnimaXServiceCenter;
import com.lynx.animax.service.IAnimaXImageService;
import com.lynx.animax.service.IAnimaXSettingService;
import com.lynx.animax.service.ServiceScope;
import com.lynx.animax.setting.LynxAnimaXSettingService;
import com.lynx.tasm.INativeLibraryLoader;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.LynxUI;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class LynxAnimaX {
    private static final String TAG = "LynxAnimaX";
    private static volatile LynxAnimaX sInstance;
    private ServiceScope mScope = ServiceScope.m2536of(TAG);
    private volatile boolean mHasLibInit = false;

    private LynxAnimaX() {
    }

    public static LynxAnimaX inst() {
        if (sInstance == null) {
            synchronized (LynxAnimaX.class) {
                if (sInstance == null) {
                    sInstance = new LynxAnimaX();
                }
            }
        }
        return sInstance;
    }

    public void init() {
        init(null);
    }

    public void init(INativeLibraryLoader iNativeLibraryLoader) {
        if (hasInitialized()) {
            return;
        }
        initWithLock(iNativeLibraryLoader);
    }

    private synchronized void initWithLock(final INativeLibraryLoader iNativeLibraryLoader) {
        if (!AnimaX.inst().hasInitialized()) {
            AnimaX.inst().init(iNativeLibraryLoader == null ? null : new com.lynx.animax.base.INativeLibraryLoader() { // from class: com.lynx.animax.util.LynxAnimaX.1
                @Override // com.lynx.animax.base.INativeLibraryLoader
                public void loadLibrary(String str) throws UnsatisfiedLinkError {
                    iNativeLibraryLoader.loadLibrary(str);
                }
            });
        }
        if (!this.mHasLibInit) {
            if (!AnimaX.inst().loadLibrary("animax_napi")) {
                return;
            }
            createGlobalServices();
            this.mHasLibInit = true;
        }
    }

    public boolean hasInitialized() {
        return AnimaX.inst().hasInitialized() && this.mHasLibInit;
    }

    public LynxUI createUI(LynxContext lynxContext) {
        try {
            init();
            return new UIAnimaX(lynxContext);
        } catch (Throwable th) {
            AnimaXLog.m2540e(TAG, "animax ui init error" + th.toString());
            return null;
        }
    }

    public ServiceScope getScope() {
        return this.mScope;
    }

    private void createGlobalServices() {
        AnimaXServiceCenter.inst().registerService(this.mScope, IAnimaXSettingService.class, new LynxAnimaXSettingService());
        AnimaXServiceCenter.inst().registerService(this.mScope, IAnimaXImageService.class, new AnimaXFrescoImageService());
    }
}
