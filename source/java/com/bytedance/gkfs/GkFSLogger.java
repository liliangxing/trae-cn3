package com.bytedance.gkfs;

import android.util.Log;
import com.bytedance.applog.server.Api;
import com.bytedance.geckox.logger.GeckoLogger;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GkFSLogger.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0002J*\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\u0010J6\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u000f\u001a\u00020\u0010J$\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J \u0010\u0016\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\bH\u0002J6\u0010\u0017\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u000f\u001a\u00020\u0010R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/gkfs/GkFSLogger;", "", "()V", "counter", "Ljava/util/concurrent/atomic/AtomicInteger;", "getCounter", "()Ljava/util/concurrent/atomic/AtomicInteger;", "id", "", "d", "", Api.COL_TAG, "", "msg", "seq", "needALog", "", "e", "t", "", "printConsoleLogIfNeed", "level", "processMsg", "w", "Companion", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class GkFSLogger {
    public static final String TAG = "gkfs-debug-tag";
    private final AtomicInteger counter = new AtomicInteger(-1);
    private final int id = hashCode();

    public final AtomicInteger getCounter() {
        return this.counter;
    }

    public static /* synthetic */ void d$default(GkFSLogger gkFSLogger, String str, String str2, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = gkFSLogger.counter.get();
        }
        if ((i2 & 8) != 0) {
            z = false;
        }
        gkFSLogger.m304d(str, str2, i, z);
    }

    /* renamed from: d */
    public final void m304d(String tag, String msg, int seq, boolean needALog) {
        Intrinsics.checkParameterIsNotNull(tag, Api.COL_TAG);
        Intrinsics.checkParameterIsNotNull(msg, "msg");
        String processMsg = processMsg(tag, msg, seq);
        if (needALog) {
            GeckoLogger.m297d(TAG, processMsg);
        }
        printConsoleLogIfNeed$default(this, 4, processMsg, null, 4, null);
    }

    public static /* synthetic */ void e$default(GkFSLogger gkFSLogger, String str, String str2, int i, Throwable th, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = gkFSLogger.counter.get();
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            th = null;
        }
        Throwable th2 = th;
        if ((i2 & 16) != 0) {
            z = true;
        }
        gkFSLogger.m305e(str, str2, i3, th2, z);
    }

    /* renamed from: e */
    public final void m305e(String tag, String msg, int seq, Throwable t, boolean needALog) {
        Intrinsics.checkParameterIsNotNull(tag, Api.COL_TAG);
        Intrinsics.checkParameterIsNotNull(msg, "msg");
        String processMsg = processMsg(tag, msg, seq);
        if (needALog) {
            GeckoLogger.m298e(TAG, processMsg, t);
        }
        printConsoleLogIfNeed(6, processMsg, t);
    }

    public static /* synthetic */ void w$default(GkFSLogger gkFSLogger, String str, String str2, int i, Throwable th, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = gkFSLogger.counter.get();
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            th = null;
        }
        Throwable th2 = th;
        if ((i2 & 16) != 0) {
            z = true;
        }
        gkFSLogger.m306w(str, str2, i3, th2, z);
    }

    /* renamed from: w */
    public final void m306w(String tag, String msg, int seq, Throwable t, boolean needALog) {
        Intrinsics.checkParameterIsNotNull(tag, Api.COL_TAG);
        Intrinsics.checkParameterIsNotNull(msg, "msg");
        String processMsg = processMsg(tag, msg, seq);
        if (needALog) {
            GeckoLogger.m302w(TAG, processMsg, t);
        }
        printConsoleLogIfNeed(5, processMsg, t);
    }

    private final String processMsg(String tag, String msg, int seq) {
        String str;
        StringBuilder append = new StringBuilder("[").append(this.id).append("][").append(tag).append("][").append(seq).append(']');
        if (UtilsKt.getDebuggable()) {
            StringBuilder sb = new StringBuilder("[");
            Thread currentThread = Thread.currentThread();
            Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
            str = sb.append(currentThread.getName()).append(']').toString();
        } else {
            str = "";
        }
        return append.append(str).append(msg).toString();
    }

    static /* synthetic */ void printConsoleLogIfNeed$default(GkFSLogger gkFSLogger, int i, String str, Throwable th, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            th = null;
        }
        gkFSLogger.printConsoleLogIfNeed(i, str, th);
    }

    private final void printConsoleLogIfNeed(int level, String msg, Throwable t) {
        if (UtilsKt.getDebuggable()) {
            if (level == 4) {
                Log.i(TAG, msg);
            } else if (level == 5) {
                Log.w(TAG, msg, t);
            } else {
                if (level != 6) {
                    return;
                }
                Log.e(TAG, msg, t);
            }
        }
    }
}
