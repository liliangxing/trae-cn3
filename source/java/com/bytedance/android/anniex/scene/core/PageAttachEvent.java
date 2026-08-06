package com.bytedance.android.anniex.scene.core;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ViewAttachEvent.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/anniex/scene/core/PageAttachEvent;", "", "name", "", "timestamp", "", "(Ljava/lang/String;J)V", "getName", "()Ljava/lang/String;", "getTimestamp", "()J", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class PageAttachEvent {
    private final String name;
    private final long timestamp;

    public static /* synthetic */ PageAttachEvent copy$default(PageAttachEvent pageAttachEvent, String str, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = pageAttachEvent.name;
        }
        if ((i & 2) != 0) {
            j = pageAttachEvent.timestamp;
        }
        return pageAttachEvent.copy(str, j);
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    public final PageAttachEvent copy(String name, long timestamp) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new PageAttachEvent(name, timestamp);
    }

    public String toString() {
        return "PageAttachEvent(name=" + this.name + ", timestamp=" + this.timestamp + ')';
    }

    public PageAttachEvent(String name, long j) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.timestamp = j;
    }

    public final String getName() {
        return this.name;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public boolean equals(Object other) {
        if (other instanceof PageAttachEvent) {
            return Intrinsics.areEqual(this.name, ((PageAttachEvent) other).name);
        }
        return false;
    }

    public int hashCode() {
        return this.name.hashCode();
    }
}
