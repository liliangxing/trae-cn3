package com.bytedance.security.android.aopcheck.settings;

import android.content.Context;
import com.bytedance.news.common.settings.IndividualManager;
import com.bytedance.news.common.settings.LazyConfig;
import com.bytedance.news.common.settings.SettingsConfig;
import com.bytedance.security.android.aopcheck.reporter.Constant;
import com.bytedance.security.android.aopcheck.utils.ProcessUtil;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SettingContoller.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/bytedance/security/android/aopcheck/settings/SettingContoller;", "", "()V", "initSettingSdk", "", "context", "Landroid/content/Context;", "aopcheck_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SettingContoller {
    public static final SettingContoller INSTANCE = new SettingContoller();

    private SettingContoller() {
    }

    @JvmStatic
    public static final void initSettingSdk(final Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        IndividualManager.obtainManager(Constant.KEY_SETTING_ID).init(new LazyConfig() { // from class: com.bytedance.security.android.aopcheck.settings.SettingContoller$initSettingSdk$1
            public final SettingsConfig create() {
                return new SettingsConfig.Builder().context(context).requestService(new SettingsRequestServiceImpl()).isMainProcess(ProcessUtil.isMainProcess(context)).build();
            }
        });
        IndividualManager.obtainManager(Constant.KEY_SETTING_ID).updateSettings(true);
    }
}
