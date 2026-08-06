package com.bytedance.android.live.core.setting;

import android.util.Log;
import com.bytedance.apm.constant.TraceStatsConsts;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SettingTracer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/core/setting/SettingTracer;", "", "()V", "TAG", "", TraceStatsConsts.STATS_KEY_TRACE, "", "info", "live-setting_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class SettingTracer {
    public static final SettingTracer INSTANCE = new SettingTracer();
    private static final String TAG = "LiveSetting";

    private SettingTracer() {
    }

    @JvmStatic
    public static final void trace(String info) {
        Intrinsics.checkNotNullParameter(info, "info");
        if (LiveSettingOldContext.isLocalTest()) {
            Log.d(TAG, info);
        }
        LiveSettingOldContext.i(TAG, info);
    }
}
