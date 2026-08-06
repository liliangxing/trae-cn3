package com.bytedance.geckox.logger;

import com.bytedance.android.anniex.solutions.card.AirActionConstant;
import com.bytedance.ies.bullet.forest.ForestLoader;
import com.bytedance.iesgurd.core.ReportNode;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: GeckoLogger.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rH\u0007J\u001d\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u0015J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0004H\u0007J\u0018\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004H\u0007J\b\u0010\u0017\u001a\u00020\u000fH\u0007J\"\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0007J\u0018\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u001aH\u0007J\b\u0010\u001b\u001a\u00020\u000fH\u0007J\u0010\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rH\u0007J\u0010\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0004H\u0007J\u0018\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004H\u0007J\"\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0007J\u0018\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u001aH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\u0007\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/bytedance/geckox/logger/GeckoLogger;", "", "()V", "TAG", "", "defaultLogger", "Lcom/bytedance/geckox/logger/DefaultLogger;", "isDebug", "", "isDebug$annotations", "()Z", "loggerList", "", "Lcom/bytedance/geckox/logger/Logger;", "addLogger", "", "logger", AirActionConstant.ActionId.ACTION_ID_DEFAULT_VALUE, "name", "Lcom/bytedance/iesgurd/core/ReportNode;", "msg", "d$geckox_noasanRelease", "tag", ForestLoader.PRELOAD_SCOPE_DISABLE, "e", "tr", "", "enable", "removeLogger", "w", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes3.dex */
public final class GeckoLogger {
    private static final String TAG = "gecko-debug-tag";
    public static final GeckoLogger INSTANCE = new GeckoLogger();
    private static final List<Logger> loggerList = new CopyOnWriteArrayList();
    private static final DefaultLogger defaultLogger = new DefaultLogger();

    @Deprecated(message = "")
    @JvmStatic
    public static final void disable() {
    }

    @Deprecated(message = "")
    @JvmStatic
    public static final void enable() {
    }

    public static final boolean isDebug() {
        return false;
    }

    @Deprecated(message = "")
    @JvmStatic
    public static /* synthetic */ void isDebug$annotations() {
    }

    private GeckoLogger() {
    }

    @JvmStatic
    public static final void addLogger(Logger logger) {
        Intrinsics.checkParameterIsNotNull(logger, "logger");
        loggerList.add(logger);
    }

    @JvmStatic
    public static final void removeLogger(Logger logger) {
        Intrinsics.checkParameterIsNotNull(logger, "logger");
        loggerList.remove(logger);
    }

    @JvmStatic
    public static final void d(String msg) {
        Intrinsics.checkParameterIsNotNull(msg, "msg");
        List<Logger> list = loggerList;
        if (list.size() == 0) {
            defaultLogger.d(TAG, msg);
            return;
        }
        Iterator<Logger> it = list.iterator();
        while (it.hasNext()) {
            it.next().d(TAG, msg);
        }
    }

    public final void d$geckox_noasanRelease(ReportNode name, String msg) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        Intrinsics.checkParameterIsNotNull(msg, "msg");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%s|xParam:{\"name\":\"%s\",\"message\":\"%s\"}", Arrays.copyOf(new Object[]{name.getTag(), name.getTag(), msg}, 3));
        Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
        List<Logger> list = loggerList;
        if (list.size() == 0) {
            defaultLogger.d(TAG, format);
            return;
        }
        Iterator<Logger> it = list.iterator();
        while (it.hasNext()) {
            it.next().d(TAG, format);
        }
    }

    @JvmStatic
    public static final void w(String msg) {
        Intrinsics.checkParameterIsNotNull(msg, "msg");
        List<Logger> list = loggerList;
        if (list.size() == 0) {
            defaultLogger.w(TAG, msg);
            return;
        }
        Iterator<Logger> it = list.iterator();
        while (it.hasNext()) {
            it.next().w(TAG, msg);
        }
    }

    @JvmStatic
    public static final void w(String msg, Throwable tr) {
        Intrinsics.checkParameterIsNotNull(msg, "msg");
        Intrinsics.checkParameterIsNotNull(tr, "tr");
        List<Logger> list = loggerList;
        if (list.size() == 0) {
            defaultLogger.w(TAG, msg, tr);
            return;
        }
        Iterator<Logger> it = list.iterator();
        while (it.hasNext()) {
            it.next().w(TAG, msg, tr);
        }
    }

    @JvmStatic
    public static final void e(String msg, Throwable tr) {
        Intrinsics.checkParameterIsNotNull(msg, "msg");
        Intrinsics.checkParameterIsNotNull(tr, "tr");
        List<Logger> list = loggerList;
        if (list.size() == 0) {
            defaultLogger.e(TAG, msg, tr);
            return;
        }
        Iterator<Logger> it = list.iterator();
        while (it.hasNext()) {
            it.next().e(TAG, msg, tr);
        }
    }

    @Deprecated(message = "")
    @JvmStatic
    public static final void d(String tag, String msg) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Intrinsics.checkParameterIsNotNull(msg, "msg");
        List<Logger> list = loggerList;
        if (list.size() == 0) {
            defaultLogger.d(tag, msg);
            return;
        }
        Iterator<Logger> it = list.iterator();
        while (it.hasNext()) {
            it.next().d(tag, msg);
        }
    }

    @Deprecated(message = "")
    @JvmStatic
    public static final void w(String tag, String msg, Throwable tr) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Intrinsics.checkParameterIsNotNull(msg, "msg");
        List<Logger> list = loggerList;
        if (list.size() == 0) {
            defaultLogger.w(tag, msg, tr);
            return;
        }
        Iterator<Logger> it = list.iterator();
        while (it.hasNext()) {
            it.next().w(tag, msg, tr);
        }
    }

    @Deprecated(message = "")
    @JvmStatic
    public static final void w(String tag, String msg) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Intrinsics.checkParameterIsNotNull(msg, "msg");
        List<Logger> list = loggerList;
        if (list.size() == 0) {
            defaultLogger.w(tag, msg);
            return;
        }
        Iterator<Logger> it = list.iterator();
        while (it.hasNext()) {
            it.next().w(tag, msg);
        }
    }

    @Deprecated(message = "")
    @JvmStatic
    public static final void e(String tag, String msg, Throwable tr) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Intrinsics.checkParameterIsNotNull(msg, "msg");
        List<Logger> list = loggerList;
        if (list.size() == 0) {
            defaultLogger.e(tag, msg, tr);
            return;
        }
        Iterator<Logger> it = list.iterator();
        while (it.hasNext()) {
            it.next().e(tag, msg, tr);
        }
    }
}
