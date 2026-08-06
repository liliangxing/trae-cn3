package com.bytedance.android.live.core.setting;

import android.app.Application;
import android.content.Context;
import com.bytedance.android.live.setting.LiveAppContextHelper;
import com.bytedance.android.live.setting.LiveSettingManager;
import com.lynx.tasm.LynxError;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: LiveSettingOldContext.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0007J\"\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u000eH\u0007J&\u0010\u000f\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0007J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007J\u0018\u0010\u0013\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0007J\b\u0010\u0014\u001a\u00020\u0004H\u0007J\b\u0010\u0015\u001a\u00020\u0004H\u0007J.\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u0019H\u0007J\u0018\u0010\u001c\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0007R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/live/core/setting/LiveSettingOldContext;", "", "()V", "isStopLog", "", "()Z", "setStopLog", "(Z)V", "e", "", "tag", "", "msg", LynxError.LYNX_THROWABLE, "", "ensureNotReachHere", "logType", "getApplication", "Landroid/app/Application;", RXScreenCaptureService.KEY_INDEX, "isLocalTest", "isSettingDebug", "monitorEvent", "serviceName", "category", "Lorg/json/JSONObject;", "metric", "extraLog", "w", "live-setting_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class LiveSettingOldContext {
    public static final LiveSettingOldContext INSTANCE = new LiveSettingOldContext();
    private static boolean isStopLog;

    private LiveSettingOldContext() {
    }

    public final boolean isStopLog() {
        return isStopLog;
    }

    public final void setStopLog(boolean z) {
        isStopLog = z;
    }

    @JvmStatic
    public static final boolean isSettingDebug() {
        return LiveSettingManager.INSTANCE.isSettingDebug();
    }

    @JvmStatic
    public static final void e(String tag, Throwable e) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(e, "e");
        LiveSettingManager.INSTANCE.e(tag, e);
    }

    @JvmStatic
    public static final void e(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        LiveSettingManager.INSTANCE.e(tag, msg);
    }

    @JvmStatic
    public static final void e(String tag, String msg, Throwable throwable) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        LiveSettingManager.INSTANCE.e(tag, msg, throwable);
    }

    @JvmStatic
    public static final void i(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        LiveSettingManager.INSTANCE.i(tag, msg);
    }

    @JvmStatic
    public static final boolean isLocalTest() {
        return LiveSettingManager.INSTANCE.isLocalTest();
    }

    @JvmStatic
    public static final Application getApplication() {
        Context context = LiveAppContextHelper.INSTANCE.getContext();
        if (!(context instanceof Application)) {
            context = null;
        }
        return (Application) context;
    }

    @JvmStatic
    public static final void monitorEvent(String serviceName, JSONObject category, JSONObject metric, JSONObject extraLog) {
        Intrinsics.checkNotNullParameter(serviceName, "serviceName");
        LiveSettingManager.INSTANCE.monitorEvent(serviceName, category, metric, extraLog);
    }

    @JvmStatic
    public static final void w(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        LiveSettingManager.INSTANCE.w(tag, msg);
    }

    @JvmStatic
    public static final void ensureNotReachHere(String logType, Throwable throwable, String msg) {
        LiveSettingManager.INSTANCE.ensureNotReachHere(logType, throwable, msg);
    }
}
