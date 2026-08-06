package com.bytedance.ies.bullet.kit.resourceloader.loggger;

import com.bytedance.ies.bullet.service.base.resourceloader.config.TaskConfig;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RLLogger.kt */
@Deprecated(message = "该类已经废弃，请使用HybridLogger进行日志打印")
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004J\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0004J\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0004J\u0016\u0010\r\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0004J\u0010\u0010\u0011\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006J0\u0010\u0013\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0018\b\u0002\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0015J\u000e\u0010\u0016\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0004J\u0016\u0010\u0016\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ies/bullet/kit/resourceloader/loggger/RLLogger;", "", "()V", "TAG", "", "defaultLogger", "Lcom/bytedance/ies/bullet/kit/resourceloader/loggger/Logger;", "core", "", "config", "Lcom/bytedance/ies/bullet/service/base/resourceloader/config/TaskConfig;", "msg", "d", "e", "tr", "", "preloadInfo", "setLogger", "logger", "tridentCore", "content", "", "w", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class RLLogger {
    public static final String TAG = "[ResourceLoader]";
    public static final RLLogger INSTANCE = new RLLogger();
    private static Logger defaultLogger = new DefaultLogger();

    private RLLogger() {
    }

    public final void setLogger(Logger logger) {
        if (logger != null) {
            defaultLogger = logger;
        }
    }

    public final void preloadInfo(String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        defaultLogger.mo15d("[ResourceLoader] PreloadV2 " + msg);
    }

    /* renamed from: d */
    public final void m21d(String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        defaultLogger.mo15d("[ResourceLoader] " + msg);
    }

    /* renamed from: w */
    public final void m24w(String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        defaultLogger.mo18w("[ResourceLoader] " + msg);
    }

    /* renamed from: w */
    public final void m25w(String msg, Throwable tr) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(tr, "tr");
        defaultLogger.mo19w("[ResourceLoader] " + msg, tr);
    }

    /* renamed from: e */
    public final void m22e(String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        defaultLogger.mo16e("[ResourceLoader] " + msg);
    }

    /* renamed from: e */
    public final void m23e(String msg, Throwable tr) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(tr, "tr");
        defaultLogger.mo17e("[ResourceLoader] " + msg, tr);
    }

    public final void core(TaskConfig config, String msg) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(msg, "msg");
        defaultLogger.core(config, msg);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void tridentCore$default(RLLogger rLLogger, TaskConfig taskConfig, String str, Map map, int i, Object obj) {
        if ((i & 4) != 0) {
            map = null;
        }
        rLLogger.tridentCore(taskConfig, str, map);
    }

    public final void tridentCore(TaskConfig config, String msg, Map<String, ? extends Object> content) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(msg, "msg");
        defaultLogger.tridentCore(config, msg, content);
    }
}
