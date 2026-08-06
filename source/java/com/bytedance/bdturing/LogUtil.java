package com.bytedance.bdturing;

import android.util.Log;
import com.bytedance.android.anniex.solutions.card.AirActionConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LogUtil.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0007J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0007J\u001c\u0010\u000b\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0007J\u001c\u0010\f\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0007J\b\u0010\r\u001a\u00020\u000eH\u0007J\b\u0010\u000f\u001a\u00020\u0006H\u0007J\u0014\u0010\u0010\u001a\u00020\u00062\n\u0010\u000b\u001a\u00060\u0011j\u0002`\u0012H\u0007J\b\u0010\u0013\u001a\u00020\u0006H\u0002J\u001a\u0010\u0014\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u001c\u0010\u0015\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/bytedance/bdturing/LogUtil;", "", "()V", "LOG_LEVEL", "", "closeLog", "", AirActionConstant.ActionId.ACTION_ID_DEFAULT_VALUE, "tag", "", "msg", "e", RXScreenCaptureService.KEY_INDEX, "isDebug", "", "openLog", "printException", "Ljava/lang/Exception;", "Lkotlin/Exception;", "printStack", BaseSwitches.V, "w", "setting_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LogUtil {
    public static final LogUtil INSTANCE = new LogUtil();
    private static int LOG_LEVEL = 1;

    private LogUtil() {
    }

    @JvmStatic
    public static final void openLog() {
        LOG_LEVEL = 7;
    }

    @JvmStatic
    public static final void closeLog() {
        LOG_LEVEL = 1;
    }

    @JvmStatic
    public static final boolean isDebug() {
        return LOG_LEVEL > 6;
    }

    @JvmStatic
    public static final void i(String tag, String msg) {
        if (LOG_LEVEL < 4) {
            return;
        }
        Log.i(tag, String.valueOf(msg));
    }

    @JvmStatic
    public static final void w(String tag, String msg) {
        if (LOG_LEVEL < 5) {
            return;
        }
        Log.w(tag, String.valueOf(msg));
    }

    @JvmStatic
    public static final void e(String tag, String msg) {
        if (LOG_LEVEL < 6) {
            return;
        }
        Log.e(tag, String.valueOf(msg));
    }

    @JvmStatic
    public static final void d(String tag, String msg) {
        if (LOG_LEVEL < 3) {
            return;
        }
        Log.d(tag, String.valueOf(msg));
    }

    public final void v(String tag, String msg) {
        if (LOG_LEVEL < 2) {
            return;
        }
        Log.v(tag, String.valueOf(msg));
    }

    @JvmStatic
    public static final void printException(Exception e) {
        Intrinsics.checkNotNullParameter(e, "e");
        if (LOG_LEVEL < 3) {
            e.printStackTrace();
        }
    }

    private final void printStack() {
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            System.out.println(stackTraceElement);
        }
    }
}
