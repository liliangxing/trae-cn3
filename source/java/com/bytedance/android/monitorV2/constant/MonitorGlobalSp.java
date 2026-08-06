package com.bytedance.android.monitorV2.constant;

import android.app.Application;
import android.content.SharedPreferences;
import com.bytedance.android.monitorV2.HybridMultiMonitor;
import com.bytedance.applog.server.Api;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MonitorGlobalSp.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00042\b\b\u0001\u0010\u001b\u001a\u00020\u0019H\u0007J\u001a\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00042\b\b\u0001\u0010\u001b\u001a\u00020\u0019H\u0007J\u001a\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001a\u001a\u00020\u00042\b\b\u0001\u0010\u001b\u001a\u00020\u001eH\u0007J\u001a\u0010\u001f\u001a\u00020 2\u0006\u0010\u001a\u001a\u00020\u00042\b\b\u0001\u0010\u001b\u001a\u00020 H\u0007J\u001a\u0010!\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00042\b\b\u0001\u0010\u001b\u001a\u00020\u0004H\u0007J\u001a\u0010\"\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\u00042\b\b\u0001\u0010$\u001a\u00020\u0019H\u0007J\u001a\u0010%\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\u00042\b\b\u0001\u0010$\u001a\u00020\u001eH\u0007J\u001a\u0010&\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\u00042\b\b\u0001\u0010$\u001a\u00020 H\u0007J\u001a\u0010'\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\u00042\b\b\u0001\u0010$\u001a\u00020\u0004H\u0007J\u0010\u0010(\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0013\u001a\u0004\u0018\u00010\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015¨\u0006)"}, d2 = {"Lcom/bytedance/android/monitorV2/constant/MonitorGlobalSp;", "", "()V", "MONITOR_APP_SETTINGS_RESPONSE", "", "MONITOR_APP_SETTINGS_TIME", "MONITOR_DEBUG_SP", "MONITOR_EVENT_DETAILS", "MONITOR_EVENT_FILTER_ID", "MONITOR_EVENT_FLUSH_TIME", "MONITOR_IS_REINSTALL", "MONITOR_SETTING_RESPONSE", "MONITOR_SETTING_RESPONSE_FETCH_TIME", "MONITOR_SETTING_RESPONSE_V2", "MONITOR_SP", "application", "Landroid/app/Application;", "debugSp", "Landroid/content/SharedPreferences;", "sp", "getSp", "()Landroid/content/SharedPreferences;", "sp$delegate", "Lkotlin/Lazy;", "getBoolean", "", Api.KEY_ENCRYPT_RESP_KEY, "defValue", "getBooleanFromHDT", "getInt", "", "getLong", "", "getString", "putBoolean", "", "value", "putInt", "putLong", "putString", "remove", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class MonitorGlobalSp {
    public static final String MONITOR_APP_SETTINGS_RESPONSE = "monitor_app_settings_response";
    public static final String MONITOR_APP_SETTINGS_TIME = "monitor_app_settings_time";
    public static final String MONITOR_DEBUG_SP = "monitor_sdk";
    public static final String MONITOR_EVENT_DETAILS = "monitor_event_details";
    public static final String MONITOR_EVENT_FILTER_ID = "monitor_event_filter_id";
    public static final String MONITOR_EVENT_FLUSH_TIME = "monitor_event_flush_time";
    public static final String MONITOR_IS_REINSTALL = "monitor_is_reinstall";
    public static final String MONITOR_SETTING_RESPONSE = "monitor_setting_response";
    public static final String MONITOR_SETTING_RESPONSE_FETCH_TIME = "monitor_setting_response_fetch_time";
    public static final String MONITOR_SETTING_RESPONSE_V2 = "monitor_setting_response_v2";
    public static final String MONITOR_SP = "bd_hybrid_monitor_global_shared_preference";
    private static SharedPreferences debugSp;
    public static final MonitorGlobalSp INSTANCE = new MonitorGlobalSp();

    /* renamed from: sp$delegate, reason: from kotlin metadata */
    private static final Lazy sp = LazyKt.lazy(new Function0<SharedPreferences>() { // from class: com.bytedance.android.monitorV2.constant.MonitorGlobalSp$sp$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final SharedPreferences m325invoke() {
            Application application2;
            application2 = MonitorGlobalSp.application;
            if (application2 != null) {
                return application2.getSharedPreferences(MonitorGlobalSp.MONITOR_SP, 4);
            }
            return null;
        }
    });
    private static final Application application = HybridMultiMonitor.getInstance().getApplication();

    private MonitorGlobalSp() {
    }

    private final SharedPreferences getSp() {
        return (SharedPreferences) sp.getValue();
    }

    @JvmStatic
    public static final String getString(String key, String defValue) {
        SharedPreferences sp2;
        String string;
        Intrinsics.checkNotNullParameter(key, Api.KEY_ENCRYPT_RESP_KEY);
        Intrinsics.checkNotNullParameter(defValue, "defValue");
        return (application == null || (sp2 = INSTANCE.getSp()) == null || (string = sp2.getString(key, defValue)) == null) ? defValue : string;
    }

    @JvmStatic
    public static final int getInt(String key, int defValue) {
        SharedPreferences sp2;
        Intrinsics.checkNotNullParameter(key, Api.KEY_ENCRYPT_RESP_KEY);
        return (application == null || (sp2 = INSTANCE.getSp()) == null) ? defValue : sp2.getInt(key, defValue);
    }

    @JvmStatic
    public static final long getLong(String key, long defValue) {
        SharedPreferences sp2;
        Intrinsics.checkNotNullParameter(key, Api.KEY_ENCRYPT_RESP_KEY);
        return (application == null || (sp2 = INSTANCE.getSp()) == null) ? defValue : sp2.getLong(key, defValue);
    }

    @JvmStatic
    public static final boolean getBoolean(String key, boolean defValue) {
        SharedPreferences sp2;
        Intrinsics.checkNotNullParameter(key, Api.KEY_ENCRYPT_RESP_KEY);
        return (application == null || (sp2 = INSTANCE.getSp()) == null) ? defValue : sp2.getBoolean(key, defValue);
    }

    @JvmStatic
    public static final boolean getBooleanFromHDT(String key, boolean defValue) {
        Intrinsics.checkNotNullParameter(key, Api.KEY_ENCRYPT_RESP_KEY);
        Application application2 = application;
        if (application2 == null) {
            return defValue;
        }
        if (debugSp == null) {
            debugSp = application2.getSharedPreferences(MONITOR_DEBUG_SP, 4);
        }
        SharedPreferences sharedPreferences = debugSp;
        return sharedPreferences != null ? sharedPreferences.getBoolean(key, defValue) : defValue;
    }

    @JvmStatic
    public static final void putString(String key, String value) {
        SharedPreferences sp2;
        SharedPreferences.Editor edit;
        SharedPreferences.Editor putString;
        Intrinsics.checkNotNullParameter(key, Api.KEY_ENCRYPT_RESP_KEY);
        Intrinsics.checkNotNullParameter(value, "value");
        if (application == null || (sp2 = INSTANCE.getSp()) == null || (edit = sp2.edit()) == null || (putString = edit.putString(key, value)) == null) {
            return;
        }
        putString.apply();
    }

    @JvmStatic
    public static final void putInt(String key, int value) {
        SharedPreferences sp2;
        SharedPreferences.Editor edit;
        SharedPreferences.Editor putInt;
        Intrinsics.checkNotNullParameter(key, Api.KEY_ENCRYPT_RESP_KEY);
        if (application == null || (sp2 = INSTANCE.getSp()) == null || (edit = sp2.edit()) == null || (putInt = edit.putInt(key, value)) == null) {
            return;
        }
        putInt.apply();
    }

    @JvmStatic
    public static final void putLong(String key, long value) {
        SharedPreferences sp2;
        SharedPreferences.Editor edit;
        SharedPreferences.Editor putLong;
        Intrinsics.checkNotNullParameter(key, Api.KEY_ENCRYPT_RESP_KEY);
        if (application == null || (sp2 = INSTANCE.getSp()) == null || (edit = sp2.edit()) == null || (putLong = edit.putLong(key, value)) == null) {
            return;
        }
        putLong.apply();
    }

    @JvmStatic
    public static final void putBoolean(String key, boolean value) {
        SharedPreferences sp2;
        SharedPreferences.Editor edit;
        SharedPreferences.Editor putBoolean;
        Intrinsics.checkNotNullParameter(key, Api.KEY_ENCRYPT_RESP_KEY);
        if (application == null || (sp2 = INSTANCE.getSp()) == null || (edit = sp2.edit()) == null || (putBoolean = edit.putBoolean(key, value)) == null) {
            return;
        }
        putBoolean.apply();
    }

    @JvmStatic
    public static final void remove(String key) {
        SharedPreferences sp2;
        SharedPreferences.Editor edit;
        SharedPreferences.Editor remove;
        Intrinsics.checkNotNullParameter(key, Api.KEY_ENCRYPT_RESP_KEY);
        if (application == null || (sp2 = INSTANCE.getSp()) == null || (edit = sp2.edit()) == null || (remove = edit.remove(key)) == null) {
            return;
        }
        remove.apply();
    }
}
