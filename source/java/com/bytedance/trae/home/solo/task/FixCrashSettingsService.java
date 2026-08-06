package com.bytedance.trae.home.solo.task;

import com.bytedance.news.common.settings.SettingsManager;
import com.bytedance.trae.utils.logger.TraeLogUtil;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import org.json.JSONObject;

/* compiled from: IFixCrashSettings.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/home/solo/task/FixCrashSettingsService;", "", "<init>", "()V", "TAG", "", "isFixSuspendByPeerCrashEnable", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class FixCrashSettingsService {
    public static final int $stable = 0;
    public static final FixCrashSettingsService INSTANCE = new FixCrashSettingsService();
    private static final String TAG = "FixCrashSettings";

    private FixCrashSettingsService() {
    }

    public final boolean isFixSuspendByPeerCrashEnable() {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            FixCrashSettingsService fixCrashSettingsService = this;
            IFixCrashSettings iFixCrashSettings = (IFixCrashSettings) SettingsManager.obtain(IFixCrashSettings.class);
            obj = Result.constructor-impl(iFixCrashSettings != null ? iFixCrashSettings.getFixSuspendByPeerCrash() : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            TraeLogUtil.INSTANCE.w(TAG, "obtain fix crash settings failed", th2);
        }
        String str = (String) (Result.isFailure-impl(obj) ? null : obj);
        if (str == null) {
            return false;
        }
        try {
            return new JSONObject(str).optBoolean("fix_suspend_by_peer_crash", false);
        } catch (Throwable unused) {
            return false;
        }
    }
}
