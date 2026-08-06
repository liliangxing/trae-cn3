package com.edu.onetex.utils;

import android.util.Log;
import com.edu.onetex.latex.LaTeXEngine;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LaTeXLogger.kt */
@Deprecated(message = "使用IParseLogger")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/edu/onetex/utils/LaTeXLogger;", "Lcom/edu/onetex/utils/ILogger;", "()V", "customLogger", "getCustomLogger", "()Lcom/edu/onetex/utils/ILogger;", "setCustomLogger", "(Lcom/edu/onetex/utils/ILogger;)V", "d", "", "tag", "", "msg", "e", "i", "w", "onetex_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class LaTeXLogger implements ILogger {
    public static final LaTeXLogger INSTANCE = new LaTeXLogger();
    private static ILogger customLogger;

    private LaTeXLogger() {
    }

    public final ILogger getCustomLogger() {
        return customLogger;
    }

    public final void setCustomLogger(ILogger iLogger) {
        customLogger = iLogger;
    }

    @Override // com.edu.onetex.utils.ILogger
    /* renamed from: i */
    public void mo410i(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (LaTeXEngine.INSTANCE.getDebugMode()) {
            ILogger iLogger = customLogger;
            if (iLogger == null) {
                Log.i(tag, msg);
            } else if (iLogger != null) {
                iLogger.mo410i(tag, msg);
            }
        }
    }

    @Override // com.edu.onetex.utils.ILogger
    /* renamed from: w */
    public void mo411w(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (LaTeXEngine.INSTANCE.getDebugMode()) {
            ILogger iLogger = customLogger;
            if (iLogger == null) {
                Log.w(tag, msg);
            } else if (iLogger != null) {
                iLogger.mo411w(tag, msg);
            }
        }
    }

    @Override // com.edu.onetex.utils.ILogger
    /* renamed from: d */
    public void mo408d(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (LaTeXEngine.INSTANCE.getDebugMode()) {
            ILogger iLogger = customLogger;
            if (iLogger == null) {
                Log.d(tag, msg);
            } else if (iLogger != null) {
                iLogger.mo408d(tag, msg);
            }
        }
    }

    @Override // com.edu.onetex.utils.ILogger
    /* renamed from: e */
    public void mo409e(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (LaTeXEngine.INSTANCE.getDebugMode()) {
            ILogger iLogger = customLogger;
            if (iLogger == null) {
                Log.e(tag, msg);
            } else if (iLogger != null) {
                iLogger.mo409e(tag, msg);
            }
        }
    }
}
