package com.bytedance.ies.argus.base;

import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ArgusLog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J2\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\tJ>\u0010\n\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fJ2\u0010\r\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\tJ2\u0010\u000e\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\t¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ies/argus/base/ArgusLog;", "", "()V", "d", "", "moduleTag", "", "msg", "params", "", "e", "exception", "Ljava/lang/Exception;", "i", "w", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ArgusLog {
    public static final ArgusLog INSTANCE = new ArgusLog();

    private ArgusLog() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void d$default(ArgusLog argusLog, String str, String str2, Map map, int i, Object obj) {
        if ((i & 4) != 0) {
            map = null;
        }
        argusLog.m307d(str, str2, map);
    }

    /* renamed from: d */
    public final void m307d(String moduleTag, String msg, Map<String, ? extends Object> params) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        HybridLogger.d$default(HybridLogger.INSTANCE, "Argus_" + moduleTag, msg, params, (LoggerContext) null, 8, (Object) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void i$default(ArgusLog argusLog, String str, String str2, Map map, int i, Object obj) {
        if ((i & 4) != 0) {
            map = null;
        }
        argusLog.m309i(str, str2, map);
    }

    /* renamed from: i */
    public final void m309i(String moduleTag, String msg, Map<String, ? extends Object> params) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        HybridLogger.i$default(HybridLogger.INSTANCE, "Argus_" + moduleTag, msg, params, (LoggerContext) null, 8, (Object) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void w$default(ArgusLog argusLog, String str, String str2, Map map, int i, Object obj) {
        if ((i & 4) != 0) {
            map = null;
        }
        argusLog.m310w(str, str2, map);
    }

    /* renamed from: w */
    public final void m310w(String moduleTag, String msg, Map<String, ? extends Object> params) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        HybridLogger.w$default(HybridLogger.INSTANCE, "Argus_" + moduleTag, msg, params, (LoggerContext) null, 8, (Object) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void e$default(ArgusLog argusLog, String str, String str2, Map map, Exception exc, int i, Object obj) {
        if ((i & 4) != 0) {
            map = null;
        }
        if ((i & 8) != 0) {
            exc = null;
        }
        argusLog.m308e(str, str2, map, exc);
    }

    /* renamed from: e */
    public final void m308e(String moduleTag, String msg, Map<String, ? extends Object> params, Exception exception) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (exception == null) {
            HybridLogger.e$default(HybridLogger.INSTANCE, "Argus_" + moduleTag, msg, params, (LoggerContext) null, 8, (Object) null);
        } else {
            HybridLogger.e$default(HybridLogger.INSTANCE, "Argus_" + moduleTag + "_crash", msg + ",e=" + exception + ',' + ExceptionsKt.stackTraceToString(exception), params, (LoggerContext) null, 8, (Object) null);
        }
    }
}
