package com.bytedance.vcloud.uniplayer;

import android.content.Context;
import com.bytedance.vcloud.impl.UniAbConfigImpl;
import com.ss.ttm.player.TTPlayer;
import com.ss.vcbkit.VCBaseKitLoader;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UniKitService.android.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u001a\b\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\b\u0010\u0005\u001a\u00020\u0006H\u0000\u001a\u001e\u0010\u0007\u001a\u00020\u0006*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u001a\u001a\u0010\f\u001a\u00020\u0006*\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"initOnceGate", "Lcom/bytedance/vcloud/uniplayer/OnceGate;", "libraryLoadGate", "getGlobalAbConfig", "Lcom/bytedance/vcloud/uniplayer/UniAbConfig;", "loadLibrary", "", "initOnce", "Lcom/bytedance/vcloud/uniplayer/UniKitService;", "context", "Landroid/content/Context;", "abConfig", "updateConfig", "isIncremental", "", "uniplayer_release"}, k = 2, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class UniKitService_androidKt {
    private static final OnceGate libraryLoadGate = new OnceGate();
    private static final OnceGate initOnceGate = new OnceGate();

    public static final void loadLibrary() {
        OnceGate onceGate = libraryLoadGate;
        if (onceGate.done.get()) {
            return;
        }
        synchronized (onceGate) {
            if (onceGate.done.get()) {
                return;
            }
            VCBaseKitLoader.loadLibrary();
            TTPlayer.getAppPath();
            System.loadLibrary("uniplayer");
            onceGate.done.set(true);
            Unit unit = Unit.INSTANCE;
        }
    }

    public static final UniAbConfig getGlobalAbConfig() {
        loadLibrary();
        return new UniAbConfigImpl(UniKitServiceNative.getAbConfig());
    }

    public static /* synthetic */ void initOnce$default(UniKitService uniKitService, Context context, UniAbConfig uniAbConfig, int i, Object obj) {
        if ((i & 2) != 0) {
            uniAbConfig = null;
        }
        initOnce(uniKitService, context, uniAbConfig);
    }

    public static final void initOnce(UniKitService uniKitService, Context context, UniAbConfig uniAbConfig) {
        Intrinsics.checkNotNullParameter(uniKitService, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if (initOnceGate.tryOnce()) {
            loadLibrary();
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            UniAndroidEnv.INSTANCE.setContext(context);
            boolean z = uniAbConfig instanceof UniAbConfigImpl;
            UniAbConfigImpl uniAbConfigImpl = z ? (UniAbConfigImpl) uniAbConfig : null;
            if (uniAbConfigImpl == null) {
                UniAbConfig create = UniAbConfig.INSTANCE.create();
                Intrinsics.checkNotNull(create, "null cannot be cast to non-null type com.bytedance.vcloud.impl.UniAbConfigImpl");
                uniAbConfigImpl = (UniAbConfigImpl) create;
            }
            boolean z2 = !z;
            if (z2) {
                String absolutePath = new File(context.getCacheDir(), "mdl2").getAbsolutePath();
                UniAbStrKey uniAbStrKey = UniAbStrKey.MDL_CACHE_DIR;
                Intrinsics.checkNotNullExpressionValue(absolutePath, "mdlCacheDir");
                uniAbConfigImpl.setUniAbKv(uniAbStrKey, absolutePath);
            }
            UniKitServiceNative.init(uniAbConfigImpl.getMNative());
            if (z2) {
                uniAbConfigImpl.close();
            }
        }
    }

    public static final void updateConfig(UniKitService uniKitService, UniAbConfig uniAbConfig, boolean z) {
        Intrinsics.checkNotNullParameter(uniKitService, "<this>");
        Intrinsics.checkNotNullParameter(uniAbConfig, "abConfig");
        loadLibrary();
        UniAbConfigImpl uniAbConfigImpl = uniAbConfig instanceof UniAbConfigImpl ? (UniAbConfigImpl) uniAbConfig : null;
        UniKitServiceNative.update(uniAbConfigImpl != null ? uniAbConfigImpl.getMNative() : 0L, z);
    }
}
