package com.bytedance.android.anniex.scene.core;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ViewAttachEvent.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/anniex/scene/core/ViewAttachEvent;", "", "url", "", "timestamp", "", "sessionId", "(Ljava/lang/String;JLjava/lang/String;)V", "getSessionId", "()Ljava/lang/String;", "getTimestamp", "()J", "getUrl", "component1", "component2", "component3", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class ViewAttachEvent {
    private final String sessionId;
    private final long timestamp;
    private final String url;

    public static /* synthetic */ ViewAttachEvent copy$default(ViewAttachEvent viewAttachEvent, String str, long j, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = viewAttachEvent.url;
        }
        if ((i & 2) != 0) {
            j = viewAttachEvent.timestamp;
        }
        if ((i & 4) != 0) {
            str2 = viewAttachEvent.sessionId;
        }
        return viewAttachEvent.copy(str, j, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: component2, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    public final ViewAttachEvent copy(String url, long timestamp, String sessionId) {
        Intrinsics.checkNotNullParameter(url, "url");
        return new ViewAttachEvent(url, timestamp, sessionId);
    }

    public String toString() {
        return "ViewAttachEvent(url=" + this.url + ", timestamp=" + this.timestamp + ", sessionId=" + this.sessionId + ')';
    }

    public ViewAttachEvent(String url, long j, String str) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.url = url;
        this.timestamp = j;
        this.sessionId = str;
    }

    public /* synthetic */ ViewAttachEvent(String str, long j, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, (i & 4) != 0 ? null : str2);
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final String getUrl() {
        return this.url;
    }

    public boolean equals(Object other) {
        if (other instanceof ViewAttachEvent) {
            return Intrinsics.areEqual(this.url, ((ViewAttachEvent) other).url);
        }
        return false;
    }

    public int hashCode() {
        return this.url.hashCode();
    }
}
