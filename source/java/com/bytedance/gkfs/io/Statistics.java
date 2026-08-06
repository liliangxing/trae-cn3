package com.bytedance.gkfs.io;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: chunk_reader.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0010\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R)\u0010\u0003\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001a\u0010\u0018\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014¨\u0006\u001b"}, d2 = {"Lcom/bytedance/gkfs/io/Statistics;", "", "()V", "chunksTimeCost", "", "Lcom/bytedance/gkfs/io/ChunkIdentifier;", "Lkotlin/Pair;", "", "getChunksTimeCost", "()Ljava/util/Map;", "parallelCacheHitCount", "", "getParallelCacheHitCount", "()I", "setParallelCacheHitCount", "(I)V", "parallelContentCost", "getParallelContentCost", "()J", "setParallelContentCost", "(J)V", "parallelIOCost", "getParallelIOCost", "setParallelIOCost", "totalTimeCost", "getTotalTimeCost", "setTotalTimeCost", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes3.dex */
public final class Statistics {
    private final Map<ChunkIdentifier, Pair<Long, Long>> chunksTimeCost = new LinkedHashMap();
    private int parallelCacheHitCount;
    private long parallelContentCost;
    private long parallelIOCost;
    private long totalTimeCost;

    public final int getParallelCacheHitCount() {
        return this.parallelCacheHitCount;
    }

    public final void setParallelCacheHitCount(int i) {
        this.parallelCacheHitCount = i;
    }

    public final long getParallelIOCost() {
        return this.parallelIOCost;
    }

    public final void setParallelIOCost(long j) {
        this.parallelIOCost = j;
    }

    public final long getParallelContentCost() {
        return this.parallelContentCost;
    }

    public final void setParallelContentCost(long j) {
        this.parallelContentCost = j;
    }

    public final Map<ChunkIdentifier, Pair<Long, Long>> getChunksTimeCost() {
        return this.chunksTimeCost;
    }

    public final long getTotalTimeCost() {
        return this.totalTimeCost;
    }

    public final void setTotalTimeCost(long j) {
        this.totalTimeCost = j;
    }
}
