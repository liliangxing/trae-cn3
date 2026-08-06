package com.bytedance.rts.foundation;

import android.os.SystemClock;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Timer.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0000\u0018\u00002\u00020\u0001B/\b\u0016\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bB\u001d\b\u0016\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\fJ\u0006\u0010\u0018\u001a\u00020\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012¨\u0006\u0019"}, d2 = {"Lcom/bytedance/rts/foundation/Task;", "", "action", "Lkotlin/Function0;", "", "sourceLooper", "Lcom/bytedance/rts/foundation/RTSMessageLooper;", EventConstants.PARAM_TIME_OUT, "", "isInterval", "", "(Lkotlin/jvm/functions/Function0;Lcom/bytedance/rts/foundation/RTSMessageLooper;JZ)V", "(Lkotlin/jvm/functions/Function0;Lcom/bytedance/rts/foundation/RTSMessageLooper;)V", "getAction", "()Lkotlin/jvm/functions/Function0;", "()Z", "nextTime", "getNextTime", "()J", "setNextTime", "(J)V", "getSourceLooper", "()Lcom/bytedance/rts/foundation/RTSMessageLooper;", "getTimeout", "run", "lib_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class Task {
    private final Function0<Unit> action;
    private final boolean isInterval;
    private long nextTime;
    private final RTSMessageLooper sourceLooper;
    private final long timeout;

    public final Function0<Unit> getAction() {
        return this.action;
    }

    public final long getNextTime() {
        return this.nextTime;
    }

    public final void setNextTime(long j) {
        this.nextTime = j;
    }

    public final long getTimeout() {
        return this.timeout;
    }

    /* renamed from: isInterval, reason: from getter */
    public final boolean getIsInterval() {
        return this.isInterval;
    }

    public final RTSMessageLooper getSourceLooper() {
        return this.sourceLooper;
    }

    public Task(Function0<Unit> function0, RTSMessageLooper rTSMessageLooper, long j, boolean z) {
        Intrinsics.checkNotNullParameter(function0, "action");
        Intrinsics.checkNotNullParameter(rTSMessageLooper, "sourceLooper");
        this.action = function0;
        this.sourceLooper = rTSMessageLooper;
        this.timeout = j;
        this.nextTime = SystemClock.uptimeMillis() + j;
        this.isInterval = z;
    }

    public /* synthetic */ Task(Function0 function0, RTSMessageLooper rTSMessageLooper, long j, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0, rTSMessageLooper, j, (i & 8) != 0 ? false : z);
    }

    public Task(Function0<Unit> function0, RTSMessageLooper rTSMessageLooper) {
        Intrinsics.checkNotNullParameter(function0, "action");
        Intrinsics.checkNotNullParameter(rTSMessageLooper, "sourceLooper");
        this.action = function0;
        this.sourceLooper = rTSMessageLooper;
        this.timeout = 0L;
        this.nextTime = SystemClock.uptimeMillis();
        this.isInterval = false;
    }

    public final void run() {
        this.action.invoke();
    }
}
