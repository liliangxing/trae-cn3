package com.bytedance.ies.bullet.base;

import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExceptionUtil.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ies/bullet/base/ExceptionUtil;", "", "()V", "handle", "", "debuggable", "", "errMsg", "", "throwable", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ExceptionUtil {
    public static final ExceptionUtil INSTANCE = new ExceptionUtil();

    private ExceptionUtil() {
    }

    public static /* synthetic */ void handle$default(ExceptionUtil exceptionUtil, boolean z, String str, Throwable th, int i, Object obj) {
        if ((i & 4) != 0) {
            th = null;
        }
        exceptionUtil.handle(z, str, th);
    }

    public final void handle(boolean debuggable, String errMsg, Throwable throwable) {
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        if (!debuggable) {
            BulletLogger.INSTANCE.printLog(errMsg, LogLevel.E, "XInit");
        } else {
            if (throwable != null) {
                throw throwable;
            }
            throw new RuntimeException(errMsg);
        }
    }
}
