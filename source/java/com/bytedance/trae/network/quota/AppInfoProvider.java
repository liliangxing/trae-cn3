package com.bytedance.trae.network.quota;

import com.bytedance.keva.Keva;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: AppInfoProvider.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0012J\u0006\u0010\u0019\u001a\u00020\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R#\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001a"}, d2 = {"Lcom/bytedance/trae/network/quota/AppInfoProvider;", "", "<init>", "()V", "TAG", "", "REPO_NAME", "KEY_IS_FIRST_START_APP", "keva", "Lcom/bytedance/keva/Keva;", "kotlin.jvm.PlatformType", "getKeva", "()Lcom/bytedance/keva/Keva;", "keva$delegate", "Lkotlin/Lazy;", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "firstStartFlag", "", "getFirstStartFlag", "()Z", "firstStartFlag$delegate", EventConstants.PARAM_SOURCE_INIT, "", "isInitialized", "isFirstStartApp", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class AppInfoProvider {
    private static final String KEY_IS_FIRST_START_APP = "is_first_start_app";
    private static final String REPO_NAME = "flow_infra_app_state_bind_with_device";
    private static final String TAG = "AppInfoProvider";
    public static final AppInfoProvider INSTANCE = new AppInfoProvider();

    /* renamed from: keva$delegate, reason: from kotlin metadata */
    private static final Lazy keva = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.network.quota.AppInfoProvider$$ExternalSyntheticLambda0
        public final Object invoke() {
            Keva keva_delegate$lambda$0;
            keva_delegate$lambda$0 = AppInfoProvider.keva_delegate$lambda$0();
            return keva_delegate$lambda$0;
        }
    });
    private static final AtomicBoolean initialized = new AtomicBoolean(false);

    /* renamed from: firstStartFlag$delegate, reason: from kotlin metadata */
    private static final Lazy firstStartFlag = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.network.quota.AppInfoProvider$$ExternalSyntheticLambda1
        public final Object invoke() {
            boolean firstStartFlag_delegate$lambda$1;
            firstStartFlag_delegate$lambda$1 = AppInfoProvider.firstStartFlag_delegate$lambda$1();
            return Boolean.valueOf(firstStartFlag_delegate$lambda$1);
        }
    });

    private AppInfoProvider() {
    }

    private final Keva getKeva() {
        return (Keva) keva.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Keva keva_delegate$lambda$0() {
        return Keva.getRepo(REPO_NAME);
    }

    private final boolean getFirstStartFlag() {
        return ((Boolean) firstStartFlag.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean firstStartFlag_delegate$lambda$1() {
        AppInfoProvider appInfoProvider = INSTANCE;
        boolean z = appInfoProvider.getKeva().getBoolean(KEY_IS_FIRST_START_APP, true);
        if (z) {
            appInfoProvider.getKeva().storeBoolean(KEY_IS_FIRST_START_APP, false);
        }
        return z;
    }

    public final void init() {
        AtomicBoolean atomicBoolean = initialized;
        if (atomicBoolean.get()) {
            return;
        }
        synchronized (this) {
            if (atomicBoolean.get()) {
                return;
            }
            atomicBoolean.set(true);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final boolean isInitialized() {
        return initialized.get();
    }

    public final boolean isFirstStartApp() {
        return getFirstStartFlag();
    }
}
