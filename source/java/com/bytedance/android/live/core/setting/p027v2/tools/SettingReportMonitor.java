package com.bytedance.android.live.core.setting.p027v2.tools;

import androidx.core.app.NotificationCompat;
import com.bytedance.android.live.core.setting.LiveSettingOldContext;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: SettingReportMonitor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010%\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0004J\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u0004¢\u0006\u0002\u0010\u0014J\u001a\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004H\u0002J\u000e\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0004J\u000e\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0004J\u0018\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004H\u0007J\u000e\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/live/core/setting/v2/tools/SettingReportMonitor;", "", "()V", "TAG", "", "TAG_GET_ALL", "TAG_GSON", "TAG_MAIN", "TAG_SLADAR", "TAG_TEST", "TAG_TYPE", "TAG_VALUE", "TAG_VERIFY", "mTimeMap", "", "", "finishTimeMonitor", "", "tag", "getTimeMonitor", "(Ljava/lang/String;)Ljava/lang/Long;", "isPrint", "", NotificationCompat.CATEGORY_MESSAGE, "printELog", "e", "", "printLog", "startCostTimeMonitor", "live-setting_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class SettingReportMonitor {
    private static final String TAG = "SettingReportMonitor";
    public static final String TAG_GET_ALL = "_GET_ALL";
    public static final String TAG_GSON = "_GSON";
    public static final String TAG_MAIN = "_MAIN";
    public static final String TAG_SLADAR = "_SLADAR";
    public static final String TAG_TEST = "_TEST";
    public static final String TAG_TYPE = "_TYPE";
    public static final String TAG_VALUE = "_VALUE";
    public static final String TAG_VERIFY = "_VERIFY";
    public static final SettingReportMonitor INSTANCE = new SettingReportMonitor();
    private static final Map<String, Long> mTimeMap = new LinkedHashMap();

    private SettingReportMonitor() {
    }

    public final void startCostTimeMonitor(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        mTimeMap.put(tag, Long.valueOf(System.currentTimeMillis()));
    }

    public final void finishTimeMonitor(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Long l = mTimeMap.get(tag);
        if (l != null) {
            printLog(TAG_MAIN, tag + " 耗时计时：" + (System.currentTimeMillis() - l.longValue()));
        }
    }

    public final Long getTimeMonitor(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Long l = mTimeMap.get(tag);
        if (l == null) {
            return null;
        }
        return Long.valueOf(System.currentTimeMillis() - l.longValue());
    }

    public final void printLog(String msg) {
        Intrinsics.checkNotNullParameter(msg, NotificationCompat.CATEGORY_MESSAGE);
        if (isPrint$default(this, null, msg, 1, null)) {
            LiveSettingOldContext.m1271i(TAG, msg);
        }
    }

    @JvmStatic
    public static final void printLog(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, NotificationCompat.CATEGORY_MESSAGE);
        if (INSTANCE.isPrint(tag, msg)) {
            LiveSettingOldContext.m1271i(TAG + tag, msg);
        }
    }

    public final void printELog(String msg) {
        Intrinsics.checkNotNullParameter(msg, NotificationCompat.CATEGORY_MESSAGE);
        LiveSettingOldContext.m1268e("SettingReportMonitor_MAIN", msg);
    }

    public final void printELog(Throwable e) {
        Intrinsics.checkNotNullParameter(e, "e");
        LiveSettingOldContext.m1270e("SettingReportMonitor_MAIN", e);
    }

    static /* synthetic */ boolean isPrint$default(SettingReportMonitor settingReportMonitor, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = TAG_MAIN;
        }
        return settingReportMonitor.isPrint(str, str2);
    }

    private final boolean isPrint(String tag, String msg) {
        if (StringsKt.contains$default(msg, "keva_remote_config_setting_keys", false, 2, (Object) null)) {
            return false;
        }
        return (Intrinsics.areEqual(tag, TAG_VALUE) ^ true) || LiveSettingOldContext.isLocalTest();
    }
}
