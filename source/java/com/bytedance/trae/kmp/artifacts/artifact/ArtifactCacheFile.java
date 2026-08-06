package com.bytedance.trae.kmp.artifacts.artifact;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ArtifactDiskCache.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÇ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0012\u001a\u00020\u0013H×\u0001J\t\u0010\u0014\u001a\u00020\u0003H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheFile;", "", "reference", "", "size", "", "<init>", "(Ljava/lang/String;J)V", "getReference", "()Ljava/lang/String;", "getSize", "()J", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "artifacts_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ArtifactCacheFile {
    public static final int $stable = 0;
    private final String reference;
    private final long size;

    public static /* synthetic */ ArtifactCacheFile copy$default(ArtifactCacheFile artifactCacheFile, String str, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = artifactCacheFile.reference;
        }
        if ((i & 2) != 0) {
            j = artifactCacheFile.size;
        }
        return artifactCacheFile.copy(str, j);
    }

    /* renamed from: component1, reason: from getter */
    public final String getReference() {
        return this.reference;
    }

    /* renamed from: component2, reason: from getter */
    public final long getSize() {
        return this.size;
    }

    public final ArtifactCacheFile copy(String reference, long size) {
        Intrinsics.checkNotNullParameter(reference, "reference");
        return new ArtifactCacheFile(reference, size);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ArtifactCacheFile)) {
            return false;
        }
        ArtifactCacheFile artifactCacheFile = (ArtifactCacheFile) other;
        return Intrinsics.areEqual(this.reference, artifactCacheFile.reference) && this.size == artifactCacheFile.size;
    }

    public int hashCode() {
        return (this.reference.hashCode() * 31) + Long.hashCode(this.size);
    }

    public String toString() {
        return "ArtifactCacheFile(reference=" + this.reference + ", size=" + this.size + ')';
    }

    public ArtifactCacheFile(String reference, long j) {
        Intrinsics.checkNotNullParameter(reference, "reference");
        this.reference = reference;
        this.size = j;
    }

    public final String getReference() {
        return this.reference;
    }

    public final long getSize() {
        return this.size;
    }
}
