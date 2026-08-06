package com.bytedance.trae.utils.logger;

import android.util.Log;
import com.bytedance.notification.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TraeLogUtil.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\tJ\"\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\tJ\"\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0018\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\tJ\"\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\tJ\"\u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0016\u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fJ\u0018\u0010\u0010\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\tJ\"\u0010\u0010\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0018\u0010\u0011\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\tJ \u0010\u0011\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\u0011\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/trae/utils/logger/TraeLogUtil;", "", "<init>", "()V", "isLogEnable", "", "v", "", Constants.NOTIFICATION_TAG, "", "msg", "tr", "", "d", "i", "w", "e", "wtf", "utils_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class TraeLogUtil {
    public static final TraeLogUtil INSTANCE = new TraeLogUtil();
    private static final boolean isLogEnable = true;

    private TraeLogUtil() {
    }

    /* renamed from: v */
    public final void m439v(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, Constants.NOTIFICATION_TAG);
        FLogger.INSTANCE.mo429v(tag, msg);
    }

    /* renamed from: v */
    public final void m440v(String tag, String msg, Throwable tr) {
        Intrinsics.checkNotNullParameter(tag, Constants.NOTIFICATION_TAG);
        FLogger.INSTANCE.mo429v(tag, msg + '\n' + Log.getStackTraceString(tr));
    }

    /* renamed from: d */
    public final void m433d(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, Constants.NOTIFICATION_TAG);
        FLogger.INSTANCE.mo425d(tag, msg);
    }

    /* renamed from: d */
    public final void m434d(String tag, String msg, Throwable tr) {
        Intrinsics.checkNotNullParameter(tag, Constants.NOTIFICATION_TAG);
        FLogger.INSTANCE.mo425d(tag, msg + '\n' + Log.getStackTraceString(tr));
    }

    /* renamed from: i */
    public final void m437i(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, Constants.NOTIFICATION_TAG);
        FLogger.INSTANCE.mo428i(tag, msg);
    }

    /* renamed from: i */
    public final void m438i(String tag, String msg, Throwable tr) {
        Intrinsics.checkNotNullParameter(tag, Constants.NOTIFICATION_TAG);
        FLogger.INSTANCE.mo428i(tag, msg + '\n' + Log.getStackTraceString(tr));
    }

    /* renamed from: w */
    public final void m441w(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, Constants.NOTIFICATION_TAG);
        FLogger.INSTANCE.mo430w(tag, msg);
    }

    /* renamed from: w */
    public final void m442w(String tag, String msg, Throwable tr) {
        Intrinsics.checkNotNullParameter(tag, Constants.NOTIFICATION_TAG);
        FLogger.INSTANCE.mo431w(tag, msg, tr);
    }

    /* renamed from: w */
    public final void m443w(String tag, Throwable tr) {
        Intrinsics.checkNotNullParameter(tag, Constants.NOTIFICATION_TAG);
        Intrinsics.checkNotNullParameter(tr, "tr");
        FLogger.INSTANCE.mo432w(tag, tr);
    }

    /* renamed from: e */
    public final void m435e(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, Constants.NOTIFICATION_TAG);
        FLogger.INSTANCE.mo426e(tag, msg);
    }

    /* renamed from: e */
    public final void m436e(String tag, String msg, Throwable tr) {
        Intrinsics.checkNotNullParameter(tag, Constants.NOTIFICATION_TAG);
        FLogger.INSTANCE.mo427e(tag, msg, tr);
    }

    public final void wtf(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, Constants.NOTIFICATION_TAG);
        FLogger fLogger = FLogger.INSTANCE;
        StringBuilder sb = new StringBuilder("[WTF] ");
        if (msg == null) {
            msg = "";
        }
        fLogger.mo426e(tag, sb.append(msg).toString());
    }

    public final void wtf(String tag, String msg, Throwable tr) {
        Intrinsics.checkNotNullParameter(tag, Constants.NOTIFICATION_TAG);
        Intrinsics.checkNotNullParameter(tr, "tr");
        FLogger fLogger = FLogger.INSTANCE;
        StringBuilder sb = new StringBuilder("[WTF] ");
        if (msg == null) {
            msg = "";
        }
        fLogger.mo427e(tag, sb.append(msg).toString(), tr);
    }

    public final void wtf(String tag, Throwable tr) {
        Intrinsics.checkNotNullParameter(tag, Constants.NOTIFICATION_TAG);
        Intrinsics.checkNotNullParameter(tr, "tr");
        FLogger.INSTANCE.mo427e(tag, "[WTF]", tr);
    }
}
