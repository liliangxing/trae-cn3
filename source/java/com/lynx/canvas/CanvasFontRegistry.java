package com.lynx.canvas;

import android.content.res.AssetManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes6.dex */
public class CanvasFontRegistry {
    private static final String TAG = "CanvasFontRegistry";
    private static volatile CanvasFontRegistry mInstance;
    private final ArrayList<FontInfo> mFontInfoCache = new ArrayList<>();
    private boolean mNativeReady = false;
    private final HashSet<KryptonFontLazyProvider> mFontLazyProviders = new HashSet<>();

    private native void nativeOnRegisterFontLazyProvider();

    private native boolean nativeRegisterFont(String str, String str2, int i, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class FontInfo {
        public String familyName;
        public String localUrl;
        public int style;
        public int weight;

        private FontInfo() {
        }
    }

    public static CanvasFontRegistry GetInstance() {
        if (mInstance == null) {
            synchronized (CanvasFontRegistry.class) {
                if (mInstance == null) {
                    mInstance = new CanvasFontRegistry();
                }
            }
        }
        return mInstance;
    }

    public boolean registerFont(String str, String str2, int i, int i2) {
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0 || i < 0 || i2 < 0) {
            KryptonLLog.e(TAG, "registerFont " + str + " param error");
            return false;
        }
        KryptonLLog.i(TAG, "registerFont " + str);
        synchronized (this) {
            if (this.mNativeReady) {
                return nativeRegisterFont(str, str2, i, i2);
            }
            FontInfo fontInfo = new FontInfo();
            fontInfo.familyName = str;
            fontInfo.localUrl = str2;
            fontInfo.weight = i;
            fontInfo.style = i2;
            this.mFontInfoCache.add(fontInfo);
            return true;
        }
    }

    public void registerFontLazyProvider(KryptonFontLazyProvider kryptonFontLazyProvider) {
        if (kryptonFontLazyProvider == null) {
            return;
        }
        synchronized (this) {
            this.mFontLazyProviders.add(kryptonFontLazyProvider);
            KryptonLLog.i(TAG, "register font lazy provider");
            if (this.mNativeReady) {
                nativeOnRegisterFontLazyProvider();
            }
        }
    }

    HashSet<KryptonFontLazyProvider> copyLazyProviders() {
        HashSet<KryptonFontLazyProvider> hashSet;
        synchronized (this) {
            hashSet = new HashSet<>(this.mFontLazyProviders);
        }
        return hashSet;
    }

    static String getLocalFontUrlFromPlatformProvider(String str, int i, int i2) {
        Iterator<KryptonFontLazyProvider> it = GetInstance().copyLazyProviders().iterator();
        while (it.hasNext()) {
            String localFontUrlByFamilyName = it.next().getLocalFontUrlByFamilyName(str, i, i2);
            if (localFontUrlByFamilyName != null && localFontUrlByFamilyName.length() > 0) {
                KryptonLLog.i(TAG, "getLocalFontUrlByFamilyName " + str + " success " + localFontUrlByFamilyName);
                return localFontUrlByFamilyName;
            }
        }
        KryptonLLog.i(TAG, "getLocalFontUrlByFamilyName " + str + " not found ");
        return "";
    }

    private void syncFontCacheOnNativeReady() {
        synchronized (this) {
            if (this.mNativeReady) {
                return;
            }
            this.mNativeReady = true;
            Iterator<FontInfo> it = this.mFontInfoCache.iterator();
            while (it.hasNext()) {
                FontInfo next = it.next();
                nativeRegisterFont(next.familyName, next.localUrl, next.weight, next.style);
            }
            this.mFontInfoCache.clear();
            if (this.mFontLazyProviders.size() > 0) {
                nativeOnRegisterFontLazyProvider();
            }
        }
    }

    private static AssetManager getAssetManager() {
        Krypton inst = Krypton.inst();
        try {
            if (inst.hasInitialized()) {
                return inst.getContext().getAssets();
            }
            return null;
        } catch (Throwable th) {
            KryptonLLog.i(TAG, "getAssetManager error " + th.toString());
            return null;
        }
    }

    public static void onNativeReady() {
        GetInstance().syncFontCacheOnNativeReady();
    }

    public static void onNativeFirstUseComplexLayout() {
        Krypton.inst().loadLibrary("kryptoni18n", true);
    }
}
