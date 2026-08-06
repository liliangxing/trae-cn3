package com.bytedance.ies.bullet.ug;

import android.content.Context;
import bolts.Task;
import com.bytedance.ies.bullet.preloadv2.PreloadV2;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.api.BidConstants;
import com.bytedance.ies.bullet.service.base.settings.IBulletSettingsService;
import com.bytedance.ies.bullet.service.base.settings.PineappleConfig;
import com.bytedance.ies.bullet.service.base.standard.StandardServiceManager;
import java.util.Iterator;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BulletOptimize.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0004H\u0002J\u0016\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0004J\u0018\u0010\u0015\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0004H\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ies/bullet/ug/BulletOptimize;", "", "()V", "globalOptimizeConfig", "Lcom/bytedance/ies/bullet/ug/BulletOptimizeConfig;", "getGlobalOptimizeConfig", "()Lcom/bytedance/ies/bullet/ug/BulletOptimizeConfig;", "setGlobalOptimizeConfig", "(Lcom/bytedance/ies/bullet/ug/BulletOptimizeConfig;)V", "hasBootFinish", "", "needPreloadWhenConfigUpdate", "onBootFinish", "", "context", "Landroid/content/Context;", "onLogin", "onLogout", "startPreload", "config", "updateConfig", "updateConfigInternal", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class BulletOptimize {
    public static final BulletOptimize INSTANCE = new BulletOptimize();
    private static BulletOptimizeConfig globalOptimizeConfig;
    private static boolean hasBootFinish;
    private static boolean needPreloadWhenConfigUpdate;

    private BulletOptimize() {
    }

    public final BulletOptimizeConfig getGlobalOptimizeConfig() {
        return globalOptimizeConfig;
    }

    public final void setGlobalOptimizeConfig(BulletOptimizeConfig bulletOptimizeConfig) {
        globalOptimizeConfig = bulletOptimizeConfig;
    }

    private final void startPreload(BulletOptimizeConfig config) {
        PineappleConfig pineappleConfig;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        boolean disablePreload = (iBulletSettingsService == null || (pineappleConfig = (PineappleConfig) iBulletSettingsService.obtainSettings(PineappleConfig.class)) == null) ? false : pineappleConfig.getDisablePreload();
        if (disablePreload) {
            BulletLogger.printXDBLog$default(BulletLogger.INSTANCE, "BulletOptimize PreloadV2 disable by settings " + disablePreload, null, null, 6, null);
            return;
        }
        Iterator<String> it = config.getPreloadPages().iterator();
        while (it.hasNext()) {
            PreloadV2.INSTANCE.preload(it.next(), BidConstants.LUCKY);
        }
    }

    public final void updateConfig(final Context context, final BulletOptimizeConfig config) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        Task.callInBackground(new Callable() { // from class: com.bytedance.ies.bullet.ug.BulletOptimize$updateConfig$1
            @Override // java.util.concurrent.Callable
            public /* bridge */ /* synthetic */ Object call() {
                call();
                return Unit.INSTANCE;
            }

            @Override // java.util.concurrent.Callable
            public final void call() {
                BulletOptimize.INSTANCE.updateConfigInternal(context, config);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void updateConfigInternal(Context context, BulletOptimizeConfig config) {
        BulletLogger.printXDBLog$default(BulletLogger.INSTANCE, "BulletOptimize, updateConfigInternal " + config, null, null, 6, null);
        boolean z = globalOptimizeConfig != null ? !Intrinsics.areEqual(r7.getPreloadPages(), config.getPreloadPages()) : false;
        globalOptimizeConfig = config;
        config.getInitializer().initialize();
        if (needPreloadWhenConfigUpdate || (hasBootFinish && z)) {
            startPreload(config);
            needPreloadWhenConfigUpdate = false;
        }
    }

    public final synchronized void onBootFinish(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final synchronized void onLogin(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final synchronized void onLogout(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
