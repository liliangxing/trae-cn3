package com.bytedance.security.android.aopcheck.reporter;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.security.android.aopcheck.utils.StackTraceUtil;
import com.lynx.tasm.LynxError;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AOPReportEvent.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0096\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#J\b\u0010$\u001a\u00020\u0003H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006%"}, d2 = {"Lcom/bytedance/security/android/aopcheck/reporter/AOPReportEvent;", "Lcom/bytedance/security/android/aopcheck/reporter/IEvent;", ReportConstant.COMMON_ACTION_TYPE, "", "timestamp", "", "content", ReportConstant.COMMON_BACKTRACE, "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;)V", "getActionType", "()Ljava/lang/String;", "setActionType", "(Ljava/lang/String;)V", "getBacktrace", "setBacktrace", "getContent", "setContent", "getTimestamp", "()J", "setTimestamp", "(J)V", "component1", "component2", "component3", "component4", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "setThrowable", "", LynxError.LYNX_THROWABLE, "", "toString", "aopcheck_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes5.dex */
public final /* data */ class AOPReportEvent implements IEvent {
    private String actionType;
    private String backtrace;
    private String content;
    private long timestamp;

    public AOPReportEvent() {
        this(null, 0L, null, null, 15, null);
    }

    public static /* synthetic */ AOPReportEvent copy$default(AOPReportEvent aOPReportEvent, String str, long j, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = aOPReportEvent.actionType;
        }
        if ((i & 2) != 0) {
            j = aOPReportEvent.timestamp;
        }
        long j2 = j;
        if ((i & 4) != 0) {
            str2 = aOPReportEvent.content;
        }
        String str4 = str2;
        if ((i & 8) != 0) {
            str3 = aOPReportEvent.backtrace;
        }
        return aOPReportEvent.copy(str, j2, str4, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getActionType() {
        return this.actionType;
    }

    /* renamed from: component2, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    /* renamed from: component3, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: component4, reason: from getter */
    public final String getBacktrace() {
        return this.backtrace;
    }

    public final AOPReportEvent copy(String actionType, long timestamp, String content, String backtrace) {
        Intrinsics.checkParameterIsNotNull(actionType, "actionType");
        Intrinsics.checkParameterIsNotNull(content, "content");
        Intrinsics.checkParameterIsNotNull(backtrace, "backtrace");
        return new AOPReportEvent(actionType, timestamp, content, backtrace);
    }

    public AOPReportEvent(String actionType, long j, String content, String backtrace) {
        Intrinsics.checkParameterIsNotNull(actionType, "actionType");
        Intrinsics.checkParameterIsNotNull(content, "content");
        Intrinsics.checkParameterIsNotNull(backtrace, "backtrace");
        this.actionType = actionType;
        this.timestamp = j;
        this.content = content;
        this.backtrace = backtrace;
    }

    public final String getActionType() {
        return this.actionType;
    }

    public final void setActionType(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.actionType = str;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final void setTimestamp(long j) {
        this.timestamp = j;
    }

    public final String getContent() {
        return this.content;
    }

    public final void setContent(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.content = str;
    }

    public /* synthetic */ AOPReportEvent(String str, long j, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? 0L : j, (i & 4) != 0 ? "" : str2, (i & 8) != 0 ? "" : str3);
    }

    public final String getBacktrace() {
        return this.backtrace;
    }

    public final void setBacktrace(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.backtrace = str;
    }

    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        AOPReportEvent aOPReportEvent = (AOPReportEvent) other;
        return Intrinsics.areEqual(this.actionType, aOPReportEvent.actionType) && Intrinsics.areEqual(this.content, aOPReportEvent.content) && Intrinsics.areEqual(this.backtrace, aOPReportEvent.backtrace);
    }

    public final void setThrowable(Throwable throwable) {
        if (throwable != null) {
            this.backtrace = StackTraceUtil.INSTANCE.getRawStack(throwable);
        }
    }

    public String toString() {
        return "AOPReportEvent(actionType='" + this.actionType + "', timestamp=" + this.timestamp + ", content='" + this.content + "', backtrace='" + this.backtrace + '\'';
    }

    public int hashCode() {
        return (((((this.actionType.hashCode() * 31) + Long.hashCode(this.timestamp)) * 31) + this.content.hashCode()) * 31) + this.backtrace.hashCode();
    }
}
