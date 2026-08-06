package com.bytedance.trae.kmp.artifacts.artifact;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ArtifactDiskCache.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÇ\u0001J\u0013\u0010\u0017\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0019\u001a\u00020\u001aH×\u0001J\t\u0010\u001b\u001a\u00020\u0003H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheEntry;", "", "reference", "", "size", "", "lastAccessMillis", "temporaryOversized", "", "<init>", "(Ljava/lang/String;JJZ)V", "getReference", "()Ljava/lang/String;", "getSize", "()J", "getLastAccessMillis", "getTemporaryOversized", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "artifacts_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ArtifactCacheEntry {
    public static final int $stable = 0;
    private final long lastAccessMillis;
    private final String reference;
    private final long size;
    private final boolean temporaryOversized;

    public static /* synthetic */ ArtifactCacheEntry copy$default(ArtifactCacheEntry artifactCacheEntry, String str, long j, long j2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = artifactCacheEntry.reference;
        }
        if ((i & 2) != 0) {
            j = artifactCacheEntry.size;
        }
        long j3 = j;
        if ((i & 4) != 0) {
            j2 = artifactCacheEntry.lastAccessMillis;
        }
        long j4 = j2;
        if ((i & 8) != 0) {
            z = artifactCacheEntry.temporaryOversized;
        }
        return artifactCacheEntry.copy(str, j3, j4, z);
    }

    /* renamed from: component1, reason: from getter */
    public final String getReference() {
        return this.reference;
    }

    /* renamed from: component2, reason: from getter */
    public final long getSize() {
        return this.size;
    }

    /* renamed from: component3, reason: from getter */
    public final long getLastAccessMillis() {
        return this.lastAccessMillis;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getTemporaryOversized() {
        return this.temporaryOversized;
    }

    public final ArtifactCacheEntry copy(String reference, long size, long lastAccessMillis, boolean temporaryOversized) {
        Intrinsics.checkNotNullParameter(reference, "reference");
        return new ArtifactCacheEntry(reference, size, lastAccessMillis, temporaryOversized);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ArtifactCacheEntry)) {
            return false;
        }
        ArtifactCacheEntry artifactCacheEntry = (ArtifactCacheEntry) other;
        return Intrinsics.areEqual(this.reference, artifactCacheEntry.reference) && this.size == artifactCacheEntry.size && this.lastAccessMillis == artifactCacheEntry.lastAccessMillis && this.temporaryOversized == artifactCacheEntry.temporaryOversized;
    }

    public int hashCode() {
        return (((((this.reference.hashCode() * 31) + Long.hashCode(this.size)) * 31) + Long.hashCode(this.lastAccessMillis)) * 31) + Boolean.hashCode(this.temporaryOversized);
    }

    public String toString() {
        return "ArtifactCacheEntry(reference=" + this.reference + ", size=" + this.size + ", lastAccessMillis=" + this.lastAccessMillis + ", temporaryOversized=" + this.temporaryOversized + ')';
    }

    public ArtifactCacheEntry(String reference, long j, long j2, boolean z) {
        Intrinsics.checkNotNullParameter(reference, "reference");
        this.reference = reference;
        this.size = j;
        this.lastAccessMillis = j2;
        this.temporaryOversized = z;
    }

    public /* synthetic */ ArtifactCacheEntry(String str, long j, long j2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, j2, (i & 8) != 0 ? false : z);
    }

    public final String getReference() {
        return this.reference;
    }

    public final long getSize() {
        return this.size;
    }

    public final long getLastAccessMillis() {
        return this.lastAccessMillis;
    }

    public final boolean getTemporaryOversized() {
        return this.temporaryOversized;
    }
}
