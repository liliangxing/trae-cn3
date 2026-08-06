package com.lynx.tasm.icu;

import com.lynx.tasm.INativeLibraryLoader;
import com.lynx.tasm.service.ILynxI18nService;
import com.lynx.tasm.service.LynxServiceCenter;

/* loaded from: classes7.dex */
public class ICURegister {
    private static volatile boolean mLibraryLoaded;

    public static synchronized void loadLibrary(INativeLibraryLoader iNativeLibraryLoader) {
        synchronized (ICURegister.class) {
            if (mLibraryLoaded) {
                return;
            }
            ILynxI18nService iLynxI18nService = (ILynxI18nService) LynxServiceCenter.inst().getService(ILynxI18nService.class);
            if (iLynxI18nService != null) {
                mLibraryLoaded = iLynxI18nService.loadLibrary(iNativeLibraryLoader);
            }
        }
    }

    private static synchronized boolean register(long j) {
        ILynxI18nService iLynxI18nService;
        synchronized (ICURegister.class) {
            if (!mLibraryLoaded || (iLynxI18nService = (ILynxI18nService) LynxServiceCenter.inst().getService(ILynxI18nService.class)) == null) {
                return false;
            }
            return iLynxI18nService.registerNapiEnv(j);
        }
    }
}
