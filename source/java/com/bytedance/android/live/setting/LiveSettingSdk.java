package com.bytedance.android.live.setting;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LiveSettingSdk.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/setting/LiveSettingSdk;", "", "()V", "mInited", "", "init", "", "builder", "Lcom/bytedance/android/live/setting/LiveSettingConfigBuilder;", "live-setting_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class LiveSettingSdk {
    public static final LiveSettingSdk INSTANCE = new LiveSettingSdk();
    private static volatile boolean mInited;

    private LiveSettingSdk() {
    }

    @JvmStatic
    public static final void init(LiveSettingConfigBuilder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        if (mInited) {
            return;
        }
        LiveSettingManager.INSTANCE.setLiveSettingDepend(builder.getLiveSettingDepend());
        mInited = true;
    }
}
