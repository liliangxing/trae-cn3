package com.bytedance.android.live.setting;

import android.content.Context;
import com.lynx.tasm.LynxError;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: LiveSettingManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rJ$\u0010\u000e\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0018\u0010\u0012\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0013\u001a\u00020\u0004J,\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u0017J\u0010\u0010\u001a\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0006J\u0016\u0010\u001c\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/live/setting/LiveSettingManager;", "", "()V", "isLocalTest", "", "mLiveSettingDepend", "Lcom/bytedance/android/live/setting/ILiveSettingDepend;", "e", "", "tag", "", "msg", LynxError.LYNX_THROWABLE, "", "ensureNotReachHere", "logType", "getContext", "Landroid/content/Context;", RXScreenCaptureService.KEY_INDEX, "isSettingDebug", "monitorEvent", "serviceName", "category", "Lorg/json/JSONObject;", "metric", "extraLog", "setLiveSettingDepend", "liveSettingDepend", "w", "live-setting_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class LiveSettingManager {
    public static final LiveSettingManager INSTANCE = new LiveSettingManager();
    private static boolean isLocalTest;
    private static ILiveSettingDepend mLiveSettingDepend;

    private LiveSettingManager() {
    }

    public final void setLiveSettingDepend(ILiveSettingDepend liveSettingDepend) {
        mLiveSettingDepend = liveSettingDepend;
        isLocalTest = liveSettingDepend != null ? liveSettingDepend.isLocalText() : false;
    }

    public final Context getContext() {
        ILiveSettingDepend iLiveSettingDepend = mLiveSettingDepend;
        if (iLiveSettingDepend != null) {
            return iLiveSettingDepend.getContext();
        }
        return null;
    }

    public final boolean isLocalTest() {
        return isLocalTest;
    }

    public final void monitorEvent(String serviceName, JSONObject category, JSONObject metric, JSONObject extraLog) {
        Intrinsics.checkNotNullParameter(serviceName, "serviceName");
        ILiveSettingDepend iLiveSettingDepend = mLiveSettingDepend;
        if (iLiveSettingDepend != null) {
            iLiveSettingDepend.monitorEvent(serviceName, category, metric, extraLog);
        }
    }

    public final void i(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        ILiveSettingDepend iLiveSettingDepend = mLiveSettingDepend;
        if (iLiveSettingDepend != null) {
            iLiveSettingDepend.i(tag, msg);
        }
    }

    public final void e(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        ILiveSettingDepend iLiveSettingDepend = mLiveSettingDepend;
        if (iLiveSettingDepend != null) {
            iLiveSettingDepend.e(tag, msg);
        }
    }

    public final void e(String tag, Throwable throwable) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        ILiveSettingDepend iLiveSettingDepend = mLiveSettingDepend;
        if (iLiveSettingDepend != null) {
            iLiveSettingDepend.e(tag, throwable);
        }
    }

    public final void e(String tag, String msg, Throwable throwable) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        ILiveSettingDepend iLiveSettingDepend = mLiveSettingDepend;
        if (iLiveSettingDepend != null) {
            iLiveSettingDepend.e(tag, msg, throwable);
        }
    }

    public final void w(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        ILiveSettingDepend iLiveSettingDepend = mLiveSettingDepend;
        if (iLiveSettingDepend != null) {
            iLiveSettingDepend.w(tag, msg);
        }
    }

    public final void ensureNotReachHere(String logType, Throwable throwable, String msg) {
        ILiveSettingDepend iLiveSettingDepend = mLiveSettingDepend;
        if (iLiveSettingDepend != null) {
            iLiveSettingDepend.ensureNotReachHere(logType, throwable, msg);
        }
    }

    public final boolean isSettingDebug() {
        ILiveSettingDepend iLiveSettingDepend = mLiveSettingDepend;
        if (iLiveSettingDepend != null) {
            return iLiveSettingDepend.isSettingDebug();
        }
        return false;
    }
}
