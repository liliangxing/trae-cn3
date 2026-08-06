package com.bytedance.pia.snapshot.storage;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.framwork.core.sdkmonitor.MonitorConstants;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SnapshotEntity.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\nHÆ\u0003J\t\u0010 \u001a\u00020\fHÆ\u0003JZ\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\nHÖ\u0001J\b\u0010'\u001a\u00020\u0003H\u0016R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0019\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000f¨\u0006("}, d2 = {"Lcom/bytedance/pia/snapshot/storage/SnapshotEntity;", "", "urlWithQuery", "", "queryKeys", "", "content", "head", "version", MonitorConstants.MONITOR_FROM_SDK, "", "expireTime", "", "(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IJ)V", "getContent", "()Ljava/lang/String;", "getExpireTime", "()J", "getHead", "getQueryKeys", "()[Ljava/lang/String;", "[Ljava/lang/String;", "getSdk", "()I", "getUrlWithQuery", "getVersion", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IJ)Lcom/bytedance/pia/snapshot/storage/SnapshotEntity;", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class SnapshotEntity {
    private final String content;
    private final long expireTime;
    private final String head;
    private final String[] queryKeys;
    private final int sdk;
    private final String urlWithQuery;
    private final String version;

    /* renamed from: component1, reason: from getter */
    public final String getUrlWithQuery() {
        return this.urlWithQuery;
    }

    /* renamed from: component2, reason: from getter */
    public final String[] getQueryKeys() {
        return this.queryKeys;
    }

    /* renamed from: component3, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: component4, reason: from getter */
    public final String getHead() {
        return this.head;
    }

    /* renamed from: component5, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    /* renamed from: component6, reason: from getter */
    public final int getSdk() {
        return this.sdk;
    }

    /* renamed from: component7, reason: from getter */
    public final long getExpireTime() {
        return this.expireTime;
    }

    public final SnapshotEntity copy(String urlWithQuery, String[] queryKeys, String content, String head, String version, int sdk, long expireTime) {
        Intrinsics.checkNotNullParameter(urlWithQuery, "urlWithQuery");
        Intrinsics.checkNotNullParameter(queryKeys, "queryKeys");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(head, "head");
        Intrinsics.checkNotNullParameter(version, "version");
        return new SnapshotEntity(urlWithQuery, queryKeys, content, head, version, sdk, expireTime);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SnapshotEntity)) {
            return false;
        }
        SnapshotEntity snapshotEntity = (SnapshotEntity) other;
        return Intrinsics.areEqual(this.urlWithQuery, snapshotEntity.urlWithQuery) && Intrinsics.areEqual(this.queryKeys, snapshotEntity.queryKeys) && Intrinsics.areEqual(this.content, snapshotEntity.content) && Intrinsics.areEqual(this.head, snapshotEntity.head) && Intrinsics.areEqual(this.version, snapshotEntity.version) && this.sdk == snapshotEntity.sdk && this.expireTime == snapshotEntity.expireTime;
    }

    public int hashCode() {
        return (((((((((((this.urlWithQuery.hashCode() * 31) + Arrays.hashCode(this.queryKeys)) * 31) + this.content.hashCode()) * 31) + this.head.hashCode()) * 31) + this.version.hashCode()) * 31) + Integer.hashCode(this.sdk)) * 31) + Long.hashCode(this.expireTime);
    }

    public SnapshotEntity(String urlWithQuery, String[] queryKeys, String content, String head, String version, int i, long j) {
        Intrinsics.checkNotNullParameter(urlWithQuery, "urlWithQuery");
        Intrinsics.checkNotNullParameter(queryKeys, "queryKeys");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(head, "head");
        Intrinsics.checkNotNullParameter(version, "version");
        this.urlWithQuery = urlWithQuery;
        this.queryKeys = queryKeys;
        this.content = content;
        this.head = head;
        this.version = version;
        this.sdk = i;
        this.expireTime = j;
    }

    public /* synthetic */ SnapshotEntity(String str, String[] strArr, String str2, String str3, String str4, int i, long j, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, strArr, str2, (i2 & 8) != 0 ? "" : str3, str4, (i2 & 32) != 0 ? 1 : i, j);
    }

    public final String getUrlWithQuery() {
        return this.urlWithQuery;
    }

    public final String[] getQueryKeys() {
        return this.queryKeys;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getHead() {
        return this.head;
    }

    public final String getVersion() {
        return this.version;
    }

    public final int getSdk() {
        return this.sdk;
    }

    public final long getExpireTime() {
        return this.expireTime;
    }

    public String toString() {
        return "SnapshotEntity(uri='" + this.urlWithQuery + "', queryKeys='" + this.queryKeys + "', content='" + this.content + "', head='" + this.head + "', version=" + this.version + ", sdk=" + this.sdk + ", expireTime=" + this.expireTime + ')';
    }
}
