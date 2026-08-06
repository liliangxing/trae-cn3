package com.bytedance.android.anniex.lite.flow.base.dispatch;

import android.net.Uri;
import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IAnnieXTask.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/anniex/lite/flow/base/dispatch/LoadFlowTask;", "", "taskType", "Lcom/bytedance/android/anniex/lite/flow/base/dispatch/FlowTaskType;", "bid", "", "sessionId", "uri", "Landroid/net/Uri;", "(Lcom/bytedance/android/anniex/lite/flow/base/dispatch/FlowTaskType;Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;)V", "getBid", "()Ljava/lang/String;", "getSessionId", "getTaskType", "()Lcom/bytedance/android/anniex/lite/flow/base/dispatch/FlowTaskType;", "getUri", "()Landroid/net/Uri;", "component1", "component2", "component3", "component4", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class LoadFlowTask {
    private final String bid;
    private final String sessionId;
    private final FlowTaskType taskType;
    private final Uri uri;

    public static /* synthetic */ LoadFlowTask copy$default(LoadFlowTask loadFlowTask, FlowTaskType flowTaskType, String str, String str2, Uri uri, int i, Object obj) {
        if ((i & 1) != 0) {
            flowTaskType = loadFlowTask.taskType;
        }
        if ((i & 2) != 0) {
            str = loadFlowTask.bid;
        }
        if ((i & 4) != 0) {
            str2 = loadFlowTask.sessionId;
        }
        if ((i & 8) != 0) {
            uri = loadFlowTask.uri;
        }
        return loadFlowTask.copy(flowTaskType, str, str2, uri);
    }

    /* renamed from: component1, reason: from getter */
    public final FlowTaskType getTaskType() {
        return this.taskType;
    }

    /* renamed from: component2, reason: from getter */
    public final String getBid() {
        return this.bid;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* renamed from: component4, reason: from getter */
    public final Uri getUri() {
        return this.uri;
    }

    public final LoadFlowTask copy(FlowTaskType taskType, String bid, String sessionId, Uri uri) {
        Intrinsics.checkNotNullParameter(taskType, "taskType");
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(uri, "uri");
        return new LoadFlowTask(taskType, bid, sessionId, uri);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LoadFlowTask)) {
            return false;
        }
        LoadFlowTask loadFlowTask = (LoadFlowTask) other;
        return this.taskType == loadFlowTask.taskType && Intrinsics.areEqual(this.bid, loadFlowTask.bid) && Intrinsics.areEqual(this.sessionId, loadFlowTask.sessionId) && Intrinsics.areEqual(this.uri, loadFlowTask.uri);
    }

    public int hashCode() {
        return (((((this.taskType.hashCode() * 31) + this.bid.hashCode()) * 31) + this.sessionId.hashCode()) * 31) + this.uri.hashCode();
    }

    public String toString() {
        return "LoadFlowTask(taskType=" + this.taskType + ", bid=" + this.bid + ", sessionId=" + this.sessionId + ", uri=" + this.uri + ')';
    }

    public LoadFlowTask(FlowTaskType taskType, String bid, String sessionId, Uri uri) {
        Intrinsics.checkNotNullParameter(taskType, "taskType");
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(uri, "uri");
        this.taskType = taskType;
        this.bid = bid;
        this.sessionId = sessionId;
        this.uri = uri;
    }

    public final String getBid() {
        return this.bid;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final FlowTaskType getTaskType() {
        return this.taskType;
    }

    public final Uri getUri() {
        return this.uri;
    }
}
