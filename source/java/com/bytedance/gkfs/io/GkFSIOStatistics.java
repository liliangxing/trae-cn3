package com.bytedance.gkfs.io;

import com.bytedance.apm6.cpu.collect.ProcessCpuTracer;
import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.gkfs.storage.GkFSChunkStorageInfo;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: meta.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005¢\u0006\u0002\u0010\rJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\bHÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003JY\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u0005HÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\b\u0010+\u001a\u00020,H\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0014\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0011¨\u0006-"}, d2 = {"Lcom/bytedance/gkfs/io/GkFSIOStatistics;", "", "status", "Lcom/bytedance/gkfs/io/GkFSStatus;", "headerTimeCost", "", "headerStorageCost", "chunkStatistics", "Lcom/bytedance/gkfs/io/GkFSChunkIOStatistics;", "chunkTotalCost", "tailTimeCost", "tailStorageCost", "totalTimeCost", "(Lcom/bytedance/gkfs/io/GkFSStatus;JJLcom/bytedance/gkfs/io/GkFSChunkIOStatistics;JJJJ)V", "getChunkStatistics", "()Lcom/bytedance/gkfs/io/GkFSChunkIOStatistics;", "getChunkTotalCost", "()J", "fileDilutedStorageCost", "getFileDilutedStorageCost", "fileSize", "getFileSize", "getHeaderStorageCost", "getHeaderTimeCost", "getStatus", "()Lcom/bytedance/gkfs/io/GkFSStatus;", "getTailStorageCost", "getTailTimeCost", "getTotalTimeCost", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final /* data */ class GkFSIOStatistics {
    private final GkFSChunkIOStatistics chunkStatistics;
    private final long chunkTotalCost;
    private final long fileDilutedStorageCost;
    private final long fileSize;
    private final long headerStorageCost;
    private final long headerTimeCost;
    private final GkFSStatus status;
    private final long tailStorageCost;
    private final long tailTimeCost;
    private final long totalTimeCost;

    public GkFSIOStatistics() {
        this(null, 0L, 0L, null, 0L, 0L, 0L, 0L, ProcessCpuTracer.PROC_TERM_MASK, null);
    }

    /* renamed from: component1, reason: from getter */
    public final GkFSStatus getStatus() {
        return this.status;
    }

    /* renamed from: component2, reason: from getter */
    public final long getHeaderTimeCost() {
        return this.headerTimeCost;
    }

    /* renamed from: component3, reason: from getter */
    public final long getHeaderStorageCost() {
        return this.headerStorageCost;
    }

    /* renamed from: component4, reason: from getter */
    public final GkFSChunkIOStatistics getChunkStatistics() {
        return this.chunkStatistics;
    }

    /* renamed from: component5, reason: from getter */
    public final long getChunkTotalCost() {
        return this.chunkTotalCost;
    }

    /* renamed from: component6, reason: from getter */
    public final long getTailTimeCost() {
        return this.tailTimeCost;
    }

    /* renamed from: component7, reason: from getter */
    public final long getTailStorageCost() {
        return this.tailStorageCost;
    }

    /* renamed from: component8, reason: from getter */
    public final long getTotalTimeCost() {
        return this.totalTimeCost;
    }

    public final GkFSIOStatistics copy(GkFSStatus status, long headerTimeCost, long headerStorageCost, GkFSChunkIOStatistics chunkStatistics, long chunkTotalCost, long tailTimeCost, long tailStorageCost, long totalTimeCost) {
        Intrinsics.checkParameterIsNotNull(status, "status");
        Intrinsics.checkParameterIsNotNull(chunkStatistics, "chunkStatistics");
        return new GkFSIOStatistics(status, headerTimeCost, headerStorageCost, chunkStatistics, chunkTotalCost, tailTimeCost, tailStorageCost, totalTimeCost);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GkFSIOStatistics)) {
            return false;
        }
        GkFSIOStatistics gkFSIOStatistics = (GkFSIOStatistics) other;
        return Intrinsics.areEqual(this.status, gkFSIOStatistics.status) && this.headerTimeCost == gkFSIOStatistics.headerTimeCost && this.headerStorageCost == gkFSIOStatistics.headerStorageCost && Intrinsics.areEqual(this.chunkStatistics, gkFSIOStatistics.chunkStatistics) && this.chunkTotalCost == gkFSIOStatistics.chunkTotalCost && this.tailTimeCost == gkFSIOStatistics.tailTimeCost && this.tailStorageCost == gkFSIOStatistics.tailStorageCost && this.totalTimeCost == gkFSIOStatistics.totalTimeCost;
    }

    public int hashCode() {
        GkFSStatus gkFSStatus = this.status;
        int hashCode = gkFSStatus != null ? gkFSStatus.hashCode() : 0;
        long j = this.headerTimeCost;
        int i = ((hashCode * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        long j2 = this.headerStorageCost;
        int i2 = (i + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        GkFSChunkIOStatistics gkFSChunkIOStatistics = this.chunkStatistics;
        int hashCode2 = (i2 + (gkFSChunkIOStatistics != null ? gkFSChunkIOStatistics.hashCode() : 0)) * 31;
        long j3 = this.chunkTotalCost;
        int i3 = (hashCode2 + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        long j4 = this.tailTimeCost;
        int i4 = (i3 + ((int) (j4 ^ (j4 >>> 32)))) * 31;
        long j5 = this.tailStorageCost;
        int i5 = (i4 + ((int) (j5 ^ (j5 >>> 32)))) * 31;
        long j6 = this.totalTimeCost;
        return i5 + ((int) (j6 ^ (j6 >>> 32)));
    }

    public GkFSIOStatistics(GkFSStatus gkFSStatus, long j, long j2, GkFSChunkIOStatistics gkFSChunkIOStatistics, long j3, long j4, long j5, long j6) {
        Intrinsics.checkParameterIsNotNull(gkFSStatus, "status");
        Intrinsics.checkParameterIsNotNull(gkFSChunkIOStatistics, "chunkStatistics");
        this.status = gkFSStatus;
        this.headerTimeCost = j;
        this.headerStorageCost = j2;
        this.chunkStatistics = gkFSChunkIOStatistics;
        this.chunkTotalCost = j3;
        this.tailTimeCost = j4;
        this.tailStorageCost = j5;
        this.totalTimeCost = j6;
        Iterator<T> it = gkFSChunkIOStatistics.getStorageCost().entrySet().iterator();
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            i2 += ((GkFSChunkStorageInfo) ((Map.Entry) it.next()).getValue()).getDilutedSize();
        }
        this.fileDilutedStorageCost = j2 + i2 + this.tailStorageCost;
        long j7 = this.headerStorageCost;
        Iterator<T> it2 = this.chunkStatistics.getStorageCost().entrySet().iterator();
        while (it2.hasNext()) {
            i += ((GkFSChunkStorageInfo) ((Map.Entry) it2.next()).getValue()).getSize();
        }
        this.fileSize = j7 + i + this.tailStorageCost;
    }

    public /* synthetic */ GkFSIOStatistics(GkFSStatus gkFSStatus, long j, long j2, GkFSChunkIOStatistics gkFSChunkIOStatistics, long j3, long j4, long j5, long j6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? GkFSStatus.INSTANCE.getSUCCESS() : gkFSStatus, (i & 2) != 0 ? 0L : j, (i & 4) != 0 ? 0L : j2, (i & 8) != 0 ? GkFSChunkIOStatistics.INSTANCE.getEMPTY() : gkFSChunkIOStatistics, (i & 16) != 0 ? 0L : j3, (i & 32) != 0 ? 0L : j4, (i & 64) != 0 ? 0L : j5, (i & 128) == 0 ? j6 : 0L);
    }

    public final GkFSStatus getStatus() {
        return this.status;
    }

    public final long getHeaderTimeCost() {
        return this.headerTimeCost;
    }

    public final long getHeaderStorageCost() {
        return this.headerStorageCost;
    }

    public final GkFSChunkIOStatistics getChunkStatistics() {
        return this.chunkStatistics;
    }

    public final long getChunkTotalCost() {
        return this.chunkTotalCost;
    }

    public final long getTailTimeCost() {
        return this.tailTimeCost;
    }

    public final long getTailStorageCost() {
        return this.tailStorageCost;
    }

    public final long getTotalTimeCost() {
        return this.totalTimeCost;
    }

    public final long getFileDilutedStorageCost() {
        return this.fileDilutedStorageCost;
    }

    public final long getFileSize() {
        return this.fileSize;
    }

    public String toString() {
        return "GkFSIOStatistics(status=" + this.status + ", headerTimeCost=" + this.headerTimeCost + ", headerStorageCost=" + this.headerStorageCost + ", chunkStatistics=" + this.chunkStatistics + ", tailTimeCost=" + this.tailTimeCost + ", tailStorageCost=" + this.tailStorageCost + ", totalTimeCost=" + this.totalTimeCost + ", fileDilutedStorageCost=" + this.fileDilutedStorageCost + ')';
    }
}
