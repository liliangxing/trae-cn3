package com.bytedance.gkfs.storage;

import com.bytedance.forest.model.PreloadConfig;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;

/* compiled from: GkFSChunkStorage.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001d"}, d2 = {"Lcom/bytedance/gkfs/storage/GkFSGeneralStorageInfo;", "", "fileCount", "", DBDefinition.CHUNK_COUNT, "chunkSize", "", "originSize", "dilutedSize", "(IIJJJ)V", "getChunkCount", "()I", "getChunkSize", "()J", "getDilutedSize", "getFileCount", "getOriginSize", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes3.dex */
public final /* data */ class GkFSGeneralStorageInfo {
    private final int chunkCount;
    private final long chunkSize;
    private final long dilutedSize;
    private final int fileCount;
    private final long originSize;

    /* renamed from: component1, reason: from getter */
    public final int getFileCount() {
        return this.fileCount;
    }

    /* renamed from: component2, reason: from getter */
    public final int getChunkCount() {
        return this.chunkCount;
    }

    /* renamed from: component3, reason: from getter */
    public final long getChunkSize() {
        return this.chunkSize;
    }

    /* renamed from: component4, reason: from getter */
    public final long getOriginSize() {
        return this.originSize;
    }

    /* renamed from: component5, reason: from getter */
    public final long getDilutedSize() {
        return this.dilutedSize;
    }

    public final GkFSGeneralStorageInfo copy(int fileCount, int chunkCount, long chunkSize, long originSize, long dilutedSize) {
        return new GkFSGeneralStorageInfo(fileCount, chunkCount, chunkSize, originSize, dilutedSize);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GkFSGeneralStorageInfo)) {
            return false;
        }
        GkFSGeneralStorageInfo gkFSGeneralStorageInfo = (GkFSGeneralStorageInfo) other;
        return this.fileCount == gkFSGeneralStorageInfo.fileCount && this.chunkCount == gkFSGeneralStorageInfo.chunkCount && this.chunkSize == gkFSGeneralStorageInfo.chunkSize && this.originSize == gkFSGeneralStorageInfo.originSize && this.dilutedSize == gkFSGeneralStorageInfo.dilutedSize;
    }

    public int hashCode() {
        int i = ((this.fileCount * 31) + this.chunkCount) * 31;
        long j = this.chunkSize;
        int i2 = (i + ((int) (j ^ (j >>> 32)))) * 31;
        long j2 = this.originSize;
        int i3 = (i2 + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        long j3 = this.dilutedSize;
        return i3 + ((int) (j3 ^ (j3 >>> 32)));
    }

    public String toString() {
        return "GkFSGeneralStorageInfo(fileCount=" + this.fileCount + ", chunkCount=" + this.chunkCount + ", chunkSize=" + this.chunkSize + ", originSize=" + this.originSize + ", dilutedSize=" + this.dilutedSize + ")";
    }

    public GkFSGeneralStorageInfo(int i, int i2, long j, long j2, long j3) {
        this.fileCount = i;
        this.chunkCount = i2;
        this.chunkSize = j;
        this.originSize = j2;
        this.dilutedSize = j3;
    }

    public final int getFileCount() {
        return this.fileCount;
    }

    public final int getChunkCount() {
        return this.chunkCount;
    }

    public final long getChunkSize() {
        return this.chunkSize;
    }

    public final long getOriginSize() {
        return this.originSize;
    }

    public final long getDilutedSize() {
        return this.dilutedSize;
    }
}
