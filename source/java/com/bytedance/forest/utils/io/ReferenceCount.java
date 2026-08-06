package com.bytedance.forest.utils.io;

import com.bytedance.forest.utils.ForestLogger;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: concurrent.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\u0010\u001a\u00020\u0006R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0004¨\u0006\u0011"}, d2 = {"Lcom/bytedance/forest/utils/io/ReferenceCount;", "", "logger", "Lcom/bytedance/forest/utils/ForestLogger;", "(Lcom/bytedance/forest/utils/ForestLogger;)V", "count", "", "getLogger", "()Lcom/bytedance/forest/utils/ForestLogger;", "setLogger", "add", "caller", "", "clear", "", "delete", "get", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
final class ReferenceCount {
    private int count;
    private ForestLogger logger;

    public ReferenceCount(ForestLogger forestLogger) {
        Intrinsics.checkParameterIsNotNull(forestLogger, "logger");
        this.logger = forestLogger;
    }

    public final ForestLogger getLogger() {
        return this.logger;
    }

    public final void setLogger(ForestLogger forestLogger) {
        Intrinsics.checkParameterIsNotNull(forestLogger, "<set-?>");
        this.logger = forestLogger;
    }

    public final int get() {
        int i;
        synchronized (this) {
            i = this.count;
        }
        return i;
    }

    public final void clear(String caller) {
        Intrinsics.checkParameterIsNotNull(caller, "caller");
        synchronized (this) {
            ForestLogger forestLogger = this.logger;
            StringBuilder append = new StringBuilder("#").append(caller).append(", force set reference to:(").append(this.count).append(" -> 0), stack=");
            Thread currentThread = Thread.currentThread();
            Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
            ForestLogger.print$default(forestLogger, 3, "Concurrent", append.append(Arrays.toString(currentThread.getStackTrace())).toString(), false, null, null, 56, null);
            this.count = 0;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final int add(String caller) {
        int i;
        Intrinsics.checkParameterIsNotNull(caller, "caller");
        synchronized (this) {
            i = this.count + 1;
            this.count = i;
            ForestLogger forestLogger = this.logger;
            StringBuilder append = new StringBuilder("#").append(caller).append(", increment reference to:").append(i).append(", stack=");
            Thread currentThread = Thread.currentThread();
            Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
            ForestLogger.print$default(forestLogger, 3, "Concurrent", append.append(Arrays.toString(currentThread.getStackTrace())).toString(), false, null, null, 56, null);
        }
        return i;
    }

    public final int delete(String caller) {
        int i;
        Intrinsics.checkParameterIsNotNull(caller, "caller");
        synchronized (this) {
            i = this.count - 1;
            this.count = i;
            ForestLogger forestLogger = this.logger;
            StringBuilder append = new StringBuilder("#").append(caller).append(", decrement reference to:").append(i).append(", stack=");
            Thread currentThread = Thread.currentThread();
            Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
            ForestLogger.print$default(forestLogger, 3, "Concurrent", append.append(Arrays.toString(currentThread.getStackTrace())).toString(), false, null, null, 56, null);
        }
        return i;
    }
}
