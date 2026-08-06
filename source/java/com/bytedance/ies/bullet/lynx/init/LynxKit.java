package com.bytedance.ies.bullet.lynx.init;

import android.graphics.Typeface;
import com.bytedance.crash.AttachUserData;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.Npth;
import com.bytedance.ies.bullet.lynx.util.FontCacheHelper;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.BulletSettings;
import com.bytedance.ies.bullet.service.base.ISettingService;
import com.bytedance.ies.bullet.service.base.api.IServiceToken;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.behavior.shadow.text.TypefaceCache;
import com.lynx.tasm.loader.LynxFontFaceLoader;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LynxKit.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0014\u001a\u00020\rJ\u0006\u0010\u0015\u001a\u00020\u0011J\u0006\u0010\u0016\u001a\u00020\rJ\u0006\u0010\u0017\u001a\u00020\rJ\b\u0010\u0018\u001a\u00020\u0011H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ies/bullet/lynx/init/LynxKit;", "", "()V", "TAG", "", "emptyTypeface", "Landroid/graphics/Typeface;", "kotlin.jvm.PlatformType", "fontFaceLoader", "Lcom/lynx/tasm/loader/LynxFontFaceLoader$Loader;", "initLock", "Ljava/util/concurrent/atomic/AtomicBoolean;", "initedFlag", "", "token", "Lcom/bytedance/ies/bullet/service/base/api/IServiceToken;", EventConstants.PARAM_SOURCE_INIT, "", "lynxConfig", "Lcom/bytedance/ies/bullet/lynx/init/LynxConfig;", "force", "initVmSdk", "isVmSdkReady", "ready", "setFontLoader", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class LynxKit {
    public static final String TAG = "LynxKit";
    private static LynxFontFaceLoader.Loader fontFaceLoader;
    private static boolean initedFlag;
    private static IServiceToken token;
    public static final LynxKit INSTANCE = new LynxKit();
    private static final AtomicBoolean initLock = new AtomicBoolean(false);
    private static final Typeface emptyTypeface = Typeface.DEFAULT;

    private LynxKit() {
    }

    public static /* synthetic */ void init$default(LynxKit lynxKit, LynxConfig lynxConfig, IServiceToken iServiceToken, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        lynxKit.init(lynxConfig, iServiceToken, z);
    }

    public final void init(LynxConfig lynxConfig, IServiceToken token2, boolean force) {
        Intrinsics.checkNotNullParameter(lynxConfig, "lynxConfig");
        Intrinsics.checkNotNullParameter(token2, "token");
        if (!force && initedFlag && !initLock.compareAndSet(false, true)) {
            BulletLogger.INSTANCE.printLog("LynxKit has init", LogLevel.I, "XLynxKit");
            return;
        }
        token = token2;
        try {
            setFontLoader();
            LynxKitEnv.INSTANCE.init(lynxConfig, token2);
            if (!LynxEnv.inst().isNativeLibraryLoaded()) {
                initLock.set(false);
                throw new RuntimeException("Lynx so Init Failed");
            }
            initedFlag = true;
            LynxSdkMonitor.initSDKMonitor(LynxKitBase.INSTANCE.getContext(), token2.getServiceContext().getIsDebug(), lynxConfig.lynxSdkMonitorConfig());
            Npth.addAttachUserData(new AttachUserData() { // from class: com.bytedance.ies.bullet.lynx.init.LynxKit$init$1
                public final Map<? extends String, ? extends String> getUserData(CrashType crashType) {
                    HashMap hashMap = new HashMap();
                    String lastUrl = LynxEnv.inst().getLastUrl();
                    if (lastUrl == null) {
                        lastUrl = "no lynx url";
                    }
                    hashMap.put("last_lynx_url", lastUrl);
                    String lynxVersion = LynxEnv.inst().getLynxVersion();
                    Intrinsics.checkNotNullExpressionValue(lynxVersion, "inst().lynxVersion");
                    hashMap.put("lynx_sdk_version", lynxVersion);
                    return hashMap;
                }
            }, CrashType.ALL);
        } catch (Throwable th) {
            initLock.set(false);
            BulletLogger.INSTANCE.printReject(th, "LynxKit Init Failed", "XLynxKit");
        }
    }

    public final boolean ready() {
        return initedFlag;
    }

    private final void setFontLoader() {
        BulletSettings provideBulletSettings;
        IServiceToken iServiceToken = token;
        if (iServiceToken == null) {
            Intrinsics.throwUninitializedPropertyAccessException("token");
            iServiceToken = null;
        }
        ISettingService iSettingService = (ISettingService) iServiceToken.getService(ISettingService.class);
        final boolean enableLynxFontCache = (iSettingService == null || (provideBulletSettings = iSettingService.provideBulletSettings()) == null) ? true : provideBulletSettings.getEnableLynxFontCache();
        LynxKit$setFontLoader$1 lynxKit$setFontLoader$1 = new LynxKit$setFontLoader$1(enableLynxFontCache);
        fontFaceLoader = lynxKit$setFontLoader$1;
        LynxFontFaceLoader.setLoader(lynxKit$setFontLoader$1);
        TypefaceCache.addLazyProvider(new TypefaceCache.LazyProvider() { // from class: com.bytedance.ies.bullet.lynx.init.LynxKit$setFontLoader$2
            public final Typeface getTypeface(String str, int i) {
                Typeface typeface;
                Typeface typeface2;
                if (enableLynxFontCache) {
                    String str2 = str + '_' + i;
                    if (!FontCacheHelper.INSTANCE.findFontCache(str2)) {
                        Typeface typefaceFromAssets = LynxKitBase.INSTANCE.isContextInitialized() ? TypefaceCache.getTypefaceFromAssets(LynxKitBase.INSTANCE.getContext().getAssets(), str, i, "font/") : null;
                        BulletLogger.INSTANCE.printLog("get typeface from assets, key=" + str2 + ", typeface is null = " + (typefaceFromAssets == null), LogLevel.I, "XLynxKit");
                        FontCacheHelper fontCacheHelper = FontCacheHelper.INSTANCE;
                        if (typefaceFromAssets == null) {
                            typefaceFromAssets = LynxKit.emptyTypeface;
                        }
                        Intrinsics.checkNotNullExpressionValue(typefaceFromAssets, "typeface ?: emptyTypeface");
                        fontCacheHelper.setFontCache(str2, typefaceFromAssets);
                    }
                    BulletLogger bulletLogger = BulletLogger.INSTANCE;
                    StringBuilder append = new StringBuilder("return typeface with cache, key=").append(str2).append(", typeface is null = ");
                    Typeface fontCache = FontCacheHelper.INSTANCE.getFontCache(str2);
                    typeface = LynxKit.emptyTypeface;
                    bulletLogger.printLog(append.append(Intrinsics.areEqual(fontCache, typeface)).toString(), LogLevel.I, "XLynxKit");
                    Typeface fontCache2 = FontCacheHelper.INSTANCE.getFontCache(str2);
                    typeface2 = LynxKit.emptyTypeface;
                    if (Intrinsics.areEqual(fontCache2, typeface2)) {
                        return null;
                    }
                    return FontCacheHelper.INSTANCE.getFontCache(str2);
                }
                if (LynxKitBase.INSTANCE.isContextInitialized()) {
                    Typeface typefaceFromAssets2 = TypefaceCache.getTypefaceFromAssets(LynxKitBase.INSTANCE.getContext().getAssets(), str, i, "font/");
                    BulletLogger.INSTANCE.printLog("return typeface without cache,  fontFamilyName=" + str + ", typeface is null = " + (typefaceFromAssets2 == null), LogLevel.I, "XLynxKit");
                    return typefaceFromAssets2;
                }
                BulletLogger.INSTANCE.printLog("return typeface without cache,  fontFamilyName=" + str + ", LynxKitBase.isContextInitialized() = false", LogLevel.I, "XLynxKit");
                return null;
            }
        });
    }

    public final boolean isVmSdkReady() {
        return LynxKitEnv.INSTANCE.isVmSdkReady();
    }

    public final void initVmSdk() {
        LynxKitEnv.INSTANCE.tryInitVmSdk(false);
    }
}
