package com.bytedance.gkfs.storage;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GkFSChunkStorage.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u000bHÆ\u0003JO\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010¨\u0006%"}, d2 = {"Lcom/bytedance/gkfs/storage/GkFSChunkTidyInfo;", "", "deleteChunkCount", "", "deleteChunkSize", "", "refsReduceChunkCount", "indexingCost", "ioCost", "timeCost", "generalStorageInfo", "Lcom/bytedance/gkfs/storage/GkFSGeneralStorageInfo;", "(IJIJJJLcom/bytedance/gkfs/storage/GkFSGeneralStorageInfo;)V", "getDeleteChunkCount", "()I", "getDeleteChunkSize", "()J", "getGeneralStorageInfo", "()Lcom/bytedance/gkfs/storage/GkFSGeneralStorageInfo;", "getIndexingCost", "getIoCost", "getRefsReduceChunkCount", "getTimeCost", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes3.dex */
public final /* data */ class GkFSChunkTidyInfo {
    private final int deleteChunkCount;
    private final long deleteChunkSize;
    private final GkFSGeneralStorageInfo generalStorageInfo;
    private final long indexingCost;
    private final long ioCost;
    private final int refsReduceChunkCount;
    private final long timeCost;

    /* renamed from: component1, reason: from getter */
    public final int getDeleteChunkCount() {
        return this.deleteChunkCount;
    }

    /* renamed from: component2, reason: from getter */
    public final long getDeleteChunkSize() {
        return this.deleteChunkSize;
    }

    /* renamed from: component3, reason: from getter */
    public final int getRefsReduceChunkCount() {
        return this.refsReduceChunkCount;
    }

    /* renamed from: component4, reason: from getter */
    public final long getIndexingCost() {
        return this.indexingCost;
    }

    /* renamed from: component5, reason: from getter */
    public final long getIoCost() {
        return this.ioCost;
    }

    /* renamed from: component6, reason: from getter */
    public final long getTimeCost() {
        return this.timeCost;
    }

    /* renamed from: component7, reason: from getter */
    public final GkFSGeneralStorageInfo getGeneralStorageInfo() {
        return this.generalStorageInfo;
    }

    public final GkFSChunkTidyInfo copy(int deleteChunkCount, long deleteChunkSize, int refsReduceChunkCount, long indexingCost, long ioCost, long timeCost, GkFSGeneralStorageInfo generalStorageInfo) {
        Intrinsics.checkParameterIsNotNull(generalStorageInfo, "generalStorageInfo");
        return new GkFSChunkTidyInfo(deleteChunkCount, deleteChunkSize, refsReduceChunkCount, indexingCost, ioCost, timeCost, generalStorageInfo);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GkFSChunkTidyInfo)) {
            return false;
        }
        GkFSChunkTidyInfo gkFSChunkTidyInfo = (GkFSChunkTidyInfo) other;
        return this.deleteChunkCount == gkFSChunkTidyInfo.deleteChunkCount && this.deleteChunkSize == gkFSChunkTidyInfo.deleteChunkSize && this.refsReduceChunkCount == gkFSChunkTidyInfo.refsReduceChunkCount && this.indexingCost == gkFSChunkTidyInfo.indexingCost && this.ioCost == gkFSChunkTidyInfo.ioCost && this.timeCost == gkFSChunkTidyInfo.timeCost && Intrinsics.areEqual(this.generalStorageInfo, gkFSChunkTidyInfo.generalStorageInfo);
    }

    public int hashCode() {
        int i = this.deleteChunkCount * 31;
        long j = this.deleteChunkSize;
        int i2 = (((i + ((int) (j ^ (j >>> 32)))) * 31) + this.refsReduceChunkCount) * 31;
        long j2 = this.indexingCost;
        int i3 = (i2 + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        long j3 = this.ioCost;
        int i4 = (i3 + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        long j4 = this.timeCost;
        int i5 = (i4 + ((int) (j4 ^ (j4 >>> 32)))) * 31;
        GkFSGeneralStorageInfo gkFSGeneralStorageInfo = this.generalStorageInfo;
        return i5 + (gkFSGeneralStorageInfo != null ? gkFSGeneralStorageInfo.hashCode() : 0);
    }

    public String toString() {
        return "GkFSChunkTidyInfo(deleteChunkCount=" + this.deleteChunkCount + ", deleteChunkSize=" + this.deleteChunkSize + ", refsReduceChunkCount=" + this.refsReduceChunkCount + ", indexingCost=" + this.indexingCost + ", ioCost=" + this.ioCost + ", timeCost=" + this.timeCost + ", generalStorageInfo=" + this.generalStorageInfo + ")";
    }

    public GkFSChunkTidyInfo(int i, long j, int i2, long j2, long j3, long j4, GkFSGeneralStorageInfo generalStorageInfo) {
        Intrinsics.checkParameterIsNotNull(generalStorageInfo, "generalStorageInfo");
        this.deleteChunkCount = i;
        this.deleteChunkSize = j;
        this.refsReduceChunkCount = i2;
        this.indexingCost = j2;
        this.ioCost = j3;
        this.timeCost = j4;
        this.generalStorageInfo = generalStorageInfo;
    }

    public final int getDeleteChunkCount() {
        return this.deleteChunkCount;
    }

    public final long getDeleteChunkSize() {
        return this.deleteChunkSize;
    }

    public final int getRefsReduceChunkCount() {
        return this.refsReduceChunkCount;
    }

    public final long getIndexingCost() {
        return this.indexingCost;
    }

    public final long getIoCost() {
        return this.ioCost;
    }

    public final long getTimeCost() {
        return this.timeCost;
    }

    public final GkFSGeneralStorageInfo getGeneralStorageInfo() {
        return this.generalStorageInfo;
    }
}
