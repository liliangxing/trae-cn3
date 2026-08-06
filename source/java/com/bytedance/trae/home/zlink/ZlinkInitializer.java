package com.bytedance.trae.home.zlink;

import android.app.Application;
import android.util.Log;
import com.bytedance.timon.clipboard.suite.TimonClipboardSuite;
import com.bytedance.ug.sdk.deeplink.ZlinkApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ZlinkInitializer.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/trae/home/zlink/ZlinkInitializer;", "", "<init>", "()V", "TAG", "", "initialized", "", "registerLifeCycle", "", "application", "Landroid/app/Application;", "initAfterPrivacyAgreed", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ZlinkInitializer {
    private static final String TAG = "ZlinkInitializer";
    private static volatile boolean initialized;
    public static final ZlinkInitializer INSTANCE = new ZlinkInitializer();
    public static final int $stable = 8;

    private ZlinkInitializer() {
    }

    public final void registerLifeCycle(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        Log.i(TAG, "registerLifeCycle");
        ZlinkApi.INSTANCE.registerLifeCycle(application);
    }

    public final void initAfterPrivacyAgreed(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        if (initialized) {
            Log.i(TAG, "Already initialized, skip");
            return;
        }
        Log.i(TAG, "initAfterPrivacyAgreed");
        if (!TimonClipboardSuite.INSTANCE.getInit()) {
            TimonClipboardSuite.INSTANCE.init(application);
        }
        ZlinkApi.INSTANCE.init(ZlinkSetup.INSTANCE.buildDependAbility(application));
        initialized = true;
    }
}
