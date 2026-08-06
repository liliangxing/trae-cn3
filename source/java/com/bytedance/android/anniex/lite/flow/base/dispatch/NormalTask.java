package com.bytedance.android.anniex.lite.flow.base.dispatch;

import android.net.Uri;
import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IAnnieXTask.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/anniex/lite/flow/base/dispatch/NormalTask;", "", "taskType", "", "bid", "sessionId", "uri", "Landroid/net/Uri;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;)V", "getBid", "()Ljava/lang/String;", "getSessionId", "getTaskType", "getUri", "()Landroid/net/Uri;", "component1", "component2", "component3", "component4", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class NormalTask {
    private final String bid;
    private final String sessionId;
    private final String taskType;
    private final Uri uri;

    public static /* synthetic */ NormalTask copy$default(NormalTask normalTask, String str, String str2, String str3, Uri uri, int i, Object obj) {
        if ((i & 1) != 0) {
            str = normalTask.taskType;
        }
        if ((i & 2) != 0) {
            str2 = normalTask.bid;
        }
        if ((i & 4) != 0) {
            str3 = normalTask.sessionId;
        }
        if ((i & 8) != 0) {
            uri = normalTask.uri;
        }
        return normalTask.copy(str, str2, str3, uri);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTaskType() {
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

    public final NormalTask copy(String taskType, String bid, String sessionId, Uri uri) {
        Intrinsics.checkNotNullParameter(taskType, "taskType");
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        return new NormalTask(taskType, bid, sessionId, uri);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NormalTask)) {
            return false;
        }
        NormalTask normalTask = (NormalTask) other;
        return Intrinsics.areEqual(this.taskType, normalTask.taskType) && Intrinsics.areEqual(this.bid, normalTask.bid) && Intrinsics.areEqual(this.sessionId, normalTask.sessionId) && Intrinsics.areEqual(this.uri, normalTask.uri);
    }

    public int hashCode() {
        int hashCode = ((((this.taskType.hashCode() * 31) + this.bid.hashCode()) * 31) + this.sessionId.hashCode()) * 31;
        Uri uri = this.uri;
        return hashCode + (uri == null ? 0 : uri.hashCode());
    }

    public String toString() {
        return "NormalTask(taskType=" + this.taskType + ", bid=" + this.bid + ", sessionId=" + this.sessionId + ", uri=" + this.uri + ')';
    }

    public NormalTask(String taskType, String bid, String sessionId, Uri uri) {
        Intrinsics.checkNotNullParameter(taskType, "taskType");
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
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

    public final String getTaskType() {
        return this.taskType;
    }

    public final Uri getUri() {
        return this.uri;
    }
}
