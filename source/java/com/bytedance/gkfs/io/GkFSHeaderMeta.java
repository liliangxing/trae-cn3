package com.bytedance.gkfs.io;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: meta.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0080\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/bytedance/gkfs/io/GkFSHeaderMeta;", "", "version", "", "fileOriginSize", "", "size", "(IJJ)V", "getFileOriginSize", "()J", "getSize", "getVersion", "()I", "component1", "component2", "component3", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "", "Companion", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes3.dex */
public final /* data */ class GkFSHeaderMeta {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final GkFSHeaderMeta EMPTY = new GkFSHeaderMeta(0, 0, 0, 6, null);
    private final long fileOriginSize;
    private final long size;
    private final int version;

    public GkFSHeaderMeta() {
        this(0, 0L, 0L, 7, null);
    }

    public static /* synthetic */ GkFSHeaderMeta copy$default(GkFSHeaderMeta gkFSHeaderMeta, int i, long j, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = gkFSHeaderMeta.version;
        }
        if ((i2 & 2) != 0) {
            j = gkFSHeaderMeta.fileOriginSize;
        }
        long j3 = j;
        if ((i2 & 4) != 0) {
            j2 = gkFSHeaderMeta.size;
        }
        return gkFSHeaderMeta.copy(i, j3, j2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getVersion() {
        return this.version;
    }

    /* renamed from: component2, reason: from getter */
    public final long getFileOriginSize() {
        return this.fileOriginSize;
    }

    /* renamed from: component3, reason: from getter */
    public final long getSize() {
        return this.size;
    }

    public final GkFSHeaderMeta copy(int version, long fileOriginSize, long size) {
        return new GkFSHeaderMeta(version, fileOriginSize, size);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GkFSHeaderMeta)) {
            return false;
        }
        GkFSHeaderMeta gkFSHeaderMeta = (GkFSHeaderMeta) other;
        return this.version == gkFSHeaderMeta.version && this.fileOriginSize == gkFSHeaderMeta.fileOriginSize && this.size == gkFSHeaderMeta.size;
    }

    public int hashCode() {
        int i = this.version * 31;
        long j = this.fileOriginSize;
        int i2 = (i + ((int) (j ^ (j >>> 32)))) * 31;
        long j2 = this.size;
        return i2 + ((int) (j2 ^ (j2 >>> 32)));
    }

    public GkFSHeaderMeta(int i, long j, long j2) {
        this.version = i;
        this.fileOriginSize = j;
        this.size = j2;
    }

    public final int getVersion() {
        return this.version;
    }

    public final long getFileOriginSize() {
        return this.fileOriginSize;
    }

    public /* synthetic */ GkFSHeaderMeta(int i, long j, long j2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 1 : i, (i2 & 2) != 0 ? 0L : j, (i2 & 4) != 0 ? 0L : j2);
    }

    public final long getSize() {
        return this.size;
    }

    /* compiled from: meta.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/gkfs/io/GkFSHeaderMeta$Companion;", "", "()V", "EMPTY", "Lcom/bytedance/gkfs/io/GkFSHeaderMeta;", "getEMPTY", "()Lcom/bytedance/gkfs/io/GkFSHeaderMeta;", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final GkFSHeaderMeta getEMPTY() {
            return GkFSHeaderMeta.EMPTY;
        }
    }

    public String toString() {
        return "GkFSFileHeaderMeta(version=" + this.version + ", fileOriginSize=" + this.fileOriginSize + ", size=" + this.size + ')';
    }
}
